package com.myclass.studentmanager.repository;

import com.myclass.studentmanager.entity.PaymentEachMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentEachMonthRepository extends JpaRepository<PaymentEachMonth, Integer> {
    List<PaymentEachMonth> findPaymentEachMonthByStudentId(int studentId);
}
