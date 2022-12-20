package com.example.users.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @NotNull(message = "please enter ID!")
    @Id
    private Integer id;
    @NotEmpty(message = "please enter the name")
    @Min(4)
    private String name;
    @NotEmpty(message = "username should be not empty")
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;

    @NotEmpty(message = "please enter the password")
    private String password;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "email should be not empty")
    @Email
    @Pattern(regexp = "@")
    private String email;

    @NotEmpty(message = "role should be not empty")
    @Pattern(regexp = "(admin|user)",message= "admin|user")
    private String role;


    @NotNull(message = "age should be not null")
    private Integer age;


}

