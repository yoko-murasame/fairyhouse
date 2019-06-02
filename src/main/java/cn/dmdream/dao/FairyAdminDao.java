package cn.dmdream.dao;

import cn.dmdream.entity.FairyAdmin;
import cn.dmdream.entity.FairyCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FairyAdminDao extends JpaRepository<FairyAdmin,Integer> {//两个参数，一个是对应的实体类，一个是该实体类主键的类型

    //自定义方法，使用Jpa标准化查询语言
    public FairyAdmin findByAdminUsername(String username);

    //使用原生的sql进行查询
    @Query(value = "select * from tab_admin a,tab_cat c where a.adminId=c.admin_adminId and a.adminUsername like " +
            "%?1%",nativeQuery = true)
    public List<FairyAdmin> myFindAllByUsernameLike(String username);

    //使用JPQL查询
    @Query(value = "select a,c from FairyAdmin a,FairyCat c where a.adminId=c.admin.adminId and a.adminUsername like " +
            "%?1%")
    public List<FairyAdmin> myFindAllByUsernameLike_JPQL(String username);

}
