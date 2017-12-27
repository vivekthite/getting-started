/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.authapi.security;


/**
 * @author vivekanandt
 *
 */
public interface SecurityConstants {

    String SECRET          = "SecretKeyToGenJWTs";

    long   EXPIRATION_TIME = 864_000_000;          // 10 days

    String TOKEN_PREFIX    = "Bearer ";

    String HEADER_STRING   = "Authorization";

    String SIGN_UP_URL     = "/users/signup";
}
