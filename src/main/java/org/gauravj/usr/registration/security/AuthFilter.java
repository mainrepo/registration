package org.gauravj.usr.registration.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {
    private final CheckToken checkToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.info("doFilterInternal::authenticate:attempt");
        String token = request.getHeader("Authorization");
        token = ((null == token) || "".equals(token)) ? request.getHeader("authorization") : token;
        if (null != token && token.startsWith("Bearer")) {
            String username = checkToken.getUsername(token);
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, checkToken.getAuthorities(token));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("doFilterInternal::authenticate:success");
        }
        chain.doFilter(request, response);
    }
}
