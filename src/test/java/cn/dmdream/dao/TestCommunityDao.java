package cn.dmdream.dao;

import cn.dmdream.entity.AddressEntity;
import cn.dmdream.entity.CommunityEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCommunityDao {

    @Autowired
    private CommunityDao communityDao;
    @Autowired
    private AddressDao addressDao;

    @Test
    public void saveTest() {
        List<AddressEntity> list = addressDao.findByAreaNameLike("%江干%");
        System.out.println(list.get(0).getAreaId());

        CommunityEntity community = new CommunityEntity();
        //设置地址head
        community.setAddressHead(list.get(0));
        //设置地址
        community.setAddress("金沙湖天街305号");
        //设置经纬度
        community.setLatitude(30.2741500000);
        community.setLongitude(120.1551500000);

        CommunityEntity sav = communityDao.save(community);
        System.out.println(sav);

    }
}
