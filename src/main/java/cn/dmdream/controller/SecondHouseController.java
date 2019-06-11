package cn.dmdream.controller;

import cn.dmdream.entity.AddressEntity;
import cn.dmdream.entity.CommunityEntity;
import cn.dmdream.entity.HouseEntity;
import cn.dmdream.service.CommunityService;
import cn.dmdream.service.HouseService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/second")
public class SecondHouseController {

    @Autowired
    private HouseService houseService;
    @Autowired
    private CommunityService communityService;

    //首页搜索进入二手房列表
    @PostMapping("toSecondList")
    public ModelAndView toSecondListPage(String keyword) {
        System.out.println(keyword);
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAreaName(keyword);
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.setAddressHead(addressEntity);
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Page<CommunityEntity> pageModel = communityService.findByCommunityByPage(communityEntity, sort, 1, 10);

        System.out.println(pageModel);
        List<CommunityEntity> list = pageModel.getContent();
        for (CommunityEntity comm :
                list) {
            System.out.println(comm);
            System.out.println(comm.getAddressHead().getAreaName());
            System.out.println(comm.getHouseEntities());
            System.out.println("==========");
        }
        ModelAndView modelAndView = new ModelAndView("user/SecondHousePage");
        modelAndView.addObject("list", list);

        return modelAndView;
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
