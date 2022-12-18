package com.example.project.Controllers;
import com.example.project.Model.Student;
import com.example.project.Service.StudentS;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentC {

        private final StudentS studentService;

        @GetMapping("/get")
        public ResponseEntity getStudents()
        {
            ArrayList<Student> students = studentService.getStudents();
            return ResponseEntity.status(201).body(students);
        }

        @PostMapping("/add")
        public ResponseEntity addStudent(@RequestBody @Valid Student student , Errors errors)
        {
            if(errors.hasErrors())
                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            studentService.addStudent(student);
            return ResponseEntity.status(201).body("Student was Added!!");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateStudent(@PathVariable int id , @RequestBody @Valid Student student, Errors errors)
        {
            if(errors.hasErrors())
                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            if(studentService.updateStudent(id, student))
                return ResponseEntity.status(201).body("Student was updated!");
            return ResponseEntity.status(400).body("we can not found student!");
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteStudent(@PathVariable int id)
        {
            if(studentService.deleteStudent(id))
                return ResponseEntity.status(201).body("Student was deleted!");
            return ResponseEntity.status(400).body("we can not found student!");
        }

        @GetMapping("/get/{id}")
        public ResponseEntity getStudentByID(@PathVariable int id)
        {
            Student student= studentService.getStudentById(id);
            if(student != null)

                return ResponseEntity.status(201).body(student);

            return ResponseEntity.status(400).body("we can not found student!");
        }

        @GetMapping("/get/name")
        public ResponseEntity getStudentByName(@RequestBody String name)
        {
            Student student = studentService.getStudentsByName(name);
            if(student != null)

                return ResponseEntity.status(201).body(student);

            return ResponseEntity.status(400).body("we can not found student!");
        }

        @GetMapping("/get/major")
        public ResponseEntity getMajorStudents(@RequestBody String major)
        {
            ArrayList<Student> majorStudents = studentService.getMajorStudents(major);
            if(!majorStudents.isEmpty())
                return ResponseEntity.status(201).body(majorStudents);
            return ResponseEntity.status(400).body("we can not found student under : "+major);
        }

        @GetMapping("/get/age")
        public ResponseEntity getAgeStudents(@RequestBody Integer age)
        {
            ArrayList<Student> ageStudents = studentService.getAgeStudents(age);
            if(!ageStudents.isEmpty())
                return ResponseEntity.status(201).body(ageStudents);
            return ResponseEntity.status(400).body("we can found student his age :"+age+" or above");
        }

}


