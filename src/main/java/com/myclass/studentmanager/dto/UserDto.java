package com.myclass.studentmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int id;

    private String email;

    private String password;

    private String fullName;

    private String avatar;

    private int roleId;

    private String roleDesc;
    private String roleName;

    public UserDto(int id, String email, String password, String fullName, String avatar, int roleId, String roleDesc,
                   String roleName) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.roleId = roleId;
        this.roleDesc = roleDesc;
        this.roleName = roleName;
    }

    public UserDto(String email, String password, String roleName) {
        super();
        this.email = email;
        this.password = password;
        this.roleName = roleName;
    }

    public UserDto(int id, String email, String password, String fullName, String avatar, String roleName) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.roleName = roleName;
    }

    public UserDto(int id, String fullName) {
        super();
        this.id = id;
        this.fullName = fullName;
    }

}
