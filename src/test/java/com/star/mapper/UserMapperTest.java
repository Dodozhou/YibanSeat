package com.star.mapper;

import com.star.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void getAll() throws Exception {
        assertNotNull(userMapper.getAll());
    }

 /*   @Test
    public void getByYiBanId() throws Exception {
        assertNotNull(userMapper.getByYiBanId("7530594"));
    }

    @Test
    public void insert() throws Exception {
        User user=new User();
        user.setName("测试");
        user.setYibanId("111111");
        userMapper.insert(user);
        assertNotEquals(0,user.getId());
    }

    @Test
    public void getOne() throws Exception {
        assertNotNull(userMapper.getOne(19L));
    }*/

}