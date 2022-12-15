package com.example.ass4.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor


public class Employee {
    @NotEmpty(message = "please enter your ID")
    @Size(min = 2 , message = "must be more than 2")
    String ID;


    @NotEmpty(message = "please enter your name")
    @Size(min = 4 , message = "please your name must be more than 4")
    String name;


    @NotNull(message = "please enter your age")
    @Min(value = 25 , message = "sorry your age less than 25!")
    int age;


    @AssertFalse(message = "must be false")
    boolean onLeave;


    @NotNull(message = "please enter your employment year!")
    @Min(1980)
    @Max(2022)
    int employmentYear;


    @NotNull(message = "please enter your annul Leave")
    @Min(value = 0 ,message = "not valid number")
    int annulLeave;
}
