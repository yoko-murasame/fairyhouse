package cn.dmdream.dao;

import cn.dmdream.entity.FairyAdmin;
import cn.dmdream.entity.FairyCat;
import cn.dmdream.utils.JpaConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfiguration.class)
@TestPropertySource(locations = {"classpath:application.properties"})
public class JpaTest {

    @Autowired
    FairyAdminDao fairyAdminDao;

    @Autowired
    FairyCatDao fairyCatDao;

    @Test
    public void  saveTest(){
        FairyAdmin admin = new FairyAdmin();
        admin.setAdminUsername("admin6");
        admin.setAdminPassword("123");
        admin.setAdminNickname("yoko");

        FairyCat cat = new FairyCat();
        cat.setCatName("Tom2");
        cat.setAdmin(admin);
        FairyCat cat1 = new FairyCat();
        cat1.setCatName("Miki2");
        cat1.setAdmin(admin);
        ArrayList<FairyCat> list = new ArrayList<>();
        list.add(cat);
        list.add(cat1);

        admin.setCatList(list);

        fairyAdminDao.save(admin);
    }

    @Test
    public void testDelete(){
        FairyAdmin admin = new FairyAdmin();
        FairyCat cat = new FairyCat();
        cat.setCatName("Tom2");
        cat.setAdmin(admin);
        FairyCat cat1 = new FairyCat();
        cat1.setCatName("Miki2");
        cat1.setAdmin(admin);
        ArrayList<FairyCat> list = new ArrayList<>();
        list.add(cat);
        list.add(cat1);
        admin.setAdminId(3);
        fairyAdminDao.delete(admin);
    }

    @Test
    public void testFindById(){
        Optional<FairyAdmin> optionalFairyAdmin = fairyAdminDao.findById(2);
        FairyAdmin fairyAdmin = optionalFairyAdmin.get();
        System.out.println("=====================================================");
        System.out.println(fairyAdmin);
        System.out.println("=====================================================");
    }

    @Test
    public void testFindCatById(){
        Optional<FairyCat> catOp = fairyCatDao.findById(2);
        FairyCat cat = catOp.get();
        System.out.println("=====================================================");
        System.out.println(cat);
        System.out.println("=====================================================");
    }

}
