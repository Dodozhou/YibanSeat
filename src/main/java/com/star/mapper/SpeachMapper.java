package com.star.mapper;

import com.star.entity.Speach;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Speach活动持久化接口.
 */
@Component
@Mapper
public interface SpeachMapper {
    @Select("select * from speach")
    List<Speach> getAll();


    @Insert("insert into speach(title,speaker,description,place,time) " +
            "values(#{title},#{speaker},#{description},#{place},#{time})")
    @Options(useGeneratedKeys = true)
    void add(Speach speach);

}
