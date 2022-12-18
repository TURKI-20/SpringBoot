package com.example.project.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {


        @NotNull(message = "please enter id!")
        private Integer id;

        @NotEmpty(message = "please enter name!")
        private String name;

        @NotNull(message = "please enter salary!")
        private Integer salary;
}
