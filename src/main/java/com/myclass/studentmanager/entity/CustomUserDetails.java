package com.myclass.studentmanager.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
//Class dùng để custom thông tin của UserDetail dung xác thực và phân quyền
public class CustomUserDetails extends org.springframework.security.core.userdetails.User implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String avatar;

    private int id;

    private String fullName;

    private String roleName;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}