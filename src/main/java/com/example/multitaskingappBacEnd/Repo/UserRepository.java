package com.example.multitaskingappBacEnd.Repo;

//import Controller.UserController;

import com.example.multitaskingappBacEnd.Pom.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Integer> {
    Users findByemail(String email);
}
