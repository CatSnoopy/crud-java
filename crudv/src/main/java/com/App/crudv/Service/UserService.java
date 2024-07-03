package com.App.crudv.Service;



import com.App.crudv.Entity.User;
import com.App.crudv.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User getById(Long id){
        optional<User>optional
        return userRepository.findById(id);
    }
    public void save (User object) {
        userRepository.save((object));
    }
    public void update(User use){
        userRepository.save(use);
    }
    public void delete(User use){
        userRepository.save(use);
    }


}
