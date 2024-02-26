package com.example.multitaskingappBacEnd.Pom;

import org.springframework.security.core.GrantedAuthority;

public class Authority  implements GrantedAuthority {

    private String Auth;

    public Authority(String Auth){
        this.Auth=Auth;
    }
    @Override
    public String getAuthority() {
        return this.Auth;
    }
}
