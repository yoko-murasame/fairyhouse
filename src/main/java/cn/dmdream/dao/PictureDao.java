package cn.dmdream.dao;

import cn.dmdream.entity.PictureEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureDao extends JpaRepositoryImplementation<PictureEntity, Integer> {

}
