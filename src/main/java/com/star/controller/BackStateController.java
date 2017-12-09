package com.star.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackStateController {
    @RequestMapping("/bs/releaseSpeach")
    public String releaseSpeach(){
        return "back_stage_add";
    }
    @RequestMapping("/bs/seatsView")
    public String seatsView(){
        return "back_stage_view";
    }
}
