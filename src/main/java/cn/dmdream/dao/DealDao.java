package cn.dmdream.dao;

import cn.dmdream.entity.DealEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface DealDao extends JpaRepositoryImplementation<DealEntity, Long> {

}
