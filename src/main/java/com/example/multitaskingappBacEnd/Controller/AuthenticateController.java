package com.example.multitaskingappBacEnd.Controller;

import com.example.multitaskingappBacEnd.Pom.JwtRequest;
import com.example.multitaskingappBacEnd.Pom.JwtResponse;
import com.example.multitaskingappBacEnd.config.JwtUtils;
import com.example.multitaskingappBacEnd.service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    //generate Token
    @PostMapping(value = "/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not Found");
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token =this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }

    private void authenticate(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(username,password));
        }catch(DisabledException e)
        {
            throw new Exception("user disabled" +e.getMessage());
        }
        catch (BadCredentialsException e){
            throw new Exception("invalid creds"+e.getMessage());
        }
    }
}
