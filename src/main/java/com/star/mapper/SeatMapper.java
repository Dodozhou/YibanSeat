package com.star.mapper;

import com.star.entity.Seat;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SeatMapper {
    @Select("select seat_num from seat")
    @Results({
            @Result(property = "seatNum",  column = "seat_num")
    })
    List<String> getAll();

    @Insert("insert into seat(seat_num,owner,speach) values(#{seatNum},#{owner},#{speach})")
    @Results({
            @Result(property = "seatNum",  column = "seat_num")
    })
    void add(Seat seat);

    @Select("select id from seat where seat_num=#{seatNum}")
    List<Integer> getBySeatNum(String seatNum);

    @Select("select seat_num from seat where owner=#{param1} and speach=#{param2}")
    @Results({
            @Result(property = "seatNum",  column = "seat_num")
    })
    List<String> getByOwnerAndSpeach(int owner,int speach);

    @Select("select * from seat where owner=#{owner}")
    @Results({
            @Result(property = "seatNum",  column = "seat_num")
    })
    Seat getByOnwer(int owner);
}
