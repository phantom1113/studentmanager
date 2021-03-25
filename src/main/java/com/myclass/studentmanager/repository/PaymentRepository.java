package com.myclass.studentmanager.repository;

import com.myclass.studentmanager.entity.PaymentEachMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEachMonth, Integer> {
}
