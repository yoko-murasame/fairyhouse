package cn.dmdream.controller;

import cn.dmdream.utils.VeriCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/utils")
public class UtilsController {

    @GetMapping("code")
    public void getCode(HttpServletRequest request,HttpServletResponse response) {
        String msg = VeriCode.drawPic(request, response);
        request.getSession().removeAttribute("veriCode");
        request.getSession().setAttribute("veriCode",msg);
        System.out.println(request.getSession().getAttribute("veriCode"));
    }

}
