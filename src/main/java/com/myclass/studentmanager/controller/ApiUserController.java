package com.myclass.studentmanager.controller;

import com.myclass.studentmanager.dto.RoleDto;
import com.myclass.studentmanager.dto.UserDto;
import com.myclass.studentmanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class ApiUserController {
    private final UserService userService;

    public ApiUserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllUser(){
        try {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestBody UserDto dto) {
        try {
            userService.add(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
