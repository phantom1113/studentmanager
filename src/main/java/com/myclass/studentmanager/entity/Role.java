package com.myclass.studentmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="roles")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String desc;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<User> users;

    public Role(int id, String name, String desc){
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

}
