package cn.dmdream.service.impl;

import cn.dmdream.dao.AgentDao;
import cn.dmdream.entity.AgentEntity;
import cn.dmdream.service.AgentService;
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
    public Page<AgentEntity> findAllByPage(AgentEntity agent, Integer page, Integer pageSize) {

        //1.创建排序
        Sort sort = Sort.by(Sort.Direction.ASC,"score");
        //2.创建分页对象,page是从0开始
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, sort);
        //3.查询<1.条件对象:下面的方法已经封装好 2.page对象:里面有分页信息和排序信息> 返回pageBean
        Page<AgentEntity> pageModel = agentDao.findAll(getWhereClause(agent), pageRequest);
        return pageModel;
    }

    /**
     * 动态创建条件
     */
    private Specification<AgentEntity> getWhereClause(final AgentEntity searchAgent) {
        return new Specification<AgentEntity>() {
            @Override
            public Predicate toPredicate(Root<AgentEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                //1.创建条件列表
                List<Predicate> predicates = new ArrayList<Predicate>();
                //2.遍历对象依次增加条件
                //2.1.按评分score条件
                //if (searchAgent.getScore()!=0)

                //2.2.按手机号phone

                //2.3.按用户名username模糊查询

                //2.4.按真实姓名realname模糊查询

                //2.5.按级别grade

                //2.6.按能力值abilityTag

                //2.7.按服务平台年限seniority

                //2.8.按主营板块major

                return null;
            }
        };
    }
}
