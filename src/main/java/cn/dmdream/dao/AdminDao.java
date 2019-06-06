package cn.dmdream.dao;

import cn.dmdream.entity.AdminEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao extends JpaRepositoryImplementation<AdminEntity,Integer> {//两个参数，一个是对应的实体类，一个是该实体类主键的类型

    AdminEntity findByUsernameIsAndPasswordIs(String username, String password);

    AdminEntity findByPhoneIsAndPasswordIs(String phone, String password);
}

