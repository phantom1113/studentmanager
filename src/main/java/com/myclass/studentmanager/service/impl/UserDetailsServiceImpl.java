package com.myclass.studentmanager.service.impl;

import com.myclass.studentmanager.dto.UserDto;
import com.myclass.studentmanager.entity.CustomUserDetails;
import com.myclass.studentmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Phương thức kiểm tra email or username
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //Danh sách chứa tên quyền của người dùng
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDto dto = userRepository.findByEmail(email);
        if(dto == null) {
            throw new UsernameNotFoundException("Error Login");
        }


        authorities.add(new SimpleGrantedAuthority(dto.getRoleName()));

        //Lấy thông tin đăng nhập
        CustomUserDetails customUserDetail = new CustomUserDetails(email, dto.getPassword(), authorities);
        customUserDetail.setAvatar(dto.getAvatar());
        customUserDetail.setId(dto.getId());
        customUserDetail.setFullName(dto.getFullName());
        customUserDetail.setRoleName(dto.getRoleName());
        return customUserDetail;
    }

}
