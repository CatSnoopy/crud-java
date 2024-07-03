package com.App.crudv.Controller;

import com.App.crudv.Business.UserBusiness;
import com.App.crudv.Dto.UserDTO;
import com.App.crudv.utils.Exceptions.Http.ResponseHttpApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequestMapping(path = "/user")
@Controller
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserBusiness userBusiness;

    @GetMapping("/all")
    public Map<String, Object> findAll(){
        List<UserDTO> userDTOList = userBusiness.findAll();
        if (userDTOList.isEmpty()){
            return ResponseHttpApi.responseHttpFind("No user available", new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
        else {
            return ResponseHttpApi.responseHttpFind("successfully completed ", new ArrayList<>(), HttpStatus.OK);
        }
    }
    @GetMapping("/usuarios")
    public Map<String, Object> findById(Long id){
        List<UserDTO> userDTOList = userBusiness.findById(id);
        if (userDTOList.isEmpty()){
            return  ResponseHttpApi.responseHttpFind("No user available", new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
        else {
            return ResponseHttpApi.responseHttpFind("Successfully completed", new ArrayList<>(), HttpStatus.OK);
        }
    }

    @PostMapping ("/add")
    public ResponseEntity<?> add(@RequestBody UserDTO userDTO){
        userBusiness.add(userDTO);
        return new ResponseEntity<>("save", HttpStatus.CREATED);
    }

   @PutMapping("update/{id}")
    public String update(@PathVariable Long id, @RequestBody UserDTO userDTO){
        UserDTO updateUser = userBusiness.findById(id);
        userBusiness.update(updateUser);
        return "Edit";
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        UserDTO deleteUser = userBusiness.findById(id);
        userBusiness.delete(deleteUser);
        return "delete";
    }


}

