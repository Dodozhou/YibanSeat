package com.star.service;

import com.star.entity.User;
import com.star.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Cacheable(value = "userCache",key = "#p0")
    public List<User> getByYiBanId(String yibanId){
        return userMapper.getByYiBanId(yibanId);
    }

    public int insert(User user){
        return userMapper.insert(user);
    }
}
