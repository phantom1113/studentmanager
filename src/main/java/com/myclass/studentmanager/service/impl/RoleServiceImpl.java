package com.myclass.studentmanager.service.impl;

import com.myclass.studentmanager.dto.RoleDto;
import com.myclass.studentmanager.entity.Role;
import com.myclass.studentmanager.repository.RoleRepository;
import com.myclass.studentmanager.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDto> findAll() {
        List<RoleDto> roleDtoList = new ArrayList<>();
        List<Role> roles = roleRepository.findAll();
        if (roles.isEmpty()) {
            return null;
        }
        for (Role role : roles) {
            RoleDto dto = new RoleDto(role.getId(), role.getName(), role.getDesc());
            roleDtoList.add(dto);
        }
        return roleDtoList;
    }

    @Override
    public int add(RoleDto dto) {
        try {
            Role role = new Role();
            role.setName(dto.getName());
            role.setDesc(dto.getDesc());
            roleRepository.save(role);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public RoleDto findById(int id) {
        Role role = roleRepository.findById(id).orElse(null);
        if(role == null){
            return null;
        }
        return new RoleDto(role.getId(),role.getName(), role.getDesc());
    }

    @Override
    public int deleteById(int id) {
        roleRepository.deleteById(id);
        return 0;
    }

    @Override
    public Role edit(int id, RoleDto dto) {
        Role role = new Role(id, dto.getName(), dto.getDesc());
        return roleRepository.save(role);
    }
}
