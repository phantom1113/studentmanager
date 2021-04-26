package com.myclass.studentmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEachMonthDto {
    private int id;
    private Date datePayment;
    private int studentId;
}
