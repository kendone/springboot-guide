package com.kendo.mapper;

import com.kendo.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author kendone
 */
public interface StudentMapper {

    @Insert("INSERT INTO student(id,name,email,birthday,phone,address_id) VALUES (#{id},#{name},#{email},#{birthday},#{phone},#{address.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
        //支持自增长的数据库，自动生成主键
        //@SelectKey(statement = "SELECT STUD_ID_SEQ.CURRVAL FROM DUAL", keyProperty = "id", resultType = int.class, before = true)//不支持自动增长的
    int insert(Student student);

    @Update("UPDATE STUDENTS SET NAME=#{name}, EMAIL=#{email}, PHONE=#{phone} WHERE id=#{id}")
    int updateStudent(Student student);

    @Delete("DELETE FROM STUDENTS WHERE STUD_ID=#{studId}")
    int deleteStudent(int studId);

    @Select("SELECT id as id, NAME, EMAIL, PHONE FROM STUDENTS WHERE id=#{id}")
    Student findStudentById(Integer studId);

    @Select("SELECT * FROM STUDENTS")
    //结果集映射
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "email", property = "email"),
            @Result(column = "address_id", property = "address.addressId")
    })
    List<Student> findAllStudents();
}
