package com.epam.rd.izh.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "registered_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredUser implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @Size(min = 2, max = 20, message = "first name must be min 2 symbols, max 20 symbols")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "role")
    private String role;

    @Column(name = "country")
    private String country;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar_path")
    private String avatarPath;



    public RegisteredUser(String firstName, String lastName, String login, String password, String role,
                          String country, String phoneNumber, String email, String avatarPath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
