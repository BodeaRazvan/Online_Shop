package com.onlineshopping.controllers;

import com.onlineshopping.model.Orders;
import com.onlineshopping.repositories.OrderRepository;
import com.onlineshopping.services.MyUserDetails;
import com.onlineshopping.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class WorkerController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @Autowired
    public WorkerController(OrderService orderService, OrderRepository orderRepository){
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public String unseenOrders(Model model) {
        List<Orders> orders = orderService.findUnseenOrders();

        model.addAttribute("unseenOrders", orders);
        return "worker";
    }

    @RequestMapping("/see/worker")
    public String seeOrder(Authentication authentication, @RequestParam(required = false) Optional<String> id, Model model) {
        if(authentication!=null){
            MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
            model.addAttribute("udetails", details);
            model.addAttribute("isworker", details.isWorker());
        }
        if (id.isPresent()) {
            Integer orderId = Integer.parseInt(id.get());
            Orders order = orderService.findOrdersById(orderId);
            order.setSeenByWorker(true);
            orderRepository.save(order);
            id = Optional.empty();
            return this.unseenOrders(model);
        }
        else {
            return this.unseenOrders(model);
        }
    }
}
