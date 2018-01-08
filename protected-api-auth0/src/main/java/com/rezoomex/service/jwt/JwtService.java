/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.service.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;

// TODO: Auto-generated Javadoc
/**
 * The Interface JwtService.
 *
 * @author vivekanandt
 */
public interface JwtService {

    /**
     * Verify jwt.
     *
     * @param authorizationHeader the authorization header
     * @return the decoded JWT
     */
    DecodedJWT verifyJwt(String authorizationHeader);

    /**
     * Extract jwt claims.
     *
     * @param authorizationHeader the authorization header
     * @return the jwt claims
     */
    JwtClaims extractJwtClaims(String authorizationHeader);
}
