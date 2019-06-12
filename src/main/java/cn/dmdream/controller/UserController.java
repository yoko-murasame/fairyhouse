package cn.dmdream.controller;

import cn.dmdream.entity.AgentEntity;
import cn.dmdream.entity.ClientEntity;
import cn.dmdream.service.AgentService;
import cn.dmdream.service.ClientService;
import cn.dmdream.utils.JsonMsg;
import cn.dmdream.utils.SmsUtilsTencent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private AgentService agentService;
    @Autowired
    private ClientService clientService;

    //发送短信
    @RequestMapping("/sendSms")
    public JsonMsg sendSms(String phone, HttpServletRequest request) {
        ClientEntity client = clientService.findByPhone(phone);
        JsonMsg jsonMsg = null;
        try {
            if (client == null) {
                //发送注册短信
                String smsCode = SmsUtilsTencent.sentRegisterSms(phone);
                request.getSession().removeAttribute("smsCode");
                request.getSession().setAttribute("smsCode", smsCode);
                jsonMsg = JsonMsg.makeSuccess("注册短信已发送", null);
            } else {
                //发送登录验证短信
                String smsCode = SmsUtilsTencent.sentLoginSms(phone);
                request.getSession().removeAttribute("smsCode");
                request.getSession().setAttribute("smsCode", smsCode);
                jsonMsg = JsonMsg.makeSuccess("登录短信已发送", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonMsg = JsonMsg.makeFail("短信发送失败!", null);
        }

        return jsonMsg;
    }

    //登录
    @RequestMapping("/verifyUser")
    public JsonMsg verifyUser(String phone, String smsCode,HttpServletRequest request) {
        JsonMsg jsonMsg = null;
        try {
            //校验验证码
            String code = (String) request.getSession().getAttribute("smsCode");
            if (code.equalsIgnoreCase(smsCode)) {
                ClientEntity client = clientService.findByPhone(phone);
                if (client == null) {
                    //新增用户
                    ClientEntity newClient = new ClientEntity();
                    newClient.setPhone(phone);
                    newClient.setUsername(phone);
                    ClientEntity saved = clientService.save(newClient);
                    if (saved != null) {
                        request.getSession().setAttribute("user", saved);
                        jsonMsg = JsonMsg.makeSuccess("注册成功!",null);
                    }else {
                        throw new Exception("注册失败!数据插入失败!");
                    }

                } else {
                    //直接返回
                    request.getSession().setAttribute("user", client);
                    jsonMsg = JsonMsg.makeSuccess("登录成功!",null);
                }

            }else {
                throw new Exception("短信验证失败!");
            }
        } catch (Exception e) {
            jsonMsg = JsonMsg.makeFail(e.getMessage(),null);
        }
        return jsonMsg;
    }

    //退出
    @RequestMapping("/user/logout")
    public ModelAndView logOut(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return new ModelAndView("/user/index");
    }


    @RequestMapping("/")
    public ModelAndView toIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/index");
        return modelAndView;
    }

    @RequestMapping("user/favorHouse")
    public ModelAndView toFavorHouse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/personal-center-house");
        return modelAndView;
    }

    @RequestMapping("user/favorCommunity")
    public ModelAndView toFavorCommunity() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/personal-center-community");
        return modelAndView;
    }

    @RequestMapping("user/latestInfo")
    public ModelAndView toLatestInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/personal-center-latest");
        return modelAndView;
    }

    @RequestMapping("user/personalAgent")
    public ModelAndView toPersonalAgent(Model model) {
        AgentEntity test = new AgentEntity();
        test.setUsername("yoko");
        //创建排序对象，使用字段“score”降序
        Sort sort = Sort.by(Sort.Direction.DESC, "score");
        Page<AgentEntity> pageModel = agentService.findAllByPage(test, sort, 1, 5);//查询
        List<AgentEntity> list = pageModel.getContent();//获取实体列表
        list.forEach(System.out::println);
        model.addAttribute("list", list);//添加到域
        return new ModelAndView("user/personal-center-agent");//转发
    }
}
