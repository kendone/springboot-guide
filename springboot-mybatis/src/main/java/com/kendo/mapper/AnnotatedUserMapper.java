package com.kendo.mapper;

import com.kendo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 基于注解的映射语句配置
 *
 * @author kendone
 */
public interface AnnotatedUserMapper {

    @Insert("INSERT INTO users(name,email) VALUES(#{name},#{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Select("SELECT id,name,email FROM users where id = #{id}")
    User get(Integer id);

    @Select("SELECT id,name,email FROM users")
    List<User> findAll();

}
