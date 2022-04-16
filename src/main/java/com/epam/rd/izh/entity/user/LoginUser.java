package com.epam.rd.izh.entity.user;


import lombok.Data;




@Data
public class LoginUser implements User {

    private String login;

    private String password;

}
