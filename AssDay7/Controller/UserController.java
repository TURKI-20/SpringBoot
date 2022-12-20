package com.example.users.Controller;

import com.example.users.Model.User;
import com.example.users.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> users= userService.getUser();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Error errors){
        if (errors.hasError()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(400).body("User added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user ,Error errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (userService.updateUser(id, user)) {
            return ResponseEntity.status(200).body("User update");
        }
        return ResponseEntity.status(400).body("wrong id");
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "user delete";
    }

}
