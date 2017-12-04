package com.star.mapper;

import com.star.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User用户持久化接口
 */
@Component
@Mapper
public interface UserMapper {
    /**
     * 返回所有User
     * @return 包含所有User列表
     */
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "yibanId",  column = "yiban_id")
    })
    List<User> getAll();

    /**
     * 通过易班id查询用户
     * @param Id 易班Id
     * @return User实体
     */
    @Select("SELECT * FROM user WHERE yiban_id = #{Id}")
    @Results({
            @Result(property = "yibanId",  column = "yiban_id")
    })
    List<User> getByYiBanId(String Id);

    /**
     * 插入用户.
     * 新创建用户
     * @param user User实体
     * @return 受影响的行数
     */
    @Insert("INSERT INTO user(name,yiban_id) VALUES(#{name}, #{yibanId})")
    @Options(useGeneratedKeys=true,keyColumn = "id")
    int insert(User user);

    /**
     * 通过用户id查询用户.
     * @param id 用户id
     * @return 返回User实体
     */
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
