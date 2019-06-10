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

@RestController
@RequestMapping("/second")
public class SecondHouseController {

    @Autowired
    private HouseService houseService;
    @Autowired
    private CommunityService communityService;

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
        modelAndView.addObject("list",list);

        return modelAndView;
    }


    //二手房推荐
    @RequestMapping("secondary")
    public ModelAndView toSecondRecommend() {
        return new ModelAndView("user/secondary");
    }

    //二手房房源列表
    @RequestMapping("/list")
    public ModelAndView toSecondList() {
        return new ModelAndView("user/secondary-list");
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
