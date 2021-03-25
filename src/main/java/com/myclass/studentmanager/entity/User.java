package com.myclass.studentmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name", nullable = false, columnDefinition = "TEXT")
    private String fullName;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "role_id")
    private int roleId;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    @JsonIgnore
    private Role role;
}
