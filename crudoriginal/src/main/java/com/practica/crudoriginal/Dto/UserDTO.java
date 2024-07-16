package com.practica.crudoriginal.Dto;


import lombok.*;

import java.sql.Date;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private Long documents;
    private String User_name;
    private String Last_name;
    private Date InvDate;
    private String City;
    private String Email;
    private String Phone;
    private String Occupation;
}
