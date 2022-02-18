package com.onlineshopping.controllers;

import com.onlineshopping.model.User;
import com.onlineshopping.repositories.UserRepository;
import com.onlineshopping.services.MyUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    private final MyUserDetailsService userService;
    private final UserRepository userRepository;

    public RegisterController(MyUserDetailsService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/registerCheck")
    public String check(@ModelAttribute("username") String username, @ModelAttribute("password1") String password1, @ModelAttribute("password2") String password2, final Model model){
        if(password1.equals(password2)){
            User tmp = userService.findByUsername(username);
            if(tmp == null){
                User u = new User(username,password1,"client");
                userRepository.save(u);
                return "login";
            }else {
                errorHandler(model,1);
            }
        }else{
            errorHandler(model,2);
        }
        return errorHandler(model,0);
    }

    @RequestMapping("/register-Error")
    public String errorHandler(final Model model, int errorNr){
        model.addAttribute("registerError",true);
        if (errorNr==1)
            model.addAttribute("alreadyExists", true);
        if (errorNr==2)
            model.addAttribute("notSamePasswords", true);
        return "register";
    }

}
