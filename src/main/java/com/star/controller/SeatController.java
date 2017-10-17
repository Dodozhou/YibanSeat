package com.star.controller;

import com.star.entity.Seat;
import com.star.mapper.SeatMapper;
import com.star.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class SeatController {
    private final SeatMapper seatMapper;
    private final UserMapper userMapper;

    @Autowired
    public SeatController(SeatMapper seatMapper, UserMapper userMapper) {
        this.seatMapper = seatMapper;
        this.userMapper = userMapper;
    }

    @ResponseBody
    @RequestMapping("/getSeats")
    public List<String> getSeats(){
        /*response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Methods","GET,POST");
        response.setHeader("Access-Control-Allow-Origin","*");*/
        return seatMapper.getAll();
    }

    @RequestMapping("/graspSeat")
    public String graspSeats(@RequestParam("seat") String seatNum,
                             @Param("owner") int owner, Model model){
        //不光要验证座位是否空余，还要验证该用户是否已经选了座位了！！！！！！
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
        //logger.debug(userMapper.getOne(Long.valueOf(owner)).getName()+" Booked SeatNum : "+seat.getSeatNum());
        return "redirect:/index";
    }

}
