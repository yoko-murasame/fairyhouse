package cn.dmdream.dao;

import cn.dmdream.entity.FairyAdmin;
import cn.dmdream.entity.FairyCat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyAndReverseTest {

    @Autowired
    FairyAdminDao fairyAdminDao;

    @Autowired
    FairyCatDao fairyCatDao;

    /**
     * 将维护方对象添加到被维护方集合
     * 保存被维护方对象
     */
    @Test
    public void 一对多插入1() {
        FairyAdmin admin = new FairyAdmin();
        admin.setAdminUsername("admin");
        admin.setAdminPassword("123");
        admin.setAdminNickname("yoko");
        FairyCat cat = new FairyCat();
        cat.setCatName("Tom");
        FairyCat cat1 = new FairyCat();
        cat1.setCatName("Miki");
        admin.getCatList().add(cat);
        admin.getCatList().add(cat1);
        fairyAdminDao.save(admin);//保存结果：双方都插入了对象，但是维护方（cat）没有外键
    }

    /**
     *  将被维护方对象设置到维护方对象中
     *  仅保存维护方对象
     */
    @Test
    public void 多对一插入2() {
        FairyAdmin admin = new FairyAdmin();//被维护方
        admin.setAdminUsername("admin2");
        admin.setAdminPassword("123");
        admin.setAdminNickname("yoko");
        FairyCat cat = new FairyCat();//维护方
        cat.setCatName("Kuku");
        cat.setAdmin(admin);
        fairyCatDao.save(cat);//保存结果：双方都插入了对象，并且维护方有外键
    }

    /**
     * 将双方对象互相保存
     * 仅保存被维护方（admin）对象
     */
    @Test
    public void 一对多插入3() {
        FairyAdmin admin = new FairyAdmin();
        admin.setAdminUsername("admin3");
        admin.setAdminPassword("123");
        admin.setAdminNickname("yoko");
        FairyCat cat = new FairyCat();
        cat.setCatName("Tom2");
        cat.setAdmin(admin);
        FairyCat cat1 = new FairyCat();
        cat1.setCatName("Miki2");
        cat1.setAdmin(admin);
        admin.getCatList().add(cat);
        admin.getCatList().add(cat1);
        fairyAdminDao.save(admin);//保存结果：设置了双向关联，即便插入对象是被维护方，2张表都有数据并且维护方（cat）中有外键
    }

    /**
     * 删除维护方对象，这里维护方（cat）未设置级联删除
     */
    @Test
    public void 多对一删除1() {
        FairyCat cat = fairyCatDao.findByCatName("Kuku");
        System.out.println(cat);
        cat.getAdmin().getCatList().remove(cat);//由于二级缓存机制，要清空级联对象中的自己对象，要不无法删除，不会有删除语句
        //可以看到在进行上一步设置后，成功有了删除语句delete from tab_cat where catId=?
        fairyCatDao.delete(cat);//删除结果：由于未设置级联删除，即便删除的是维护方对象，也只删除了自己，不能删除Admin
    }

    /**
     * 删除被维护方对象，这里被维护方（一的一方，admin）设置了全部级联
     */
    @Test
    public void 一对多删除2() {
        //FairyAdmin admin = fairyAdminDao.findByAdminUsername("admin");
        FairyAdmin admin3 = fairyAdminDao.findByAdminUsername("admin3");
        System.out.println(admin3);
        fairyAdminDao.delete(admin3);//虽然删除的是被维护端对象，但是设置了级联删除，能顺利删除两张表的数据，这里没有缓存机制作祟
    }

}
