package com.onlineshopping.controllers;

import com.onlineshopping.services.MyUserDetailsService;
import com.onlineshopping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    private final MyUserDetailsService userService;

    @Autowired
    public LoginController(MyUserDetailsService userService){
        this.userService = userService;
    }

    @RequestMapping("/login-error")
    public String loginError(final Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping(value = "/print", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        System.out.println(authentication.getName());
        return authentication.getName();
    }

}