package com.myclass.studentmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="students")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String fullName;

    @Column(name = "grade")
    private String grade;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<PaymentEachMonth> payments;
}
