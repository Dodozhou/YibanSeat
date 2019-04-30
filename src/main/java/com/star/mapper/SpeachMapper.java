package com.star.mapper;

import com.star.entity.Speach;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Speach活动持久化接口.
 */
@Component
@Mapper
public interface SpeachMapper {
    @Select("select * from speach")
    List<Speach> getAll();


    @Insert("insert into speach(title,description,place,time) " +
            "values(#{title},#{description},#{place},#{time})")
    @Options(useGeneratedKeys = true)
    void add(Speach speach);

   /* @Update("update speach set title=#{title}, description=#{description},place=#{place},time=#{time} where id=#{id}")
    void update(Speach speach);*/

    @Select("select u.yiban_id,u.name,s.seat_num,s.signed from user u,seat s where u.id=s.owner and s.speach=#{speachId}")
    List<Map> getCurrentSeats(int speachId);

    @Select("select * from speach order by id desc limit 1")
    Speach getLastOne();

}
