package com.practica.crudoriginal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documents", nullable = false)
    private Long id_documents;

    @Column(name = "User_Name", nullable = false)
    private String User_Name;

    @Column(name = "Last_Name", nullable = false)
    private String Last_Name;

    @Column(name = "InvDate", nullable = false)
    private Date InvDate;

    @Column(name = "City", nullable = false)
    private String City;

    @Column(name = "Email", nullable = false)
    private String Email;

    @Column(name = "Phone", nullable = false)
    private String Phone;

    @Column(name = "Occupation", nullable = false)
    private String Occupation;
}
