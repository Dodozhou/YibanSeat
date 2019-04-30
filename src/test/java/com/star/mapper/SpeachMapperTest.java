package com.star.mapper;

import com.star.entity.Speach;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class SpeachMapperTest {
    @Autowired
    SpeachMapper speachMapper;
   @Test
    public void getAll() throws Exception {
        List<Speach> speaches=speachMapper.getAll();
        for (Speach sp :speaches) {
            System.out.println(sp.getTitle());
        }
        assertNotNull(speaches);
    }
 /*
    @Test
    public void add() throws Exception {
        Speach speach=new Speach();
        speach.setTitle("大学生求职宣讲会");
        speach.setDescription("有关大学生如何求职，如何规划职场目标的一场演讲");
        speach.setPlace("图书馆报告厅");
        speach.setTime("2017-10-30 14:30");
        System.out.println("Before:"+speach.getId());
        speachMapper.add(speach);
        System.out.println("After:"+speach.getId());
        assertNotEquals(-1,speach.getId());
    }
   @Test
    public void update(){
       Speach speach=new Speach();
       speach.setId(1);
       speach.setDescription("这是测试描述");
       speach.setTime(new Date());
       speach.setPlace("思学楼A118");
       speach.setTitle("热爱祖国思想教育活动");
       speachMapper.update(speach);

   }
   */

}