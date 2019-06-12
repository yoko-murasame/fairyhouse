package cn.dmdream.service.impl;

import cn.dmdream.dao.AgentDao;
import cn.dmdream.entity.AgentEntity;
import cn.dmdream.entity.DictEntity;
import cn.dmdream.service.AgentService;
import cn.dmdream.utils.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentDao agentDao;

    @Override
    public Boolean deleteById(Long id) {
        try {
            agentDao.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteAll(Iterable agents) {
        try {
            agentDao.deleteAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public AgentEntity update(AgentEntity agent) {
        try {
            AgentEntity agentEntity = agentDao.saveAndFlush(agent);
            return agentEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public AgentEntity save(AgentEntity agent) {
        try {
            AgentEntity save = agentDao.save(agent);
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean saveAll(Iterable agents) {
        try {
            agentDao.saveAll(agents);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public AgentEntity findById(Long id) {
        try {
            return agentDao.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Page<AgentEntity> findAllByPage(AgentEntity agent,Sort sort, Integer page, Integer pageSize) {

        //1.创建排序，交给Controller创建了
        //2.创建分页对象,page是从0开始
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, sort);
        //3.查询<1.条件对象:下面的方法getWhereClause已经封装好 2.page对象:里面有分页信息和排序信息> 返回pageBean
        Page<AgentEntity> pageModel = agentDao.findAll(getWhereClause(agent), pageRequest);
        return pageModel;
    }

    /**
     * 动态创建条件
     */
    private Specification<AgentEntity> getWhereClause(final AgentEntity searchAgent) {
        return new Specification<AgentEntity>() {
            @Override
            public Predicate toPredicate(Root<AgentEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                //1.创建条件列表
                List<Predicate> predicates = new ArrayList<Predicate>();
                //2.遍历对象依次增加条件

                //-----普通字段开始-----
                //2.1.按评分score条件
                if (!EmptyUtils.isEmpty(searchAgent.getScore())) {
                    predicates.add(cb.equal(root.get("score").as(Double.class), searchAgent.getScore()));
                }
                //2.2.按手机号phone
                if (!EmptyUtils.isEmpty(searchAgent.getPhone())) {
                    predicates.add(cb.equal(root.get("phone").as(String.class), searchAgent.getPhone()));
                }
                //2.3.按用户名username模糊查询
                if (!EmptyUtils.isEmpty(searchAgent.getUsername())) {
                    predicates.add(cb.like(root.get("username").as(String.class),"%"+searchAgent.getUsername()+"%"));
                }
                //2.4.按真实姓名realname模糊查询
                if (!EmptyUtils.isEmpty(searchAgent.getRealname())) {
                    predicates.add(cb.like(root.get("realname").as(String.class), "%"+searchAgent.getRealname()+"%"));
                }
                //-----普通字段结束-----

                //-----一对一的实体属性开始-----
                //2.5.按级别grade
                if (!EmptyUtils.isEmpty(searchAgent.getGrade())) {
                    Join<AgentEntity,DictEntity> entityJoin = root.join("grade",JoinType.LEFT);
                    //方式一：做好左外连接后，根据连接实体中的id（实际上是DictEntity的id）获取表达式
                    predicates.add(cb.equal(entityJoin.get("id").as(Long.class), searchAgent.getGrade().getId()));
                }
                //2.6.按能力值abilityTag
                if (!EmptyUtils.isEmpty(searchAgent.getAbilityTag())) {
                    Join<AgentEntity,DictEntity> entityJoin = root.join("abilityTag",JoinType.LEFT);
                    //方式二：做好左外连接后，直接根据连接实体的类获取表达式，后面几个字段均用此方式
                    predicates.add(cb.equal(root.get("abilityTag").as(DictEntity.class), searchAgent.getAbilityTag()
                            .getId()));
                }
                //2.7.按服务平台年限seniority
                if (!EmptyUtils.isEmpty(searchAgent.getSeniority())) {
                    Join<AgentEntity,DictEntity> entityJoin = root.join("seniority",JoinType.LEFT);
                    predicates.add(cb.equal(root.get("seniority").as(DictEntity.class), searchAgent.getSeniority()
                            .getId()));
                }
                //2.8.按主营板块major
                if (!EmptyUtils.isEmpty(searchAgent.getMajor())) {
                    Join<AgentEntity,DictEntity> entityJoin = root.join("major",JoinType.LEFT);
                    predicates.add(cb.equal(root.get("major").as(DictEntity.class), searchAgent.getMajor().getId()));
                }
                //-----一对一的实体属性结束-----

                //3.将条件转化返回
                Predicate[] predicateArray = new Predicate[predicates.size()];
                return query.where(predicates.toArray(predicateArray)).getRestriction();
            }
        };
    }
}
