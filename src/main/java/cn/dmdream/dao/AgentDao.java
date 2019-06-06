package cn.dmdream.dao;

import cn.dmdream.entity.AgentEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentDao extends JpaRepositoryImplementation<AgentEntity, Long> {
    AgentEntity findByPhoneIs(String phone);
}
