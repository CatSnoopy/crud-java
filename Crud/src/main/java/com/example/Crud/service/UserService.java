package com.example.Crud.service;


import com.example.Crud.entity.User;
import com.example.Crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add(User use){
        userRepository.save(use);
    }
    public List<User> findAll(){
        return  userRepository.findAll();
    }
    public User findById(Long id){
        return userRepository.findById(id).get();
    }
    public void update(User use){
        userRepository.save(use);
    }
    public void delete(User use){
        userRepository.save(use);
    }

}
