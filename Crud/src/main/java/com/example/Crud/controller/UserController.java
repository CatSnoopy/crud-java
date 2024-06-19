package com.example.Crud.controller;


import com.example.Crud.entity.User;
import com.example.Crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public  String index(){
        return  "Conectar";
    }

    @GetMapping("/Usuarios")
    public List<User> getUsuarios(){
        return userService.findAll();
    }

    @PostMapping("/grabar")
    public String add(@RequestBody User user){
        userService.add(user);
        return "Grabado";
    }

    @PutMapping("editar/{id}")
    public String update(@PathVariable Long id, @RequestBody User user){
        User updateUser = userService.findById(id);
        updateUser.setUser_name(user.getUser_name());
        updateUser.setLast_name(user.getLast_name());
        updateUser.setDate_birthday(user.getDate_birthday());
        updateUser.setCity(user.getCity());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        updateUser.setOccupation(user.getOccupation());
        userService.update(updateUser);
        return "Editado";
    }
    @DeleteMapping("eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        User deleteUser = userService.findById(id);
        userService.delete(deleteUser);
        return "Eliminado";
    }
}

