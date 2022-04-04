package com.sparta.week5.repository;

import com.sparta.week5.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderList,Long> {
}

