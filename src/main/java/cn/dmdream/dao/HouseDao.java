package cn.dmdream.dao;

import cn.dmdream.entity.CommunityEntity;
import cn.dmdream.entity.HouseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseDao extends JpaRepositoryImplementation<HouseEntity, Long> {

}
