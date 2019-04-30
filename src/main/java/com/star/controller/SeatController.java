package com.star.controller;

import com.google.gson.Gson;
import com.star.entity.Seat;
import com.star.entity.Speach;
import com.star.entity.User;
import com.star.mapper.SeatMapper;
import com.star.mapper.SpeachMapper;
import com.star.mapper.UserMapper;
import com.star.service.SeatService;
import com.star.service.SpeachService;
import com.star.service.UserService;
import org.apache.ibatis.annotations.Param;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SAAJResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抢座控制器.
 * 抢座相关的接口及控制逻辑。
 */
@Controller
public class SeatController {
    @Autowired
    private SeatService seatService;
    @Autowired
    private SpeachService speachService;
    @Autowired
    private UserService userService;

    // Define a static logger variable so that it references the
    // Logger instance named "BaseController".
    private static final Logger logger= LogManager.getLogger(SeatController.class);


    /**
     * 获取所有座位信息的接口.
     * 以Json的形式，返回所有已经被抢了的座位编号，以供前端渲染
     * @return json格式的数组，包含已经被抢的座位编号
     */
    @ResponseBody
    @RequestMapping("/getSeats")
    public List<String> getSeats(HttpServletRequest request){
        Speach speach=speachService.getLastOne();
        List<String> seats=seatService.getSeatsBySpeach(speach.getId());
        String mySeat=(String)request.getSession().getAttribute("MySeat");
        if (mySeat==null){
            mySeat="";
        }
        seats.add(mySeat);
        return seats;
    }

   /* @ResponseBody
    @RequestMapping("/getMySeat")
    public String getMySeatSuccess(@RequestParam("callback") String callback, HttpServletRequest request){
        Gson gson=new Gson();
        String mySeat=(String)request.getSession().getAttribute("MySeat");
        if (mySeat==null){
            mySeat="";
        }
        if (callback==null || callback.isEmpty()){
            return gson.toJson(mySeat);
        }else
        return callback+"("+gson.toJson(mySeat)+")";
    }*/

    /**
     * 抢座接口.
     * 将座位编号和用户id存入数据库来达到抢座的目的。
     * @param seatNum 座位编号
     * @param owner 用户Id
     * @param model org.springframework.ui.Model
     * @return "redirect:/index" 重定向至首页；"fail" 抢座失败，转向错误页面
     */
    @RequestMapping("/graspSeat")
    public String graspSeats(@RequestParam(value = "seat") String seatNum,
                             @RequestParam(value = "owner") Integer owner, Model model){

        if (seatNum==null || seatNum.isEmpty() || owner==null){
            model.addAttribute("reason","出错啦，请返回主页刷新重试！");
            return "fail";
        }

        //验证该用户是否已经选了座位
        if (seatService.getByOwnerAndSpeach(owner,speachService.getLastOne().getId()).size()>0){
            logger.trace("Id为"+owner+"的用户抢过座位了");
            model.addAttribute("reason","您已经抢过这个活动的座位了哦！");
            return "fail";
        }

        //验证座位是否被抢
        if (seatService.getCountBySeatNumAndSpeach(seatNum,speachService.getLastOne().getId())>0){
            model.addAttribute("reason","这个座位刚刚被抢了哦！");
            return "fail";
        }

        Seat seat=new Seat();
        seat.setOwner(owner);
        seat.setSeatNum(seatNum);
        seat.setSpeach(speachService.getLastOne().getId());
        seatService.add(seat);

        logger.trace("Id为"+owner+"的用户刚抢到了座位："+seatNum);

        return "redirect:/index";
    }

    //鉴定是否是西南石油大学的学生
    /*private static boolean isXiYou(String token){
        User user=new User(token);
        JsonObject obj=new JsonParser().parse(user.me()).getAsJsonObject();
        JsonObject info=obj.get("info").getAsJsonObject();
        String schoolId=info.get("yb_schoolid").getAsString();
        return schoolId.equals("22017");
    }*/

    /**
     * 根据owner删除座位记录
     * @param yiban_id 座位拥有者的易班id
     */
    @RequestMapping("/deleteSeat")
    public String deleteSeat(String yiban_id,Model model){
        logger.debug(yiban_id);
        List<User> users=userService.getByYiBanId(yiban_id);
        for (User user:users) {
            logger.debug(user.getId()+"   "+user.getName()+"  "+user.getYibanId());
        }
        if (users.size()>1 || users.size()<1){
            model.addAttribute("reason","该用户的账户出错了，请及时联系管理员！");
            return "fail";
        }
        seatService.deleteByOwner(users.get(0).getId(),speachService.getLastOne().getId());
        return "back_stage_view";
    }

}
