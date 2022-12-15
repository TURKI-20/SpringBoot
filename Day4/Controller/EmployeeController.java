package com.example.ass4.Controller;

import com.example.ass4.Model.ApiResponse;
import com.example.ass4.Model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1")


public class EmployeeController{
    ArrayList<Employee> employees= new ArrayList<>();

        @GetMapping("/get/{index}")
        public ArrayList<Employee> getEmployees(){
            return employees;
        }


        @PostMapping("/add")
        public ResponseEntity addEmployee(@RequestBody @Valid Employee employee , Errors errors) {
            if (errors.hasErrors()){
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            employees.add(employee);
            return ResponseEntity.status(201).body(new ApiResponse("employee add!"));
        }


        @PutMapping("/update/{index}")
        public ResponseEntity updateEmployee(@PathVariable int index ,@RequestBody @Valid Employee employee , Errors errors){
            if(errors.hasErrors()){
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            employees.set(index,employee);
            return ResponseEntity.status(200).body(new ApiResponse("update Employee!"));
        }


        @DeleteMapping("/delete/{index}")
        public ResponseEntity deleteEmployee(@PathVariable int index , Errors errors){
            if (errors.hasErrors()){
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            employees.remove(index);
            return ResponseEntity.status(201).body(new ApiResponse("delete employee!"));
        }


    }

