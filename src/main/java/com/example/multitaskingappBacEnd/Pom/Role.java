package com.example.multitaskingappBacEnd.Pom;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "roles1")
@Entity
public class Role {
    @Id
     int roleId;
     String roleName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy ="role")
    private Set<UserRole> userRoles=new HashSet<>();
}
