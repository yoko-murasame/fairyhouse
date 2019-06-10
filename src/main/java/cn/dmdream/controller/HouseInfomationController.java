package cn.dmdream.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/houseinfo")
public class HouseInfomationController {


    @RequestMapping("house")
    public ModelAndView toHouseInfo() {
        return new ModelAndView("user/second_hand_house");
    }

}
