package cn.dmdream.dao;

import cn.dmdream.entity.AddressEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressDao extends JpaRepositoryImplementation<AddressEntity,Integer> {

    List<AddressEntity> findByParent(Integer parentId);

    List<AddressEntity> findByAreaName(String areaName);
}
