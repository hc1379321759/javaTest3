package com.greatyun.dao;

import com.greatyun.pojo.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int selectMaxId();

    int batchDeleteStudents(List list);

    List<Student> selectList();
}