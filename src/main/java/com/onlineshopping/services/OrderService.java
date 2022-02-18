package com.onlineshopping.services;

import com.onlineshopping.model.Orders;
import com.onlineshopping.model.User;
import com.onlineshopping.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    public void makeOrder(Orders orders){
        orderRepository.save(orders);
    }

    public List<Orders> findOrders(){
        return orderRepository.findAll();
    }

    public List<Orders> findUnseenOrders() {
        return orderRepository.findBySeenByWorker(false);
    }

    public Orders findOrdersById(long id){
        return orderRepository.getById((int) id);
    }
}
