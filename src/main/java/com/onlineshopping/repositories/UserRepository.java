package com.onlineshopping.repositories;


import com.onlineshopping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsername(String username);
}
