package cn.dmdream.controller;

import cn.dmdream.entity.AgentEntity;
import cn.dmdream.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private AgentService agentService;

    @RequestMapping("/index")
    public ModelAndView toIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/index.jsp");
        return modelAndView;
    }

    @RequestMapping("user/favorHouse")
    public ModelAndView toFavorHouse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/personal-center-house.jsp");
        return modelAndView;
    }

    @RequestMapping("user/favorCommunity")
    public ModelAndView toFavorCommunity() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/personal-center-community.jsp");
        return modelAndView;
    }

    @RequestMapping("user/latestInfo")
    public ModelAndView toLatestInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/personal-center-latest.jsp");
        return modelAndView;
    }

    @RequestMapping("user/personalAgent")
    public ModelAndView toPersonalAgent() {
//        AgentEntity test = agentService.findById(1l);
        AgentEntity test = new AgentEntity();
        test.setUsername("Mr.Shao");
        Sort sort = Sort.by(Sort.Direction.DESC, "score");
        Page<AgentEntity> pageModel = agentService.findAllByPage(test, sort, 1, 5);
        List<AgentEntity> list = pageModel.getContent();
        list.forEach(System.out::println);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/personal-center-agent.jsp");
        return modelAndView;
    }
}
