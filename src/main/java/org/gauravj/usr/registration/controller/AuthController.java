package org.gauravj.usr.registration.controller;

import org.springframework.http.ResponseEntity;
import org.gauravj.usr.registration.security.ReqToken;
import org.gauravj.usr.registration.model.AuthRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RestController
public class AuthController {

    @Autowired
    ReqToken reqToken;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/api/token")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsrname());
        if (userDetails.getPassword().equals(authRequest.getPassword())) {
            String token = reqToken.generate(userDetails.getUsername());
            log.info("/api/token::authenticate:success");
            return ResponseEntity.ok(token);
        } else {
            log.error("/api/token::authenticate:failure");
            return ResponseEntity.badRequest().build();
        }
    }
}
