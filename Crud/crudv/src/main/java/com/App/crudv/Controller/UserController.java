package com.App.crudv.Controller;

import com.App.crudv.Entity.User;
import com.App.crudv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("index")
    public  String index(){
        return  "index";
    }

    @GetMapping("/Usuarios")
    public List<User> getId(){
        return userService.findAll();
    }

    @GetMapping ("/add")
    public String add(@RequestBody User user){
        System.out.println("QQQQQQQ@@@@@@"+user.toString());
        userService.add(user);
        return "guardar";
    }

   @PutMapping("update/{id}")
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
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        User deleteUser = userService.findById(id);
        userService.delete(deleteUser);
        return "Eliminado";
    }
}

