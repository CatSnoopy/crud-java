package com.practica.crudoriginal.Service;

import com.practica.crudoriginal.Entity.UserEntity;
import com.practica.crudoriginal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements idao<UserEntity, Long> {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserEntity> findAll(){
        return this.userRepository.findAll();
    }
    @Override
    public UserEntity getById(Long id){
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        return optionalUserEntity.orElse((null));
    }
    @Override
    public void save(UserEntity entity){
        this.userRepository.save(entity);
    }
    @Override
    public void update(UserEntity entity) {
        this.userRepository.save(entity);
    }


    @Override
    public void create(UserEntity entity){
        this.userRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        this.userRepository.deleteById(id);
    }
}
