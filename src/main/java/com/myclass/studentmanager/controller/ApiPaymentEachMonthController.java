package com.myclass.studentmanager.controller;

import com.myclass.studentmanager.dto.PaymentEachMonthDto;
import com.myclass.studentmanager.service.PaymentEachMonthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class ApiPaymentEachMonthController {
    PaymentEachMonthService paymentEachMonthService;

    public ApiPaymentEachMonthController(PaymentEachMonthService paymentEachMonthService) {
        this.paymentEachMonthService = paymentEachMonthService;
    }

    @GetMapping("studenid/{id}")
    public ResponseEntity<Object> getPaymentByStudentId(@PathVariable("id") int id){
        try {
            List<PaymentEachMonthDto> dtos = paymentEachMonthService.findByStudentId(id);
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
