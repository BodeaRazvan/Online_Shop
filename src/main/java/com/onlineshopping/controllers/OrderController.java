package com.onlineshopping.controllers;

import com.onlineshopping.model.OrderText;
import com.onlineshopping.model.Orders;
import com.onlineshopping.model.Product;
import com.onlineshopping.model.User;
import com.onlineshopping.repositories.OrderRepository;
import com.onlineshopping.services.MyUserDetailsService;
import com.onlineshopping.services.OrderService;
import com.onlineshopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final MyUserDetailsService userService;
    private final ProductService productService;
    private final OrderRepository orderRepository;

    @Autowired
    public  OrderController(OrderService orderService,MyUserDetailsService userService,ProductService productService, OrderRepository orderRepository){
        this.orderService=orderService;
        this.userService = userService;
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/orders")
    public String show(final Model model){
          orderService.findOrders();
        ArrayList<Orders> orders=new ArrayList(orderService.findOrders());
        ArrayList<OrderText> ot=new ArrayList<>();
        if(!orders.isEmpty()) {
            for (Orders order : orders) {
                ot.add(new OrderText(order.getId(),
                        userService.findUserById(order.getIdUser()).getUsername(),
                        productService.findProductById(order.getIdProduct()).getName(),order.getIdProduct(),order.getQuantity()));
            }
        }
        model.addAttribute("orders",ot);
        return "orders";
    }

    @RequestMapping("/makeorder")
    public String makeOrder(Authentication authentication,
                      @ModelAttribute("productId") Number productId,
                      @ModelAttribute("quantity") Number quantity,
                      final Model model) {

        User user = userService.findByUsername(authentication.getName());
        Orders orders = new Orders(user.getId(),productId.intValue(),quantity.intValue());
        orderService.makeOrder(orders);

        ArrayList<Product> p= new ArrayList<Product>(productService.findProducts());
        model.addAttribute("products",p);
        return "productList";
    }
}
