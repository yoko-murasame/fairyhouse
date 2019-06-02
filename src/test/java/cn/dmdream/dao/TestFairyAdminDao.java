package cn.dmdream.dao;

import cn.dmdream.entity.FairyAdmin;
import cn.dmdream.entity.FairyCat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)//指定测试运行类
@SpringBootTest(properties = {"classpath:application.properties"})//使用springboot测试
public class TestFairyAdminDao {

    @Autowired
    private FairyAdminDao fairyAdminDao;
    @Autowired
    private  FairyCatDao fairyCatDao;

    @Test//新增
    public void saveTest() {
        FairyAdmin admin = new FairyAdmin();
        admin.setAdminUsername("yoko");
        FairyCat cat = new FairyCat();
        cat.setCatName("yoko_Cat");
        cat.setAdmin(admin);//双向关联保存
        admin.getCatList().add(cat);
        fairyAdminDao.save(admin);
    }

    //按用户名查询
    @Test
    public void findByUsernameTest() {
        FairyAdmin admin = fairyAdminDao.findByAdminUsername("yoko");
        System.out.println(admin);
        System.out.println(admin.getCatList());//关联查询
    }

    //修改
    @Test
    public void updateTest() {
        FairyAdmin admin = fairyAdminDao.findByAdminUsername("yoko");
        admin.setAdminNickname("yokoNicname");
        admin.setAdminPassword("yokoPassword");
        admin.getCatList().get(0).setCatName("yoko_cat_edit1");
        fairyAdminDao.save(admin);//这里会自动根据主键判断是否是更新
    }

    //删除
    @Test
    public void deleteTest() {
        FairyAdmin admin = fairyAdminDao.findByAdminUsername("yoko");
        fairyAdminDao.delete(admin);//级联删除，猫也会被删除
    }

    //批量保存
    @Test
    public void saveListTest() {
        List<FairyAdmin> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            FairyAdmin admin = new FairyAdmin();
            admin.setAdminUsername("yoko_" + i);
            FairyCat cat = new FairyCat();
            cat.setCatName("yoko_cat_" + i);
            cat.setAdmin(admin);//双向关联保存
            admin.getCatList().add(cat);
            list.add(admin);
        }
        fairyAdminDao.saveAll(list);
    }

    //查询所有
    @Test
    public void findAllTest() {
        List<FairyAdmin> list = fairyAdminDao.findAll();
        list.forEach(System.out::println);
    }

    //原生查询语句测试
    @Test
    public void myFindAllByUsernameLikeTest() {
        List<FairyAdmin> list = fairyAdminDao.myFindAllByUsernameLike("yoko_1");
        list.forEach(System.out::println);
    }

    //JPQL查询语句测试
    @Test
    public void myFindAllByUsernameLike_JPQLTest() {
        List<FairyAdmin> list = fairyAdminDao.myFindAllByUsernameLike_JPQL("yoko_1");
        list.forEach(System.out::println);
    }

}
