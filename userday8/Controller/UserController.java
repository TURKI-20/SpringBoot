package com.example.userday8.Controller;

import com.example.userday8.Dto.ApiResponse;
import com.example.userday8.Model.User;
import com.example.userday8.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers() {
        return ResponseEntity.status(201).body(userService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user) {
        userService.addUser(user);
        return ResponseEntity.status(201).body(new ApiResponse("User Added!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user) {
        userService.updateUser(id, user);
        return ResponseEntity.status(201).body(new ApiResponse("User Updated!"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(201).body(new ApiResponse("User deleted!"));
    }


    @GetMapping("/check/{password}")
    public ResponseEntity check(@RequestBody String username, @PathVariable String password) {
        return ResponseEntity.status(201).body(userService.check(username, password));
    }

    @GetMapping("/get/by/email")
    public ResponseEntity getUserByEmail(@RequestBody String email) {
        return ResponseEntity.status(201).body(userService.getUserByEmail(email));
    }

    @GetMapping("/get/by/role")
    public ResponseEntity getUsersByRole(@RequestBody String role) {
        return ResponseEntity.status(201).body(userService.getUsersByRole(role));
    }

    @GetMapping("/get/by/age")
    public ResponseEntity getUsersByAge(@RequestBody Integer age) {
        return ResponseEntity.status(201).body(userService.getUsersByAge(age));
    }
}
