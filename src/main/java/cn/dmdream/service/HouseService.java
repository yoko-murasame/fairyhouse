package cn.dmdream.service;

import cn.dmdream.entity.HouseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface HouseService {

    HouseEntity save(HouseEntity houseEntity);

    boolean saveAll(Iterable<HouseEntity> houseEntities);

    boolean delete(HouseEntity houseEntity);

    boolean deleteById(Long id);

    boolean deleteAll(Iterable<HouseEntity> houseEntities);

    HouseEntity update(HouseEntity houseEntity);

    Page<HouseEntity> findByHouseByPage(HouseEntity houseEntity, Sort sort, Integer page, Integer pageSize);

}
