package com.App.crudv.Business;
import com.App.crudv.Dto.UserDTO;
import com.App.crudv.Service.dao.idao;

import com.App.crudv.Entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserBusiness{
    public void add(UserDTO userDTO) {

    }


    public List<UserDTO> findAll() {
        return List.of();
    }

    public UserDTO findById(Long id) {
        return null;
    }

    public Map<String, Object> save(UserDTO userDTO){
        return null;
    }

    public void update() {

    }

    public void delete() {

    }


}
