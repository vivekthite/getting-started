/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rezoomex.auth0.request.Auth0TokenRequest;
import com.rezoomex.constants.RoleConstants;
import com.rezoomex.request.CredentialVo;
import com.rezoomex.service.jwt.JwtClaims;
import com.rezoomex.service.jwt.JwtService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class TokenController.
 *
 * @author vivekanandt
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/tokens")
public class TokenController {

    /** The rest template. */
    private RestTemplate restTemplate;

    /** The auth 0 issuer. */
    @Value("${auth0.issuer}")
    private String       auth0Issuer;

    /** The auth 0 signup url. */
    @Value("${auth0.signup-url}")
    private String       auth0SignupUrl;

    @Value("${auth0.token-url}")
    private String       auth0TokenUrl;

    /** The auth 0 connection. */
    @Value("${auth0.db-connection.superadmin}")
    private String       auth0SuperAdminConnection;

    @Value("${auth0.db-connection.admin}")
    private String       auth0AdminConnection;

    @Value("${auth0.db-connection.candidate}")
    private String       auth0CandiadteConnection;

    /** The auth 0 client id. */
    @Value("${auth0.client-id}")
    private String       auth0ClientId;

    /** The auth 0 client secret. */
    @Value("${auth0.client-secret}")
    private String       auth0ClientSecret;

    /** The auth 0 audience. */
    @Value("${auth0.audience}")
    private String       auth0Audience;

    /** The auth 0 grant type. */
    @Value("${auth0.grant-type}")
    private String       auth0GrantType;

    //superadmin scope    
    /** The super admin scope crud admin. */
    @Value("${auth0.superadmin-scope.crud-admin}")
    private String       superAdminScopeCrudAdmin;

    //admin scope start

    /** The admin scope crud candidate. */
    @Value("${auth0.admin-scope.crud-candidate}")
    private String       adminScopeCrudCandidate;

    /** The admin scope crud question. */
    @Value("${auth0.admin-scope.crud-question}")
    private String       adminScopeCrudQuestion;

    //admin scope end

    //candidate scope
    /** The candidate scope read random question. */
    @Value("${auth0.candidate-scope.read-random-question}")
    private String       candidateScopeReadRandomQuestion;

    @Autowired
    public TokenController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<String> generateToken(@RequestBody CredentialVo credentialVo, @RequestParam("role") String role) {

        //create auth0 token request
        Auth0TokenRequest auth0TokenRequest = new Auth0TokenRequest();
        auth0TokenRequest.setAudience(auth0Audience);
        auth0TokenRequest.setClient_id(auth0ClientId);
        auth0TokenRequest.setClient_secret(auth0ClientSecret);
        auth0TokenRequest.setGrant_type(auth0GrantType);
        auth0TokenRequest.setPassword(credentialVo.getPassword());
        String realm = "realm";
        String scope = "scope";
        if (RoleConstants.SUPERADMIN.equalsIgnoreCase(role)) {
            realm = auth0SuperAdminConnection;
            scope = new StringBuilder(superAdminScopeCrudAdmin)
                            .toString();
        } else if (RoleConstants.ADMIN.equalsIgnoreCase(role)) {
            realm = auth0AdminConnection;
            scope = new StringBuilder(adminScopeCrudCandidate)
                            .append(" ")
                            .append(adminScopeCrudQuestion)
                            .toString();
        } else if (RoleConstants.CANDIDATE.equalsIgnoreCase(role)) {
            realm = auth0CandiadteConnection;
            scope = new StringBuilder(candidateScopeReadRandomQuestion)
                            .toString();
        }
        auth0TokenRequest.setRealm(realm);
        auth0TokenRequest.setScope(scope);
        auth0TokenRequest.setUsername(credentialVo.getEmail());

        HttpEntity<Auth0TokenRequest> entity = new HttpEntity<Auth0TokenRequest>(auth0TokenRequest);
        ResponseEntity<String> response = restTemplate.postForEntity(auth0TokenUrl, entity, String.class);

        log.info("Login token response : " + response);

        return response;
    }

}
