package com.star.service;

import com.star.entity.Seat;
import com.star.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    SeatMapper seatMapper;

    @Cacheable(value = "seatCache",key = "#p0")
    public List<String> getSeatsBySpeach(int speachId){
        return seatMapper.getBySepach(speachId);
    }

    @Cacheable(value = "seatCache")
    public List<Seat> getByOwnerAndSpeach(int owner,int speach){
        return seatMapper.getByOwnerAndSpeach(owner,speach);
    }

    @Cacheable(value = "seatCache")
    public int getCountBySeatNumAndSpeach(String seatNum,int speachId){
        return seatMapper.getCountBySeatNumAndSpeach(seatNum,speachId);
    }

    @CacheEvict(value = "seatCache",allEntries = true)
    public void add(Seat seat){
        seatMapper.add(seat);
    }

    @CacheEvict(value = "seatCache",allEntries = true)
    public void deleteByOwner(int owner, int speachId){
        seatMapper.deleteByOwner(owner,speachId);
    }


}
