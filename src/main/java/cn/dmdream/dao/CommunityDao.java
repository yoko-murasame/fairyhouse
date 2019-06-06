package cn.dmdream.dao;

import cn.dmdream.entity.CommunityEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityDao extends JpaRepositoryImplementation<CommunityEntity, Long> {

}
