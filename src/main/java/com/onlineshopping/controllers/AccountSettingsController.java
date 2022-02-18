package com.onlineshopping.controllers;

import com.onlineshopping.model.User;
import com.onlineshopping.repositories.UserRepository;
import com.onlineshopping.services.MyUserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountSettingsController {
    private final MyUserDetailsService userService;
    private final UserRepository userRepository;

    public AccountSettingsController(MyUserDetailsService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/changeUsername")
    public String changeUsername(Authentication authentication, @ModelAttribute("username") String newUsername, @ModelAttribute("password") String password, final Model model){
        User u = userService.findByUsername(authentication.getName());
        if(newUsername.isEmpty()){
            model.addAttribute("emptyPassword",true);
            return "accountSettings";
        }
        if(password.equals(u.getPassword())){
            u.setUsername(newUsername);
            userRepository.save(u);
            model.addAttribute("changeUserSuccess",true);
            return "login";
        }
        model.addAttribute("wrongPassword",true);
        return "accountSettings";
    }

    @RequestMapping("/changePassword")
    public String changePassword(Authentication authentication, @ModelAttribute("password2") String password, @ModelAttribute("newpassword1") String newPass1, @ModelAttribute("newpassword2") String newPass2, final Model model){
        User u = userService.findByUsername(authentication.getName());
        if(password.equals(u.getPassword())){
            if(newPass1.equals(newPass2) && !newPass1.isEmpty()){
                u.setPassword(newPass1);
                userRepository.save(u);
                model.addAttribute("changePasswordSuccess",true);
                return "login";
            }else{
                if(newPass1.isEmpty() || newPass2.isEmpty()){
                    model.addAttribute("emptyPassword",true);
                    return "accountSettings";
                }
                model.addAttribute("differentPasswords",true);
                return "accountSettings";
            }
        }else{
            model.addAttribute("wrongPassword",true);
            return "accountSettings";
        }
    }
}
