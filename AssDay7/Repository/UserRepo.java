package com.example.users.Repository;

import com.example.users.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User,Integer> {

}
