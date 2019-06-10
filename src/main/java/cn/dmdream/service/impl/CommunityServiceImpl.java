package cn.dmdream.service.impl;


import cn.dmdream.dao.CommunityDao;
import cn.dmdream.entity.AddressEntity;
import cn.dmdream.entity.CommunityEntity;
import cn.dmdream.entity.HouseEntity;
import cn.dmdream.service.CommunityService;
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
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityDao communityDao;

    @Override
    public CommunityEntity save(CommunityEntity communityEntity) {

        try {
            CommunityEntity save = communityDao.save(communityEntity);
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveAll(Iterable<CommunityEntity> communityEntities) {

        try {
            communityDao.saveAll(communityEntities);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(CommunityEntity communityEntity) {

        try {
            communityDao.delete(communityEntity);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {

        try {
            communityDao.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAll(Iterable<CommunityEntity> communityEntities) {

        try {
            communityDao.deleteAll(communityEntities);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CommunityEntity update(CommunityEntity communityEntity) {

        try {
            CommunityEntity update = communityDao.saveAndFlush(communityEntity);

            return update;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Page<CommunityEntity> findByCommunityByPage(CommunityEntity communityEntity, Sort sort, Integer page, Integer pageSize) {

        try {
            PageRequest pageRequest = PageRequest.of(page - 1, pageSize, sort);
            Page<CommunityEntity> pageModel = communityDao.findAll(getWhereClause(communityEntity), pageRequest);
            return pageModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 动态创建条件
     */
    private Specification<CommunityEntity> getWhereClause(final CommunityEntity comm) {
        return new Specification<CommunityEntity>() {
            @Override
            public Predicate toPredicate(Root<CommunityEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                //地址head查询
                if (!EmptyUtils.isEmpty(comm.getAddressHead())) {
                    Join<CommunityEntity, AddressEntity> entityJoin = root.join("addressHead", JoinType.LEFT);
                    predicates.add(cb.like(entityJoin.get("areaName").as(String.class), "%"+comm.getAddressHead().getAreaName()+"%"));
                }

                Predicate[] array = new Predicate[predicates.size()];
                return query.where(predicates.toArray(array)).getRestriction();
            }
        };
    }
}
