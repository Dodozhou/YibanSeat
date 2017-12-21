package com.star.controller;

import cn.yiban.open.Authorize;
import cn.yiban.open.common.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.star.entity.Seat;
import com.star.entity.Speach;
import com.star.mapper.SeatMapper;
import com.star.mapper.SpeachMapper;
import com.star.mapper.UserMapper;
import com.star.util.SeatUtil;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * BaseController 基础控制器.
 * 包含易班授权认证、登录等路径的映射和逻辑处理
 * @author 周成 2017/10/26
 * @version Version 1.0
 */
@Controller
public class BaseController {

    private final UserMapper userMapper;
    private final SeatMapper seatMapper;
    private final SpeachMapper speachMapper;

    // Define a static logger variable so that it references the
    // Logger instance named "BaseController".
    private static final Logger logger= LogManager.getLogger(BaseController.class);

    private static final String appKey="f48cc159a0d4f1c7";
    private static final String appSecret="80c54652e5bcc48f83cb53337a4dca04";
    private static final String callbackurl="http://www.deardull.com:8080/autho";
    //private static final String callbackurl="http://localhost:8080/autho";



    /**
     *
     * @param userMapper 用户持久化接口
     * @param seatMapper 座位持久化接口
     */
    @Autowired
    public BaseController(UserMapper userMapper, SeatMapper seatMapper, SpeachMapper speachMapper) {
        this.userMapper = userMapper;
        this.seatMapper = seatMapper;
        this.speachMapper=speachMapper;
    }

    /**
     * 对路径"/autho2"的映射.
     * 转向易班认证授权页面，通过appKey和appSecret验证授权，完成授权后转向回调地址
     * @param response HttpServletResponse 用于重定向至认证回调地址
     * @throws IOException
     */
    @RequestMapping("/autho2")
    public void check2(HttpServletResponse response) throws IOException {
        Authorize au=new Authorize(appKey,appSecret);
        String url=au.forwardurl(callbackurl,"test", Authorize.DISPLAY_TAG_T.WEB);
        response.sendRedirect(url);
    }

    /**
     * "/autho"认证完成后的回调接口.
     * 认证成功，请求被重定向至此接口，获取返回的code，使用code获取认证密匙token，
     * 然后将token保存至Session，方便其他接口检测
     * @param request 认证返回的HttpServletRequest 带有code参数
     * @param model 向视图传递参数
     * @return "redirect:/index" 获取token成功，重定向至index页面；
     * ”fail“认证失败，返回到错误页面
     * @throws IOException
     */
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


    /**
     * "/index"主页接口.
     * 应用的首页，首先会尝试从Session中获取token参数以验证是否已经通过了易班授权，
     * 若没有，则重定向到"/autho2"进行认证授权。若通过了授权，则调用易班api获取授权用户的基本
     * 信息：姓名、易班账户ID。以易班账户id向数据库查询该用户是否选过了座位，并添加相应的视图参数
     * @param request 获取Session
     * @param model 传递视图参数
     */
    @RequestMapping({"/index","/"})
    public String index(HttpServletRequest request, Model model){
        List<com.star.entity.User> user1s;
        com.star.entity.User user1;

        String token=(String) request.getSession().getAttribute("token");
        if (token==null || token.isEmpty()){
            return "redirect:/autho2";
        }

        Map<String,String> map=getUserInfo(token,request);

        //认证验证
        if (map.get("yibanId")==null || map.get("yibanId").isEmpty()){
            model.addAttribute("reason","对不起，您的易班账号没有认证，请先进行学校认证！");
            return "fail";
        }
        user1s=userMapper.getByYiBanId(map.get("yibanId"));
        if (user1s.size()>1){
            logger.error("Id为"+user1s.get(0).getId()+"的用户注册了两次，出错了");
            model.addAttribute("reason","对不起，您的账户出错了，请联系系统管理员！");
            return "fail";
        }else if(user1s.size()==0){
            user1=new com.star.entity.User(map.get("nickname"),map.get("yibanId"));
            userMapper.insert(user1);
        }else {
            user1=user1s.get(0);
        }

        model.addAttribute("userId",user1.getId());
        model.addAttribute("name",user1.getName());

        //logger.trace("查询用户"+user1.getName()+",id:"+user1.getId()+"是否抢座");
        List<Seat> seats=seatMapper.getByOwnerAndSpeach(user1.getId(),speachMapper.getLastOne().getId());
        if (seats.size()>1){
            logger.error("Id为"+seats.get(0).getOwner()+"的用户抢了两次座位，出错了");
            model.addAttribute("reason","对不起，您的账户出错了，请联系系统管理员！");
            return "fail";
        }else if (seats.size()==1){
            Seat seat=seats.get(0);
            //logger.trace("Id为"+seat.getOwner()+"的用户已经抢过了，座位是"+seat.getSeatNum());
            request.getSession().setAttribute("MySeat",seat.getSeatNum());
        }else {
            //logger.trace("Id为"+user1.getId()+"的用户还没有抢过座位");
            request.getSession().setAttribute("MySeat","");
        }
        return "index";
    }


    /**
     * 获取易班用户信息的工具类.
     * 作用：避免反复向易班服务器请求用户信息，提高应用速度<br>
     * 原理：向Session获取参数“userInfo”，若存在，则直接返回；若不存在，则向易班请求基本信息
     * ，并将信息以”userInfo“为键保存至Session，然后返回用户信息。
     * @param token  易班授权密匙，用于向易班请求用户基本信息
     * @return The Map of UserInfo
     */
        private  Map<String,String> getUserInfo(String token,HttpServletRequest request){
            Map<String,String> userMap;
            Object userObj=request.getSession().getAttribute("userMap");
            if (userObj!=null){
                userMap= (Map<String, String>) userObj;
                return userMap;
            }
            userMap=new HashMap<>();
            User user=new User(token);
            //JsonObject obj=new JsonParser().parse(user.me()).getAsJsonObject();
            JsonObject obj=new JsonParser().parse(user.realme()).getAsJsonObject();
            logger.trace(obj);
            JsonObject info=obj.get("info").getAsJsonObject();
            //String username=info.get("yb_username").getAsString();
            String username=info.get("yb_realname").getAsString();
            //String yibanId=info.get("yb_userid").getAsString();
            String yibanId=info.get("yb_studentid").getAsString();
            //验证用户是否有权限登录后台
            List<String> authoUser=speachMapper.getAuthers();
            boolean isAuthed=false;
            for (String s :authoUser) {
                if (s.equals(yibanId)){
                    isAuthed=true;
                    request.getSession().setAttribute("bsAutho","yes");
                    break;
                }
            }
            if (!isAuthed){
                request.getSession().setAttribute("bsAutho","no");
            }

            logger.trace("User: "+username+" authorized!");

            userMap.put("yibanId",yibanId);
            userMap.put("nickname",username);
            request.getSession().setAttribute("userMap",userMap);
            return userMap;
        }

}
