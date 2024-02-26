package com.example.multitaskingappBacEnd.Controller;

import com.example.multitaskingappBacEnd.Pom.Role;
import com.example.multitaskingappBacEnd.Pom.UserRole;
import com.example.multitaskingappBacEnd.Pom.Users;
import com.example.multitaskingappBacEnd.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user
    @PostMapping("/")
    public Users createUser(@RequestBody Users user) throws Exception {


//        user.setProfile("default.png");
        //encoding password with bcryptpasswordencoder

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(0);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);


        return this.userService.createUser(user, roles);

    }

    @GetMapping("/{username}")
    public Users getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //delete the user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }


    //update api


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> exceptionHandler(UsernameNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }


}