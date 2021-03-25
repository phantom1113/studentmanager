package com.myclass.studentmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "payments")
public class PaymentEachMonth {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_payment")
    Date datePayment;

    @Column(name = "student_id")
    private int studentId;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    @JsonIgnore
    private Student student;
}
