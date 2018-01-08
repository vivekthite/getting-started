/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.service.jwt;

import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rezoomex.constants.SecurityConstants;


// TODO: Auto-generated Javadoc
/**
 * The Class JwtServiceImpl.
 *
 * @author vivekanandt
 */
@Service
public class JwtServiceImpl implements JwtService {

    /** The auth 0 issuer. */
    @Value("${auth0.issuer}")
    private String auth0Issuer;

    /** The auth 0 audience. */
    @Value("${auth0.audience}")
    private String auth0Audience;

    /** The email custom key. */
    @Value("${auth0.custom-claim-key.email}")
    private String emailCustomKey;

    /** The org custom key. */
    @Value("${auth0.custom-claim-key.org}")
    private String orgCustomKey;

    /** The tech custom key. */
    @Value("${auth0.custom-claim-key.tech}")
    private String techCustomKey;

    /** The role custom key. */
    @Value("${auth0.custom-claim-key.role}")
    private String roleCustomKey;


    @Override
    public DecodedJWT verifyJwt(String authorizationHeader) {

        //check if authorization header is not null
        if (authorizationHeader == null || !authorizationHeader.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            throw new RuntimeException("Authorization header not found");
        }
        String token = authorizationHeader.replace(SecurityConstants.TOKEN_PREFIX, "");

        //verify the jwt with auth0 provided public key
        JwkProvider provider = new JwkProviderBuilder(auth0Issuer)
                        .build();
        String kid = JWT.decode(token).getHeaderClaim("kid").asString();
        Jwk jwk;
        try {
            jwk = provider.get(kid);
            JWTVerifier verifier = JWT.require(Algorithm.RSA256((RSAPublicKey)jwk.getPublicKey(), null))
                            .withIssuer(auth0Issuer)
                            .withAudience(auth0Audience)
                            .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt;
        } catch (JwkException ex) {
            throw new RuntimeException(ex);
        }

    }


    @Override
    public JwtClaims extractJwtClaims(String authorizationHeader) {
        DecodedJWT jwt = verifyJwt(authorizationHeader);
        Map<String, Claim> claims = jwt.getClaims();
        String email = claims.get(emailCustomKey).asString();
        String org = claims.get(orgCustomKey).asString();
        String tech = claims.get(techCustomKey).asString();
        String role = claims.get(roleCustomKey).asString();
        JwtClaims jwtClaims = new JwtClaims();
        jwtClaims.setEmail(email);
        jwtClaims.setOrg(org);
        jwtClaims.setRole(role);
        jwtClaims.setTech(tech);
        return jwtClaims;
    }

}
