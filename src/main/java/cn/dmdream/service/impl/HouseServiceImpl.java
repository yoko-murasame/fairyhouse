package cn.dmdream.service.impl;

import cn.dmdream.dao.HouseDao;
import cn.dmdream.entity.AddressEntity;
import cn.dmdream.entity.CommunityEntity;
import cn.dmdream.entity.DictEntity;
import cn.dmdream.entity.HouseEntity;
import cn.dmdream.service.HouseService;
import cn.dmdream.utils.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;

    @Override
    public HouseEntity save(HouseEntity houseEntity) {

        try {
            HouseEntity save = houseDao.save(houseEntity);
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveAll(Iterable<HouseEntity> houseEntities) {

        try {
            List<HouseEntity> list = houseDao.saveAll(houseEntities);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(HouseEntity houseEntity) {

        try {
            houseDao.delete(houseEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            houseDao.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAll(Iterable<HouseEntity> houseEntities) {
        try {
            houseDao.deleteAll(houseEntities);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public HouseEntity update(HouseEntity houseEntity) {

        try {
            HouseEntity updated = houseDao.saveAndFlush(houseEntity);
            return updated;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询方法
     * @param houseEntity
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Page<HouseEntity> findByHouseByPage(HouseEntity houseEntity, Sort sort, Integer page, Integer pageSize) {

        try {
            PageRequest pageRequest = PageRequest.of(page - 1, pageSize, sort);
            Specification<HouseEntity> specification = getWhereClause(houseEntity);
            Page<HouseEntity> pageModel = houseDao.findAll(specification, pageRequest);
            return pageModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public HouseEntity findById(Long id) {

        try {
            HouseEntity house = houseDao.findById(id).get();

            return house;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 动态创建条件
     */
    private Specification<HouseEntity> getWhereClause(final HouseEntity house) {
        return new Specification<HouseEntity>() {
            @Override
            public Predicate toPredicate(Root<HouseEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                //地址head查询
                //三个判空操作
                if (!EmptyUtils.isEmpty(house.getCommunityEntity())&&!EmptyUtils.isEmpty(house.getCommunityEntity().getAddressHead()) && !EmptyUtils.isEmpty(house.getCommunityEntity().getAddressHead().getAreaName())) {
                    Join<HouseEntity, CommunityEntity> entityJoin = root.join("communityEntity", JoinType.LEFT);
                    Join<Object, AddressEntity> JoinThird = entityJoin.join("addressHead", JoinType.LEFT);
                    predicates.add(cb.like(JoinThird.get("areaName").as(String.class), "%"+house.getCommunityEntity().getAddressHead().getAreaName()+"%"));
                }
                //售价范围
                if (!EmptyUtils.isEmpty(house.getPriceType()) && !EmptyUtils.isEmpty(house.getPriceType().getId())) {
                    Join<HouseEntity, DictEntity> join = root.join("priceType", JoinType.LEFT);
                    predicates.add(cb.equal(join.get("id").as(Long.class), house.getPriceType().getId()));
                }
                //房屋类型
                if (!EmptyUtils.isEmpty(house.getHouseType()) && !EmptyUtils.isEmpty(house.getHouseType().getId())) {
                    Join<HouseEntity, DictEntity> join = root.join("houseType", JoinType.LEFT);
                    predicates.add(cb.equal(join.get("id").as(Long.class), house.getHouseType().getId()));
                }
                //面积类型
                if (!EmptyUtils.isEmpty(house.getAreaType()) && !EmptyUtils.isEmpty(house.getAreaType().getId())) {
                    Join<HouseEntity, DictEntity> join = root.join("areaType", JoinType.LEFT);
                    predicates.add(cb.equal(join.get("id").as(Long.class), house.getAreaType().getId()));
                }
                //楼层类型
                if (!EmptyUtils.isEmpty(house.getFloorType()) && !EmptyUtils.isEmpty(house.getFloorType().getId())) {
                    Join<HouseEntity, DictEntity> join = root.join("floorType", JoinType.LEFT);
                    predicates.add(cb.equal(join.get("id").as(Long.class), house.getFloorType().getId()));
                }
                //房屋朝向
                if (!EmptyUtils.isEmpty(house.getOrieType()) && !EmptyUtils.isEmpty(house.getOrieType().getId())) {
                    Join<HouseEntity, DictEntity> join = root.join("orieType", JoinType.LEFT);
                    predicates.add(cb.equal(join.get("id").as(Long.class), house.getOrieType().getId()));
                }
                //楼龄
                if (!EmptyUtils.isEmpty(house.getAgeType()) && !EmptyUtils.isEmpty(house.getAgeType().getId())) {
                    Join<HouseEntity, DictEntity> join = root.join("ageType", JoinType.LEFT);
                    predicates.add(cb.equal(join.get("id").as(Long.class), house.getAgeType().getId()));
                }

                Predicate[] array = new Predicate[predicates.size()];
                return query.where(predicates.toArray(array)).getRestriction();
            }
        };
    }
}
