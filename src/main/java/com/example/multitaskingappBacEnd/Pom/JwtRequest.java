package com.example.multitaskingappBacEnd.Pom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {
    String username;
    String password;

    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {

        this.username = username;
        this.password = password;
    }
}

