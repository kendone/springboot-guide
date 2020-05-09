package com.kendo.mapper;

import com.kendo.domain.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 基于注解的映射语句配置
 *
 * @author kendone
 */
@CacheNamespace
public interface AnnotatedUserMapper {

    @Insert("INSERT INTO user(name,email) VALUES(#{name},#{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Select("SELECT id,name,email FROM user WHERE id = #{id}")
    User get(Integer id);

    @Select("SELECT id,name,email FROM user")
    List<User> findAll();

}
