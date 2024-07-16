package com.practica.crudoriginal.Business;

import com.practica.crudoriginal.Dto.UserDTO;
import com.practica.crudoriginal.Entity.UserEntity;
import com.practica.crudoriginal.Service.UserService;
import com.practica.crudoriginal.utilities.CustomException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserBusiness {

    @Autowired
    private UserService userService;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<UserDTO> findAll(){
        try {
            List<UserEntity> userEntities = userService.findAll();
            List<UserDTO> userDTOList = new ArrayList<>();

            for (UserEntity users : userEntities){
                userDTOList.add(modelMapper.map(users, UserDTO.class));
            }
            return userDTOList;
        }catch (Exception e){
            throw new CustomException("Error getting user", e);
        }

    }
    public Boolean create(UserDTO userDTO){
        try {
            UserEntity users = modelMapper.map(userDTO, UserEntity.class);
            userService.save(users);
            return true;
        }catch (Exception e){
            throw new CustomException("Error adding user", e);
        }

    }
    public Boolean update( Long id, UserDTO userDTO){
        try {
            UserEntity users = modelMapper.map(userDTO, UserEntity.class);
            users.setId(id);
            userService.update(users);
            return true;
        }catch (Exception e){
            throw new  CustomException("Error update user", e);
        }

    }
    public Boolean delete(long id_documents){
        try {
            userService.delete(id_documents);
            return true;
        }catch (Exception e){
            throw new CustomException("Error deleting user", e);
        }
    }

}
