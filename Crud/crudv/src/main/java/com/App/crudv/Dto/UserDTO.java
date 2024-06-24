package com.App.crudv.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String user_name;
    private String last_name;
    private String date_birthday;
    private String city;
    private String email;
    private String phone;
    private String occupation;
}
