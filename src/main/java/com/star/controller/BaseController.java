package com.star.controller;

import cn.yiban.open.Authorize;
import cn.yiban.open.common.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.star.entity.Seat;
import com.star.mapper.SeatMapper;
import com.star.mapper.UserMapper;
import com.star.util.SeatUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class BaseController {
    private static Logger logger=Logger.getLogger(BaseController.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    SeatMapper seatMapper;

    private static final String appKey="f48cc159a0d4f1c7";
    private static final String appSecret="80c54652e5bcc48f83cb53337a4dca04";
    private static final String callbackurl="http://www.deardull.com:8080/autho";
    //private static final String callbackurl="http://localhost:8080/autho";

    @RequestMapping("/autho2")
    public void check2(HttpServletResponse response) throws IOException {
        Authorize au=new Authorize(appKey,appSecret);
        String url=au.forwardurl(callbackurl,"test", Authorize.DISPLAY_TAG_T.WEB);
        response.sendRedirect(url);
    }

    @RequestMapping("/autho")
    public String check(HttpServletRequest request,Model model) throws IOException {
        String code=request.getParameter("code");
        Authorize au=new Authorize(appKey,appSecret);
        String text=au.querytoken(code,callbackurl);
        JsonObject obj=new JsonParser().parse(text).getAsJsonObject();
        if(obj.has("access_token")) {
            String token = obj.get("access_token").getAsString();
            request.getSession().setAttribute("token",token);
            return "redirect:/index";
        }else {
            model.addAttribute("reason","对不起，授权验证失败，请稍后再试！");
            return "fail";
        }
    }



    @RequestMapping({"/index","/"})
    public String index(HttpServletRequest request, Model model){
        String token=(String) request.getSession().getAttribute("token");
        if (token==null || token.isEmpty()){
            return "redirect:/autho2";
        }
        Map<String,String> map=getYibanId(request,token);
        com.star.entity.User user1=userMapper.getByYiBanId(map.get("yibanId"));
        if(user1==null){
            user1=new com.star.entity.User(map.get("nickname"),map.get("yibanId"));
            userMapper.insert(user1);
        }
        model.addAttribute("userId",user1.getId());
        model.addAttribute("name",user1.getName());
        Seat seat=seatMapper.getByOnwer(user1.getId());
        if (seat!=null){
            model.addAttribute("location", SeatUtil.seatNumUtil(seat.getSeatNum()));
        }
        return "index";
    }

        private static Map<String,String> getYibanId(HttpServletRequest request,String token){
            Map<String,String> map;
            map=(Map<String, String>) request.getSession().getAttribute("userInfo");
            if (map!=null || !map.isEmpty()){
                return map;
            }
            User user=new User(token);
            JsonObject obj=new JsonParser().parse(user.me()).getAsJsonObject();
            JsonObject info=obj.get("info").getAsJsonObject();
            String nickname=info.get("yb_usernick").getAsString();
            String yibanId=info.get("yb_userid").getAsString();
            request.getSession().setAttribute("yibanId",yibanId);
            map=new HashMap<>();
            map.put("yibanId",yibanId);
            map.put("nickname",nickname);
            request.getSession().setAttribute("userInfo",map);
            return map;
        }
}
