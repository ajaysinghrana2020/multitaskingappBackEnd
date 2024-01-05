package com.example.multitaskingappBackEnd;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "user1")
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_id;
    String name;
    String email;

    @OneToMany(mappedBy = "users")
    private List<Notes> notes;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users(int user_id, String name, String email) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
    }

    public Users() {

    }
}
