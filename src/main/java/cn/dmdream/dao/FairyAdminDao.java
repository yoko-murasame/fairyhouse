package cn.dmdream.dao;

import cn.dmdream.entity.FairyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FairyAdminDao extends JpaRepository<FairyAdmin,Integer> {

    //public Integer save(FairyAdmin admin);
}
