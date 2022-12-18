package com.example.project.Controllers;
import com.example.project.Model.Teacher;
import com.example.project.Service.TeacherS;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherC {




        private final TeacherS teacherService;

        @GetMapping("/get")
        public ResponseEntity getTeachers()
        {

            ArrayList<Teacher> teachers = teacherService.getTeachers();
            return ResponseEntity.status(201).body(teachers);

        }

        @PostMapping("/add")
        public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher , Errors errors)
        {
            if(errors.hasErrors())
                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            teacherService.addTeacher(teacher);
            return ResponseEntity.status(201).body("Teacher was Added!");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateTeacher(@PathVariable int id , @RequestBody @Valid Teacher teacher, Errors errors)
        {
            if(errors.hasErrors())
                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            if(teacherService.updateTeacher(id,teacher))
                return ResponseEntity.status(201).body("Teacher was updated!");
            return ResponseEntity.status(400).body("we can not found teacher!");
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteTeacher(@PathVariable int id)
        {
            if(teacherService.deleteTeacher(id))
                return ResponseEntity.status(201).body("teacher was deleted!");
            return ResponseEntity.status(400).body("we can not found teacher!");
        }

        @GetMapping("/get/name")
        public ResponseEntity getTeacherByName(@RequestBody String name)
        {
            Teacher teacher = teacherService.getTeacherByName(name);
            if( teacher != null)
                return ResponseEntity.status(201).body(teacher);
            return ResponseEntity.status(400).body("we can not found teacher!");
        }

        @GetMapping("/get/salary")
        public ResponseEntity getTeachersBySalary(@RequestBody Integer salary)
        {
            ArrayList<Teacher> salaryTeachers = teacherService.getTeachersBySalary(salary);
            if(!salaryTeachers.isEmpty())
                return ResponseEntity.status(201).body(salaryTeachers);
            return ResponseEntity.status(400).body("we can not found teacher has this salary"+salary+"or above");
        }
}