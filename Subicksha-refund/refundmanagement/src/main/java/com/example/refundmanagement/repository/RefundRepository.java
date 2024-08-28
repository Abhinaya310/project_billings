package com.example.refundmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.refundmanagement.entity.Refund;

public interface RefundRepository extends JpaRepository<Refund,Long>{

}
