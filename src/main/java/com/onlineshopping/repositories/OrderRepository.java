package com.onlineshopping.repositories;

import com.onlineshopping.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    public List<Orders> findBySeenByWorker(boolean seenByWorker);
}
