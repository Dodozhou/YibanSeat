package com.star.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SeatServiceTest {
    @Autowired
    SeatService seatService;

    @Test
    public void getCountBySeatNumAndSpeach() {
        System.out.println(seatService.getCountBySeatNumAndSpeach("1_3_5",16));
    }
}