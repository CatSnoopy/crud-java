package com.App.crudv.Business;

import com.App.crudv.Dto.UserDTO;
import com.App.crudv.Entity.User;
import com.App.crudv.Service.UserService;
import com.App.crudv.utils.Exceptions.Http.CustomExceptions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserBusiness {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    public void add(UserDTO userDTO) {
        try {
            User user = modelMapper.map(userDTO, User.class);
            userService.save(user);
        } catch (Exception e) {
            throw new CustomExceptions("Error adding user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<UserDTO> findAll() {
        try {
            List<User> userList = this.userService.findAll();
            if (userList.isEmpty()) {
                return new ArrayList<>();
            }
            List<UserDTO> userDTOList = new ArrayList<>();
            userList.forEach(user -> {
                System.out.println("Mapping user: " + user);
                UserDTO userDTO = modelMapper.map(user, UserDTO.class);
                System.out.println("Mapped UserDTO: " + userDTO);
                userDTOList.add(userDTO);
            });
            return userDTOList;
        } catch (Exception e) {
            throw new CustomExceptions("Error getting users", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public UserDTO findById(Long id) {
        try {
            User user = this.userService.getById(id);
            if (user == null) {
                throw new CustomExceptions("User not found", HttpStatus.NOT_FOUND);
            }
            System.out.println("Mapping user: " + id);
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            System.out.println("Mapped UserDTO: " + userDTO);
            return userDTO;
        } catch (Exception e) {
            throw new CustomExceptions("Error getting user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Map<String, Object> save(UserDTO userDTO) {
        try {
            User user = modelMapper.map(userDTO, User.class);
            userService.save(user);
            return Map.of("status", "success", "message", "User saved successfully");
        } catch (Exception e) {
            throw new CustomExceptions("Error saving user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void update(UserDTO updateUser) {
        try {
            User user = modelMapper.map(updateUser, User.class);
            userService.update(user);
        } catch (Exception e) {
            throw new CustomExceptions("Error updating user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delete(UserDTO deleteUser) {
        try {
            User user = modelMapper.map(deleteUser, User.class);
            userService.delete(user);
        } catch (Exception e) {
            throw new CustomExceptions("Error deleting user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
