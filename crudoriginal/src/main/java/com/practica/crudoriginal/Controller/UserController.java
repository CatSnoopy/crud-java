package com.practica.crudoriginal.Controller;

import com.practica.crudoriginal.Business.UserBusiness;
import com.practica.crudoriginal.Dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.practica.crudoriginal.utilities.ResponseHttpApi;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/crudoriginal/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @GetMapping("/allusers")
    public List<UserDTO> getAllUsers(){
        return userBusiness.findAll();}

    @PostMapping("/createusers")
    public Map<String, Object> create(@RequestBody UserDTO userDTO) {
        if (this.userBusiness.create(userDTO)) {
            return ResponseHttpApi.responseHttpPost("holi", HttpStatus.CREATED);
        } else {
            return ResponseHttpApi.responseHttpPost("ll", HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/updateusers/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDTO userDTO){
        this.userBusiness.update(id,userDTO );}

    @DeleteMapping("/deleteusers/{id}")
    public void delete(@PathVariable("id") Long id){
        this.userBusiness.delete(id);}
}
