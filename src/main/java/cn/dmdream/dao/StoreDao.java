package cn.dmdream.dao;

import cn.dmdream.entity.StoreEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDao extends JpaRepositoryImplementation<StoreEntity, Integer> {

}
