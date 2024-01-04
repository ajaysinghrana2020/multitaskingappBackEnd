package com.example.multitaskingappBackEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path="/demo")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path ="/add")
    public ResponseEntity<Users> addNewUser(@RequestBody Users users){
        Users user1=new Users();
        user1.setName(users.getName());
        user1.setEmail(users.getEmail());
        return ResponseEntity.ok(userRepository.save(user1));

    }


}
