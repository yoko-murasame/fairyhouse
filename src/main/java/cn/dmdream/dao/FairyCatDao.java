package cn.dmdream.dao;

import cn.dmdream.entity.FairyCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FairyCatDao extends JpaRepository<FairyCat,Integer> {

    public FairyCat findByCatName(String name);
}
