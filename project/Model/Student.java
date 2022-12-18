package com.example.project.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {


    @NotNull(message = "please enter id!")
    private Integer id;

    @NotEmpty(message = "please enter name!")
    private String name;

    @NotNull(message = "please enter age!")
    private Integer age;

    @Pattern(regexp = "(CS|Math|Engineer)",message="What is the major ? CS|MATH|Engineer")
    @NotEmpty(message = "please enter major!")
    private String major;
}

