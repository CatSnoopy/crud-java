package com.practica.crudoriginal.Repository;
import com.practica.crudoriginal.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
