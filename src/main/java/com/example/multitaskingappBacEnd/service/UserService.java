package com.example.multitaskingappBacEnd.service;

package com.exam.service;

import com.example.multitaskingappBacEnd.Pom.UserRole;
import com.example.multitaskingappBacEnd.Pom.Users;

import java.util.Set;

public interface UserService {

    //creating user
    public Users createUser(Users user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public Users getUser(String username);

    //delete user by id
    public void deleteUser(Long userId);
}