package com.example.userday8.Repository;

import com.example.userday8.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


        User findUserById(Integer id);

        User findUserByUsername(String username);

        User findUserByEmail(String email);
        List<User> findAllByRole(String role);

        List<User> findAllByAgeGreaterThanEqual(Integer age);
    }

