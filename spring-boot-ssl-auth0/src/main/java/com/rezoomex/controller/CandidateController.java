/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rezoomex.auth0.request.Auth0SignupRequest;
import com.rezoomex.auth0.request.Auth0UserMetadata;
import com.rezoomex.entity.User;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class CandidateController.
 *
 * @author vivekanandt
 */

/** The Constant log. */
@Slf4j
@RestController
@RequestMapping("/v1/candidates")                
public class CandidateController {
    
    /** The rest template. */
    private RestTemplate restTemplate;       

    /** The auth 0 issuer. */
    @Value("${auth0.issuer}")
    private String       auth0Issuer;

    /** The auth 0 signup url. */
    @Value("${auth0.signup.url}")
    private String       auth0SignupUrl;
    
    /** The auth 0 connection. */
    @Value("${auth0.candidate.connection}")
    private String auth0Connection;
    
    /** The auth 0 client id. */
    @Value("${auth0.candidate.clientid}")
    private String auth0ClientId;

    /**
     * Instantiates a new candidate controller.
     *
     * @param restTemplate the rest template
     */
    @Autowired
    public CandidateController(RestTemplate restTemplate) {        
        this.restTemplate = restTemplate;
    }

    /**
     * Signup.
     *
     * @param user the user
     * @return the response entity
     */
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {        
        if(log.isDebugEnabled()) {
            log.debug("auth0Issuer : "+auth0Issuer+"  signupUrl : "+auth0SignupUrl);
        }
        
        //create auth0 signup json request
        Auth0SignupRequest auth0SignupRequest = new Auth0SignupRequest();
        auth0SignupRequest.setClient_id(auth0ClientId);
        auth0SignupRequest.setConnection(auth0Connection);
        auth0SignupRequest.setEmail(user.getEmail());
        auth0SignupRequest.setPassword(user.getPassword());
        Auth0UserMetadata auth0UserMetadata = new Auth0UserMetadata();
        auth0UserMetadata.setOrg(user.getOrg());
        auth0UserMetadata.setTech(user.getTech());
        auth0SignupRequest.setUser_metadata(auth0UserMetadata);        
        
        
        HttpEntity<Auth0SignupRequest> entity = new HttpEntity<Auth0SignupRequest>(auth0SignupRequest);        
        ResponseEntity<String> response = restTemplate.postForEntity(auth0SignupUrl, entity, String.class); 
        
        log.info("Sign up response : "+response);
        
        return response;
    }

}
