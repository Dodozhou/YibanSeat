package com.star.controller;

import com.google.gson.Gson;
import com.star.entity.Speach;
import com.star.mapper.SpeachMapper;
import com.star.util.MapBeanUtil;
import javafx.scene.input.DataFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Controller
public class SpeachController {
    private final SpeachMapper speachMapper;

    public SpeachController(SpeachMapper speachMapper) {
        this.speachMapper = speachMapper;
    }

    /**
     * 更新活动。
     * @param title 活动的名称。
     * @param place 活动的地点。
     * @param time 活动的时间。
     * @return
     */
    @RequestMapping("/addSpeach")
    public String addSpeach(@RequestParam("title")String title,
                            @RequestParam("place")String place,
                            @RequestParam("time")Date time){
        Speach speach=new Speach();
        speach.setId(1);
        speach.setTitle(title);
        speach.setPlace(place);
        speach.setTime(time);
        speach.setDescription(title);
        speachMapper.update(speach);
        return "redirect:/index";
    }

    /**
     * 获取活动的Rest方法。
     * 查询当前活动并以json格式返回给前端，方便前端异步获取
     * @return json格式的活动信息
     */
    @ResponseBody
    @RequestMapping("/getSpeach")
    public String getSpeach(){
        Gson gson=new Gson();
        Speach speach=speachMapper.getAll().get(0);
        //为了格式化时间而做的一堆工作
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        String formatTime=formatter.format(speach.getTime());
        //将speach转为map，然后用格式化后的日期替换之前的日志
        Map map= MapBeanUtil.beanToMap(speach);
        map.replace("time",formatTime);
        //将map转化为json并返回
         return gson.toJson(map);
    }

    /**
     * 获取所有座位及其预定者的信息，以方便删除等管理操作
     * @return json格式的信息数组
     */
    @ResponseBody
    @RequestMapping("/getAllSeatsForManage")
    public String getAllSeatsForManage(){
        Gson gson=new Gson();
        return gson.toJson(speachMapper.getAllSeats());
    }





}

