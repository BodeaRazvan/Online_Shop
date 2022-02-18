package com.onlineshopping.services;

import com.onlineshopping.model.User;
import com.onlineshopping.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public User findUserById(long id){
        return userRepository.getById((int) id);
    }

    public User findByUsername(String username){return userRepository.findByUsername(username);}

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(user);
    }


}
