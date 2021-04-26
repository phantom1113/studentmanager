package com.myclass.studentmanager.service;

import com.myclass.studentmanager.dto.PaymentEachMonthDto;

import java.util.List;

public interface PaymentEachMonthService {
    List<PaymentEachMonthDto> findByStudentId(int id);

    int add(PaymentEachMonthDto dto);

    int deleteById(int id);
}
