package com.App.crudv.Dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private long id;
    private String documents;
    private String user_name;
    private String last_name;
    private Date date_birthday;
    private String city;
    private String email;
    private String phone;
    private String occupation;




}
