package com.example.users.Service;

import com.example.users.Model.User;
import com.example.users.Repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class UserService {


    private final UserRepo userRepo;
    public List<User> getUser()
    {
        return UserRepo.findAll();

    }
    public void addUser(User user){
        UserRepo.save(user);
    }

    public Boolean updateUser(Integer id , User user){
        User olduser= UserRepo.getById(id);
        if(olduser==null){
            return false;
        }
        olduser.setId(user.getId());
        olduser.setName(user.getName());
        olduser.setUsername(user.getUsername());
        olduser.setPassword(user.getPassword());
        olduser.setEmail(user.getEmail());
        olduser.setRole(user.getRole());
        olduser.setAge(user.getAge());

        UserRepo.save(olduser);
        return true;
    }
    public Boolean deleteUser(Integer id){
        User user=UserRepo.getById(id);
        if(user==null){
            return false;
        }
        UserRepo.delete(user);
        return true;
    }

}
