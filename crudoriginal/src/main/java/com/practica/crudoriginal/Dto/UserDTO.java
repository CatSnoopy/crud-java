package com.practica.crudoriginal.Dto;


import lombok.*;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id_documents;
    private String User_name;
    private String Last_name;
    private String Date;
    private String City;
    private String Email;
    private String Phone;
    private String Occupation;
}
