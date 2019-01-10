package com.bwie.demo0109.mapper;

import com.bwie.demo0109.entity.Account;
import com.bwie.demo0109.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> queryStudent(String condition);

    Account select(String user, String pass);
}
