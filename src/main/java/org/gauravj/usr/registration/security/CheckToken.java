package org.gauravj.usr.registration.security;

import static org.gauravj.usr.registration.security.ReqToken.SALTED;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.util.Collection;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Component
public class CheckToken {
    public String getUsername(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(SALTED).parseClaimsJws(trim(token));
        return claims.getBody().getSubject();
    }

    public Collection<GrantedAuthority> getAuthorities(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(SALTED).parseClaimsJws(trim(token));
        String role = claims.getBody().get("role", String.class);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(SALTED).parseClaimsJws(trim(token));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static final String trim(String token){
        if (null != token && token.startsWith("Bearer")) {
            return token.substring(7);
        }
        return "";
    }
}
