package cn.dmdream.Service;

import cn.dmdream.dao.AddressDao;
import cn.dmdream.dao.ClientDao;
import cn.dmdream.dao.CommunityDao;
import cn.dmdream.entity.AddressEntity;
import cn.dmdream.entity.ClientEntity;
import cn.dmdream.entity.CommunityEntity;
import cn.dmdream.entity.HouseEntity;
import cn.dmdream.service.HouseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHouseService {

    @Autowired
    private HouseService houseService;
    @Autowired
    private CommunityDao communityDao;
    @Autowired
    private ClientDao clientDao;

    @Test
    public void saveTest() {
        ClientEntity client = clientDao.findById(24l).get();

        CommunityEntity communityEntity = communityDao.findById(31l).get();

        HouseEntity house = new HouseEntity();
        //所属者
        house.setHouseOwner(client);
        //小区
        house.setCommunityEntity(communityEntity);
        //设置房屋zhuangtai
        house.setStatus(1);
        //设置经纬度
        house.setLatitude(30.2741500000);
        house.setLongitude(120.1551500000);
        //设置详细地址
        house.setAddress("14楼6XX");
        //价格
        house.setPrice(new BigDecimal(2000000));
        //面积
        house.setArea(143.3);
        //所在楼层
        house.setFloor(15);
        //房龄
        house.setAge(3);

        //保存
        HouseEntity save = houseService.save(house);
        System.out.println(save);
    }

    @Test
    public void findTest() {
        String keyword = "西湖";
        String order = "DESC";
        String sortField = "createTime";
        //实体查询部分
        AddressEntity addressEntity = new AddressEntity();
        //地址关键字查询
        addressEntity.setAreaName(keyword);
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.setAddressHead(addressEntity);
        //house对象
        HouseEntity house = new HouseEntity();
        house.setCommunityEntity(communityEntity);

        Sort sort = null;
        //设置排序,三个循环防止判断攻击
        if (order.equalsIgnoreCase("DESC")) {
            sort = Sort.by(Sort.Direction.DESC, sortField);
        } else if (order.equalsIgnoreCase("ASC")) {
            sort = Sort.by(Sort.Direction.ASC, sortField);
        } else {
            sort = Sort.by(Sort.Direction.DESC, sortField);
        }

        System.out.println(sortField);
        System.out.println(order);

        Page<HouseEntity> pageModel = houseService.findByHouseByPage(house, sort, 1, 10);


        List<HouseEntity> list = pageModel.getContent();
        for (HouseEntity h :
                list) {
            System.out.println(h);
            System.out.println(h.getCommunityEntity().getAddressHead().getAreaName());
        }
    }
}
