package com.eichiba.demo.service;

import com.eichiba.demo.entitys.User;
import com.eichiba.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public User getUser(String id){
        return userRepository.getOne(Integer.parseInt(id));
    }

}
