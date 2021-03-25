package com.myclass.studentmanager.service;

import java.util.List;

import com.myclass.studentmanager.dto.AuthenticatedUserDto;
import com.myclass.studentmanager.dto.UserDto;
import com.myclass.studentmanager.dto.UserEditDto;

public interface UserService {
    List<UserDto> getAll();

    int add(UserDto user);

    int deleteById(int id);

    int edit(UserEditDto dto);

    UserDto findById(int id);

    UserEditDto findByIdForEdit(int id);

    AuthenticatedUserDto findByEmailForAuthentication(String email);

    List<UserDto> findUserRoleName(String name);
}

