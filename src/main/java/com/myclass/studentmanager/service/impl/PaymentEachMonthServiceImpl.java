package com.myclass.studentmanager.service.impl;

import com.myclass.studentmanager.dto.PaymentEachMonthDto;
import com.myclass.studentmanager.entity.PaymentEachMonth;
import com.myclass.studentmanager.repository.PaymentEachMonthRepository;
import com.myclass.studentmanager.service.PaymentEachMonthService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentEachMonthServiceImpl implements PaymentEachMonthService {
    private final PaymentEachMonthRepository paymentEachMonthRepository;

    public PaymentEachMonthServiceImpl(PaymentEachMonthRepository paymentEachMonthRepository) {
        this.paymentEachMonthRepository = paymentEachMonthRepository;
    }

    @Override
    public List<PaymentEachMonthDto> findByStudentId(int id) {
        List<PaymentEachMonth> paymentEachMonths = paymentEachMonthRepository.findPaymentEachMonthByStudentId(id);
        List<PaymentEachMonthDto> paymentEachMonthDtos = new ArrayList<>();
        if(paymentEachMonths.isEmpty()){
            return  null;
        }
        for (PaymentEachMonth obj: paymentEachMonths) {
            PaymentEachMonthDto dto = new PaymentEachMonthDto(obj.getId(), obj.getDatePayment(), obj.getStudentId());
            paymentEachMonthDtos.add(dto);
        }
        return paymentEachMonthDtos;
    }

    @Override
    public int add(PaymentEachMonthDto dto) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
