package com.example.multitaskingappBacEnd.Repo;

//import Controller.UserController;

import com.example.multitaskingappBacEnd.Pom.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
