package com.star.controller;

import com.star.entity.Seat;
import com.star.mapper.SeatMapper;
import com.star.mapper.UserMapper;
import com.star.util.SeatUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.apache.log4j.Logger;

@Controller
public class SeatController {
    private static Logger logger=Logger.getLogger(SeatController.class);
    @Autowired
    SeatMapper seatMapper;
    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/getSeats")
    public List<String> getSeats(HttpServletResponse response){
        /*response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Methods","GET,POST");
        response.setHeader("Access-Control-Allow-Origin","*");*/
        return seatMapper.getAll();
    }

    @RequestMapping("/graspSeat")
    public String graspSeats(@RequestParam("seat") String seatNum,
                             @Param("owner") Integer owner, Model model){
        //不光要验证座位是否空余，还要验证该用户是否已经选了座位了！！！！！！
        logger.debug("seatNum: "+seatNum);
        logger.debug("owner: "+owner);
        if (seatMapper.getBySeatNum(seatNum).size()>0){
            model.addAttribute("reason","这个座位刚刚被抢了哦！");
            return "fail";
        }
        if (seatMapper.getByOwnerAndSpeach(owner,1).size()>0){
            model.addAttribute("reason","您已经抢过这个活动的座位了哦！");
            return "fail";
        }
        Seat seat=new Seat();
        seat.setOwner(owner);
        seat.setSeatNum(seatNum);
        seat.setSpeach(1);
        seatMapper.add(seat);
        logger.debug("In graspSeats(),the owner and seatNum is:"+owner+", "+seatNum);
        logger.debug(userMapper.getOne(Long.valueOf(owner)).getName()+" Booked SeatNum : "+seat.getSeatNum());
        return "redirect:/index";
    }

}
