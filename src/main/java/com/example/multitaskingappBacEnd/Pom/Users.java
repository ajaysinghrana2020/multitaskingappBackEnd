package com.example.multitaskingappBacEnd.Pom;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user3")
@Entity
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_id;
    String fname;
    String lname;
    String email;
    String password;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="users")
    @JsonIgnore
    private Set<UserRole> userRoles=new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> set=new HashSet<>();
        this.userRoles.forEach(userRole -> {
            set.add(new Authority(userRole.getRole().getRoleName()));
        });
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


//    @OneToMany(mappedBy = "users")
//    private List<Notes> notes;
}
