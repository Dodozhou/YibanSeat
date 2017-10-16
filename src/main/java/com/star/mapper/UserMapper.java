package com.star.mapper;

import com.star.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "yibanId",  column = "yiban_id")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE yiban_id = #{yibanId}")
    @Results({
            @Result(property = "yibanId",  column = "yiban_id")
    })
    User getByYiBanId(String yibanId);

    @Insert("INSERT INTO user(name,yiban_id) VALUES(#{name}, #{yibanId})")
    void insert(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "yibanId",  column = "yiban_id")
    })
    User getOne(Long id);

    /*@Update("UPDATE user SET name=#{name} WHERE id =#{id}")
    void update(User user);*/

   /* @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);*/
}
