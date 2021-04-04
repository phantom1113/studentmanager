package com.myclass.studentmanager.service;

import com.myclass.studentmanager.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();

    int add(StudentDto dto);

    int deleteById(int id);

    StudentDto findById(int id);

    int edit(StudentDto dto);
}
