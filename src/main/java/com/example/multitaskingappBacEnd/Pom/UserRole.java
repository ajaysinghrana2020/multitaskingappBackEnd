package com.example.multitaskingappBacEnd.Pom;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_role")
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users user;

    @ManyToOne
    private Role role;
}
