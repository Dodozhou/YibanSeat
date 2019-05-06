package com.star.mapper;

import com.star.entity.Seat;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 座位持久化接口.
 * 用于seat实体的CRUD相关操作
 */
@Component
@Mapper
public interface SeatMapper {
    /*
     * 获取所有座位记录.
     * @return 返回一个包含所有座位记录的List

    @Select("select seat_num from seat")
    @Results({
            @Result(property = "seatNum",  column = "seat_num")
    })
    List<String> getAll();
     */


    /**
     * 插入一个座位记录.
     * @param seat 要插入的座位实体
     */
    @Insert("insert into seat(seat_num,owner,speach) values(#{seatNum},#{owner},#{speach})")
    @Results({
            @Result(property = "seatNum",  column = "seat_num")
    })
    void add(Seat seat);

    /**
     * 通过SeatNum（座位编号）查询座位记录的条数
     * @param seatNum 座位编号
     * @return 返回seatNum在本次活动中的记录条数
     */
    @Select("select count(*) from seat where seat_num=#{seatNum} and speach=#{speachId}")
    Integer getCountBySeatNumAndSpeach(String seatNum,int speachId);

    /**
     * 通过用户id和活动id查询记录
     * @param owner 用户id
     * @param speach 活动id
     * @return 返回满足条件的seatNum列表
     */
    @Select("select * from seat where owner=#{param1} and speach=#{param2}")
    @Results({
            @Result(property = "seatNum",  column = "seat_num")
    })
    List<Seat> getByOwnerAndSpeach(int owner,int speach);

    /**
     * 通过用户id查询座位记录
     * @param owner 用户id
     * @return 返回符合条件的Seat实体
     *//*
    @Select("select * from seat where owner=#{owner}")
    @Results({
            @Result(property = "seatNum",  column = "seat_num")
    })
    List<Seat> getByOnwer(int owner);*/

    @Delete("delete from seat where owner=#{owner} and speach=#{speachId}")
    void deleteByOwner(int owner, int speachId);

    @Select("select seat_num from seat where speach=#{speachId}")
    @Results({
            @Result(property = "seatNum",  column = "seat_num")
    })
    List<String> getBySepach(int speachId);

    @Update("update seat set signed=#{sign} where speach=#{speachId} and seat_num=#{seatNum}")
    void updateSeatSign(boolean sign,int speachId,String seatNum);
}
