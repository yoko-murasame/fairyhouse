package cn.dmdream.dao;

import cn.dmdream.entity.AgentEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentDao extends JpaRepositoryImplementation<AgentEntity, Integer> {
    AgentEntity findByPhoneIs(String phone);
}
