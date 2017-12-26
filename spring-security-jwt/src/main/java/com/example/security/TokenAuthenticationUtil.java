/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.security;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author vivekanandt
 *
 */
@Service
public class TokenAuthenticationUtil {

    private static final long   EXPIRATION_TIME = 864_000_000;         // 10 days

    private static final String SECRET          = "ThisIsASecret";

    private static final String TOKEN_PREFIX    = "Bearer ";

    private static final String HEADER          = "Authorization";


    public static void addAuthentication(HttpServletResponse res, String username) {
        String jwt = Jwts.builder()
                        .setSubject(username)
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                        .signWith(SignatureAlgorithm.HS512, SECRET)
                        .compact();
        res.addHeader(HEADER, TOKEN_PREFIX + jwt);
    }


    public static Authentication getAuthentication(HttpServletRequest req) {
        Authentication authentication = null;
        String token = req.getHeader(HEADER);
        if (token != null) {
            String user = Jwts.parser()
                              .setSigningKey(SECRET)
                              .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                            .getBody()
                            .getSubject();
            if (user != null) {
                authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }

        return authentication;
    }

}
