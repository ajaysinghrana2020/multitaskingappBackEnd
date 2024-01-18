package com.example.multitaskingappBackEnd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user1")
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_id;
    String fname;
    String lname;
    String email;
    String password;

    @OneToMany(mappedBy = "users")
    private List<Notes> notes;
}
