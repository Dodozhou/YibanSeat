package com.star.mapper;

import com.star.entity.Seat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 该测试类用于测试Seat的持久化接口是否正常工作.
 * 该测试类基于的测试数据为（id:23,seat_num:1_2_06_12,owner:19,speach:1）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeatMapperTest {
   @Autowired
    SeatMapper seatMapper;

    @Test
    public void getAll() throws Exception {
        List<String> seats =seatMapper.getAll();
        System.out.println(seats);
        assertNotNull(seats);
    }
/*
    @Test
    public void add() throws Exception {
        Seat seat=new Seat();
        seat.setSpeach(1);
        seat.setOwner(19);
        seat.setSeatNum("1_2_06_12");
        seatMapper.add(seat);
        System.out.println(seat.getId());
        assertNotEquals(0,seat.getId());
    }

    @Test
    public void getBySeatNum() throws Exception {
        List<Integer> ids =seatMapper.getBySeatNum("1_2_06_12");
        System.out.println(ids);
        assertNotNull(ids);
    }

    @Test
    public void getByOwnerAndSpeach() throws Exception {
        List<String> strings=seatMapper.getByOwnerAndSpeach(19,1);
        System.out.println(strings);
        assertNotNull(strings);
    }

    @Test
    public void getByOnwer() throws Exception {
        List<Seat> seats=seatMapper.getByOnwer(19);
        for (Seat seat:seats) {
            System.out.println(seat.getSeatNum());
            assertNotNull(seat);
        }
    }


    @Test
    public void deleteByOwner(){
        seatMapper.deleteByOwner(19);
    }
*/
}