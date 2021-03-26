package com.myclass.studentmanager.service.impl;

import com.myclass.studentmanager.dto.AuthenticatedUserDto;
import com.myclass.studentmanager.dto.UserDto;
import com.myclass.studentmanager.dto.UserEditDto;
import com.myclass.studentmanager.entity.User;
import com.myclass.studentmanager.repository.UserRepository;
import com.myclass.studentmanager.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return null;
        }
        for (User user : users) {
            UserDto dto = new UserDto();
            dto.setEmail(user.getEmail());
            dto.setFullName(user.getFullName());
            dto.setId(user.getId());
            dto.setPassword(user.getPassword());
            dto.setAvatar(user.getAvatar());
            dto.setRoleId(user.getRoleId());
            dto.setRoleDesc(user.getRole().getDesc());
            dto.setRoleName(user.getRole().getName());
            userDtoList.add(dto);
        }
        return userDtoList;
    }

    @Override
    public int add(UserDto dto) {
        try {
            User user = new User();
            user.setEmail(dto.getEmail());
            user.setFullName(dto.getFullName());
            user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
            user.setAvatar("test");
            user.setRoleId(dto.getRoleId());
            userRepository.save(user);
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int deleteById(int id) {
        if (findById(id) != null) {
            userRepository.deleteById(id);
            return 0;
        }
        return -1;
    }

    @Override
    public int edit(UserEditDto dto) {
        User user = userRepository.findById(dto.getId()).orElse(null);
        if(user == null){
            return -1;
        }
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
        if (dto.getPassword() != null) {
            user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        }
        user.setAvatar("test");
        user.setRoleId(dto.getRoleId());
        userRepository.save(user);
        return 0;
    }

    @Override
    public UserDto findById(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setEmail(user.getEmail());
            dto.setPassword(user.getPassword());
            dto.setFullName(user.getFullName());
            dto.setAvatar(user.getAvatar());
            dto.setRoleId(user.getRoleId());
            return dto;
        }
        return null;
    }

    @Override
    public UserEditDto findByIdForEdit(int id) {
        return null;
    }

    @Override
    public AuthenticatedUserDto findByEmailForAuthentication(String email) {
        try {
            UserDto user = userRepository.findByEmail(email);
            if (user != null) {
                return new AuthenticatedUserDto(user.getEmail(), user.getFullName(),
                        user.getAvatar());
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserDto> findUserRoleName(String name) {
        return null;
    }
}
