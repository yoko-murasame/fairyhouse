package cn.dmdream.dao;

import cn.dmdream.entity.EvaluationEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationDao extends JpaRepositoryImplementation<EvaluationEntity, Long> {

}
