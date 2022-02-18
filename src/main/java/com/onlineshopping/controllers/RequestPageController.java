package com.onlineshopping.controllers;

import com.onlineshopping.services.MyUserDetails;
import org.springframework.security.core.Authentication;
import com.onlineshopping.model.Product;
import com.onlineshopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class RequestPageController {
    private final ProductService productService;
    @Autowired
    public RequestPageController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/login")
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping("/register")
    public String goToregisterPage() {
        return "register";
    }

    @RequestMapping("/")
    public String GoToIndex() {
        return "homeUnlogged";
    }

    public void manageAuthentification(Authentication authentication,Model model){
        if(authentication!=null){
            MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
            model.addAttribute("udetails", details);
            model.addAttribute("isworker", details.isWorker());
        }
    }

    @RequestMapping("/home")
    public String goToHome(Authentication authentication, Model model) {
        if(authentication!=null){
            MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
            model.addAttribute("udetails", details);
            model.addAttribute("isworker", details.isWorker());
            model.addAttribute("isclient", details.isClient());
            return "home";
        }
        else{
            return "homeUnlogged";
        }
    }

    @RequestMapping("/accountSettings")
    public String goToAccountSettings(Authentication authentication, @RequestParam(name="username", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("username", authentication.getName());
        MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
        model.addAttribute("udetails", details);
        model.addAttribute("isworker", details.isWorker());
        model.addAttribute("isclient", details.isClient());
        return "accountSettings";
    }

    @RequestMapping("/logOut")
    public String goToLogOut() {
        return "logOut";
    }

    @RequestMapping("/product")
    public String goToProduct(Authentication authentication, Model model){
    manageAuthentification( authentication,  model);
    return "product";
    }

    @RequestMapping("/productList")
    public String goToProductList(Authentication authentication,Model model) {
        ArrayList<Product> p= new ArrayList<Product>(productService.findProducts());
        manageAuthentification( authentication,  model);
        model.addAttribute("products",p);
        return "productList";
    }
}