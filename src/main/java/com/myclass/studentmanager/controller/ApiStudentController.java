package com.myclass.studentmanager.controller;

import com.myclass.studentmanager.dto.StudentDto;
import com.myclass.studentmanager.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class ApiStudentController {
    private  final StudentService studentService;

    public ApiStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try {
            return new ResponseEntity<>(studentService.getAll(),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestBody StudentDto dto){
        try {
            studentService.add(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
