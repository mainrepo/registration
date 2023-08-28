package org.gauravj.usr.registration.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.gauravj.usr.registration.props.RoleStore;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;

@Component
public class ReqToken {
    public static final String SALTED = "mysalts";

    @Autowired
    private RoleStore roleStore;

    public final String generate(String username) {
        String role = roleStore.role(username);
        return Jwts.builder()
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, SALTED)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1 day
                .setClaims(new HashMap<>(){{
                    put("role", role);
                    put("sub", username);
                }})
                .compact();
    }

}
