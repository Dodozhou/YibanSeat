package com.star.mapper;

import com.star.entity.Speach;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpeachMapper {
    @Select("select * from speach")
    List<Speach> getAll();

    @Select("select * from speach where id=#{id}")
    Speach getOne(int id);

    @Insert("insert into speach(title,speaker,description,place,time) " +
            "values(#{title},#{speaker},#{description},#{place},#{time})")
    void add(Speach speach);

}
