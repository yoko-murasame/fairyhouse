package cn.dmdream.controller;

import cn.dmdream.entity.AddressEntity;
import cn.dmdream.entity.CommunityEntity;
import cn.dmdream.entity.DictEntity;
import cn.dmdream.entity.HouseEntity;
import cn.dmdream.service.CommunityService;
import cn.dmdream.service.DictService;
import cn.dmdream.service.HouseService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/second")
public class SecondHouseController {

    @Autowired
    private HouseService houseService;
    @Autowired
    private CommunityService communityService;
    @Autowired
    private DictService dictService;
    @Autowired
    private RedisTemplate redisTemplate;

    //首页搜索进入二手房列表
    @RequestMapping("toSecondList")
    public ModelAndView toSecondListPage(String keyword, @RequestParam(value = "sortField", defaultValue = "createTime") String sortField, @RequestParam(defaultValue = "DESC") String order) {
        System.out.println(keyword);


        //初始化houseDict
        Map<String, List<DictEntity>> dictMap = null;
        try {
            dictMap = (Map<String, List<DictEntity>>) redisTemplate.opsForValue().get("houseDict");
            if (dictMap == null) {
                dictMap = this.handleSearchMap();
                System.out.println("字典表从数据库查询的");
                redisTemplate.opsForValue().set("houseDict",dictMap);
            } else {
                System.out.println("字典表从Redis查询的");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dictMap);

        //实体查询部分
        AddressEntity addressEntity = new AddressEntity();
        //地址关键字查询
        addressEntity.setAreaName(keyword);
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.setAddressHead(addressEntity);
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

        Page<CommunityEntity> pageModel = communityService.findByCommunityByPage(communityEntity, sort, 1, 10);

        List<CommunityEntity> list = pageModel.getContent();
        for (CommunityEntity comm :
                list) {
            System.out.println(comm);
            System.out.println(comm.getAddressHead().getAreaName());
            System.out.println("==========");
            Set<HouseEntity> houseEntities = comm.getHouseEntities();
            for (HouseEntity houseEntity : houseEntities) {
                System.out.println("------------");
                System.out.println(houseEntity);
                System.out.println("------------");
                System.out.println(houseEntity.getShowPics());
            }
            System.out.println("==========");
        }
        ModelAndView modelAndView = new ModelAndView("user/SecondHousePage");
        //分页对象存入域
        modelAndView.addObject("pageModel", pageModel);
        //将关键字存入域
        modelAndView.addObject("keyword", keyword);
        //字典表存入域
        modelAndView.addObject("dictMap", dictMap);

        return modelAndView;
    }

    //动态导航数据查询
    public Map<String, List<DictEntity>> handleSearchMap() {
        Map<String, List<DictEntity>> map = new HashMap<String, List<DictEntity>>();



        //楼层
        List<DictEntity> loucen = dictService.findAllByTypeNum(100001);
        map.put("楼层", loucen);
        //朝向
        List<DictEntity> chaoxiang = dictService.findAllByTypeNum(100002);
        map.put("朝向", chaoxiang);
        //楼龄
        List<DictEntity> louling = dictService.findAllByTypeNum(100003);
        map.put("楼龄", louling);
        //售价
        List<DictEntity> shoujia = dictService.findAllByTypeNum(100004);
        map.put("售价", shoujia);
        //房型
        List<DictEntity> fangxing = dictService.findAllByTypeNum(100005);
        map.put("房型", fangxing);
        //面积
        List<DictEntity> mianji = dictService.findAllByTypeNum(100006);
        map.put("面积", mianji);
        //用途
        List<DictEntity> yongtu = dictService.findAllByTypeNum(100007);
        map.put("用途", yongtu);
        //电梯
        List<DictEntity> dianti = dictService.findAllByTypeNum(100008);
        map.put("电梯", dianti);
        //装修
        List<DictEntity> zhuangxiu = dictService.findAllByTypeNum(100009);
        map.put("装修", zhuangxiu);
        //供暖
        List<DictEntity> gongnuan = dictService.findAllByTypeNum(100010);
        map.put("供暖", gongnuan);
        //权属
        List<DictEntity> quanshu = dictService.findAllByTypeNum(100011);
        map.put("权属", quanshu);
        //楼房类型
        List<DictEntity> houseType = dictService.findAllByTypeNum(100015);
        map.put("楼房类型", houseType);

        return map;
    }

    //点击二手房列表到房源信息
    @RequestMapping("toInfoPage")
    public ModelAndView toInfoPage(Long id) {
        HouseEntity house = houseService.findById(id);
        ModelAndView mav = new ModelAndView("房源详情页.");
        if (house != null) {
            mav.addObject("house", house);
        }
        return mav;
    }

    //二手房推荐
    @RequestMapping("secondary")
    public ModelAndView toSecondRecommend() {
        return new ModelAndView("user/secondary");
    }

    //二手房房源列表
    @RequestMapping("/list")
    public ModelAndView toSecondList() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAreaName("江干");
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.setAddressHead(addressEntity);
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Page<CommunityEntity> pageModel = communityService.findByCommunityByPage(communityEntity, sort, 1, 10);

        System.out.println(pageModel);
        List<CommunityEntity> list = pageModel.getContent();
        for (CommunityEntity comm :
                list) {
            System.out.println(comm.getAddressHead().getAreaName());
            System.out.println("==========");
            Set<HouseEntity> houseEntities = comm.getHouseEntities();
            for (HouseEntity houseEntity : houseEntities) {
                System.out.println("------------");
                System.out.println(houseEntity);
                System.out.println("------------");

            }
            System.out.println("==========");
        }
        ModelAndView modelAndView = new ModelAndView("user/secondary-list");
        modelAndView.addObject("list", list);

        return modelAndView;
    }

    //新房推荐
    @RequestMapping("/newHouse")
    public ModelAndView toNewRecommend() {
        return new ModelAndView("user/newHouseRecommend");
    }

    //定位&动态导航搜索
    @RequestMapping("/crumbs")
    public ModelAndView toNavigation() {
        return new ModelAndView("user/crumbs");
    }

    //小区推荐
    @RequestMapping("/commRecommend")
    public ModelAndView toCommRecommend() {
        return new ModelAndView("user/commRecommend");
    }
}
