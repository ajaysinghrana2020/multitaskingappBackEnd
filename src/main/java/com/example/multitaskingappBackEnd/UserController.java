package com.example.multitaskingappBackEnd;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageTranscoder;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path ="/add")
    public ResponseEntity<Users> addNewUser(@RequestBody Users users){
        Users user1=new Users();
        user1.setFname(users.getFname());
        user1.setLname(users.getLname());
        user1.setPassword(users.getPassword());
        user1.setEmail(users.getEmail());
        return ResponseEntity.ok(userRepository.save(user1));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable> getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }


}
