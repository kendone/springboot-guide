package com.kendo.mapper;

import com.kendo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kendone
 */
public interface AnnotatedUserMapper {
    @Insert("INSERT INTO users(name,email) VALUES(#{name},#{email})")
    @SelectKey(statement = "call identity()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(User user);

    @Select("SELECT id,name,email FROM users where id = #{id}")
    User get(Integer id);

    @Select("SELECT id,name,email FROM users")
    List<User> findAll();
}
