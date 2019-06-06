package cn.dmdream.dao;

import cn.dmdream.entity.ClientEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepositoryImplementation<ClientEntity, Integer> {
    ClientEntity findByPhoneIs(String phone);
}
