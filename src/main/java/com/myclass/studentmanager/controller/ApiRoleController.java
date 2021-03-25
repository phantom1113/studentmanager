package com.myclass.studentmanager.controller;

import com.myclass.studentmanager.dto.RoleDto;
import com.myclass.studentmanager.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/role")
public class ApiRoleController {
    private final RoleService roleService;

    public ApiRoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getRoleList() {
        try {
            return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestBody RoleDto dto) {
        try {
            roleService.add(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        try {
            roleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> edit(@PathVariable("id") int id, @RequestBody RoleDto dto) {
        try {
            roleService.findById(id);
            roleService.edit(id, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
