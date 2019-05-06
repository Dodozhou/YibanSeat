package com.star.controller;


import com.star.util.AESUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class BackStateController {
    private static final Logger logger= LogManager.getLogger(BaseController.class);

    @RequestMapping("/bs/releaseSpeach")
    public String releaseSpeach(HttpServletRequest request, Model model){
        int autho=authoUser(request);
        switch (autho){
            case 0:
                model.addAttribute("reason","对不起，您还没有授权登录，请先返回首页进行授权登录！");
                return "fail";
            case 1:
                model.addAttribute("reason","对不起，您没有进入后台管理的权限!");
                return "fail";
            case 2:
                return "back_stage_add";
            default:
                model.addAttribute("reason","进入后台管理失败，请联系管理员!");
                return "fail";
        }



    }
    @RequestMapping("/bs/seatsView")
    public String seatsView(HttpServletRequest request, Model model){
        int autho=authoUser(request);
        switch (autho){
            case 0:
                model.addAttribute("reason","对不起，您还没有授权登录，请先返回首页进行授权登录！");
                return "fail";
            case 1:
                model.addAttribute("reason","对不起，您没有进入后台管理的权限!");
                return "fail";
            case 2:
                return "back_stage_view";
            default:
                model.addAttribute("reason","进入后台管理失败，请联系管理员!");
                return "fail";
        }

    }

    private int authoUser(HttpServletRequest request){
        Object obj=request.getSession().getAttribute("bsAutho");
        if (obj == null){
            return 0;
        }
        String bsAutho=(String)obj;
        if (bsAutho.equals("no")){
            return 1;
        }
        if (bsAutho.equals("yes")){
            return 2;
        }else {
            return 3;
        }
    }

}
