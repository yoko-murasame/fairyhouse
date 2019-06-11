package cn.dmdream.controller;

import cn.dmdream.entity.AddressEntity;
import cn.dmdream.entity.CommunityEntity;
import cn.dmdream.service.AddressService;
import cn.dmdream.service.CommunityService;
import cn.dmdream.service.HouseService;
import cn.dmdream.utils.JsonMsg;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MapController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private CommunityService communityService;

    @RequestMapping("/jsdemo")
    public ModelAndView toJsdemo(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/jsdemo");
        return modelAndView;
    }

    @PostMapping("/getCommunities")
    public String toSecondListPage(String county) {
        System.out.println(county);
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAreaName(county);
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.setAddressHead(addressEntity);
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Page<CommunityEntity> pageModel = communityService.findByCommunityByPage(communityEntity, sort, 1, 10);
//        System.out.println(pageModel);
        List<CommunityEntity> list = pageModel.getContent();
        JsonMsg json = JsonMsg.makeSuccess("成功", list);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonStr = objectMapper.writeValueAsString(json);
            return jsonStr;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
