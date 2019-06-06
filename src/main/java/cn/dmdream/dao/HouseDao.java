package cn.dmdream.dao;

import cn.dmdream.entity.HouseEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseDao extends JpaRepositoryImplementation<HouseEntity, Long> {

}
