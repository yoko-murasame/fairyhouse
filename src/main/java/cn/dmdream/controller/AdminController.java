package cn.dmdream.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {

    @RequestMapping("/admin")
    public ModelAndView toIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin_index");
        return modelAndView;
    }



}
