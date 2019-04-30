package com.star.mapper;

import com.star.entity.Seat;
import com.star.service.SeatService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 该测试类用于测试Seat的持久化接口是否正常工作.
 * 该测试类基于的测试数据为（id:23,seat_num:1_2_06_12,owner:19,speach:1）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class SeatMapperTest {
   @Autowired
   SeatService seatService;

    @Test
    public void getAll() throws Exception {

    }
    @Test
    public void add() throws Exception {
        Seat seat=new Seat();
        seat.setSpeach(1);
        seat.setOwner(19);
        seat.setSeatNum("1_2_06_12");
        seatService.add(seat);
    }

    @Test
    public void getBySeatNum() throws Exception {

    }

    @Test
    public void getByOwnerAndSpeach() throws Exception {
        List<Seat> strings= seatService.getByOwnerAndSpeach(19,1);
        System.out.println(strings);
        assertNotNull(strings);
    }

    @Test
    public void getByOnwer() throws Exception {

    }


    @Test
    public void deleteByOwner(){

    }
}