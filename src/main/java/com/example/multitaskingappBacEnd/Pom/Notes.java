package com.example.multitaskingappBacEnd.Pom;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "notes1")
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int notes_id;
    int time;
    String Title;
    String note;
    Boolean status;

//    @ManyToOne
//    private Users users;
}


