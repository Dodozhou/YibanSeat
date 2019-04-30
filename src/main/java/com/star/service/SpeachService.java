package com.star.service;

import com.star.entity.Speach;
import com.star.mapper.SpeachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SpeachService {
    @Autowired
    SpeachMapper speachMapper;

    @Cacheable(value = "speachCache")
    public Speach getLastOne(){
        return speachMapper.getLastOne();
    }

    @CacheEvict(value = "speachCache",allEntries = true)
    public void add(Speach speach){
        speachMapper.add(speach);
    }

    public List<Map> getCurrentSeats(int speachId){
        return speachMapper.getCurrentSeats(speachId);
    }
}
