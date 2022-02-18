package com.onlineshopping.controllers;

import com.onlineshopping.model.Photo;
import com.onlineshopping.model.Product;
import com.onlineshopping.services.MyUserDetails;
import com.onlineshopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getPersons(Authentication authentication, @PathVariable String id, Model model){
        if(authentication!=null){
            MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
            model.addAttribute("udetails", details);
            model.addAttribute("isworker", details.isWorker());
        }
        int idI=Integer.parseInt(id);
        Product p =  productService.findProductById(idI);
        ArrayList<Photo> pics=new ArrayList<>();
        pics.add(new Photo("1",p.getPic1()));
        if(p.getPic2()!=null){
            pics.add(new Photo("2",p.getPic2()));
            if(p.getPic3()!=null){
                pics.add(new Photo("3",p.getPic3()));
            }
        }
        model.addAttribute("product",p);
        model.addAttribute("pics",pics);
        return "product";
    }
}
