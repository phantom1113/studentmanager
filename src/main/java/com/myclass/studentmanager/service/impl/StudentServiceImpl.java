package com.myclass.studentmanager.service.impl;

import com.myclass.studentmanager.dto.StudentDto;
import com.myclass.studentmanager.entity.Student;
import com.myclass.studentmanager.repository.StudentRepository;
import com.myclass.studentmanager.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        if (students.isEmpty()) {
            return null;
        }
        for (Student student : students) {
            StudentDto dto = new StudentDto(student.getId(), student.getFullName(), student.getGrade());
            studentDtoList.add(dto);
        }
        return studentDtoList;
    }

    @Override
    public int add(StudentDto dto) {
        Student student = new Student(dto.getFullName(), dto.getGrade());
        studentRepository.save(student);
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public StudentDto findById(int id) {
        return null;
    }

    @Override
    public int edit(StudentDto dto) {
        return 0;
    }
}
