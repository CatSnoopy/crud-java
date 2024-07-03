package com.App.crudv.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    //
    @Column(name = "documents", nullable = false)
    private String documents;
    //
    @Column(name = "user_name", nullable = false)
    private String user_name;
    //
    @Column(name = "last_name", nullable = false)
    private String last_name;
    //
    @Column(name = "date_birthday", nullable = false)
    private Date date_birthday;
    //
    @Column(name = "city", nullable = false)
    private String city;
    //
    @Column(name = "email", nullable = false)
    private String email;
    //
    @Column(name = "phone", nullable = false)
    private String phone;
    //
    @Column(name = "occupation", nullable = false)
    private String occupation;
    //

}
