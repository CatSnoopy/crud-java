package com.App.crudv.Controller;

import com.App.crudv.Business.UserBusiness;
import com.App.crudv.Dto.UserDTO;
import com.App.crudv.Entity.User;
import com.App.crudv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/user")
@Controller
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private UserBusiness userBusiness;

    @GetMapping("index")
    public  String index(){
        return  "index";
    }

    @GetMapping("/usuarios")
    public List<User> getId(){
        return userService.findAll();
    }

    @PostMapping ("/add")
    public ResponseEntity<?> add(@RequestBody User user){
        userService.add(user);
        return new ResponseEntity<>("save", HttpStatus.CREATED);
    }

   @PutMapping("update/{id}")
    public String update(@PathVariable Long id, @RequestBody User user){
        User updateUser = userService.findById(id);
        updateUser.setDocuments(user.getDocuments());
        updateUser.setUser_name(user.getUser_name());
        updateUser.setLast_name(user.getLast_name());
        updateUser.setDate_birthday(user.getDate_birthday());
        updateUser.setCity(user.getCity());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        updateUser.setOccupation(user.getOccupation());
        userService.update(updateUser);
        return "Edit";
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        User deleteUser = userService.findById(id);
        userService.delete(deleteUser);
        return "delete";
    }
}

