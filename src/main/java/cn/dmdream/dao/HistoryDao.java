package cn.dmdream.dao;

import cn.dmdream.entity.HistoryEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryDao extends JpaRepositoryImplementation<HistoryEntity, Long> {

}
