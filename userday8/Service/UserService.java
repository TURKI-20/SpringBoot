package com.example.userday8.Service;

import com.example.userday8.Exception.ApiException;
import com.example.userday8.Model.User;
import com.example.userday8.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public void addUser(User user)
    {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User olduser = userRepository.findUserById(id);
        if(olduser == null)
            throw new ApiException("User not found!");
        olduser.setAge(user.getAge());
        olduser.setName(user.getName());
        olduser.setRole(user.getRole());
        olduser.setEmail(user.getEmail());
        olduser.setPassword(user.getPassword());
        olduser.setUsername(user.getUsername());
        userRepository.save(olduser);

    }

    public void deleteUser(Integer id) {
        if(userRepository.findUserById(id) == null)
            throw new ApiException("User not found!");
        userRepository.deleteById(id);

    }


    public User check(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if(user == null)
            throw new ApiException("Username not found!");
        if(user.getPassword().equals(password))
            throw new ApiException("Password not true!");
        return user;
    }


    public User getUserByEmail(String email)
    {
        if(userRepository.findUserByEmail(email) == null)
            throw new ApiException("User not found!");
        return userRepository.findUserByEmail(email);
    }


    public List<User> getUsersByRole(String role) {
        if(userRepository.findAllByRole(role).isEmpty())
            throw new ApiException("this role not found!");
        return userRepository.findAllByRole(role);
    }


    public List<User> getUsersByAge(Integer age) {
        if(userRepository.findAllByAgeGreaterThanEqual(age).isEmpty())
            throw new ApiException("this age or above not found!");
        return userRepository.findAllByAgeGreaterThanEqual(age);
    }

}
