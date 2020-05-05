package com.kendo.mapper;

import com.kendo.domain.Teacher;
import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    List<Teacher> selectAll();

    int updateByPrimaryKey(Teacher record);
}