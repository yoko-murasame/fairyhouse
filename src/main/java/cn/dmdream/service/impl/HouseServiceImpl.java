package cn.dmdream.service.impl;

import cn.dmdream.dao.HouseDao;
import cn.dmdream.entity.HouseEntity;
import cn.dmdream.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
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

    /**
     * 动态创建条件
     */
    private Specification<HouseEntity> getWhereClause(final HouseEntity house) {
        return new Specification<HouseEntity>() {
            @Override
            public Predicate toPredicate(Root<HouseEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
    }
}
