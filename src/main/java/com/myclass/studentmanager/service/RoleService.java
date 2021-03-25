package com.myclass.studentmanager.service;


import java.util.List;

import com.myclass.studentmanager.dto.RoleDto;
import com.myclass.studentmanager.entity.Role;

public interface RoleService {
    List<RoleDto> findAll();

    int add(RoleDto dto);

    RoleDto findById(int id);

    int deleteById(int id);

    Role edit(int id, RoleDto dto);
}
