/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.controller;


import static com.rezoomex.constants.RoleConstants.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rezoomex.auth0.request.Auth0SignupRequest;
import com.rezoomex.auth0.request.Auth0TokenRequest;
import com.rezoomex.auth0.request.Auth0UserMetadata;
import com.rezoomex.request.AdminVo;
import com.rezoomex.request.CredentialVo;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class AdminController.
 *
 * @author vivekanandt
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {
    
    /** The rest template. */
    private RestTemplate restTemplate;       

    /** The auth 0 issuer. */
    @Value("${auth0.issuer}")
    private String       auth0Issuer;

    /** The auth 0 signup url. */
    @Value("${auth0.signup-url}")
    private String       auth0SignupUrl;
    
    /** The auth 0 client id. */
    @Value("${auth0.client-id}")
    private String       auth0ClientId;

    /** The auth 0 client secret. */
    @Value("${auth0.client-secret}")
    private String       auth0ClientSecret;
    
    @Value("${auth0.db-connection.admin}")
    private String       auth0AdminConnection;
    
    /**
     * Instantiates a new admin controller.
     *
     * @param restTemplate the rest template
     */
    @Autowired
    public AdminController(RestTemplate restTemplate) {        
        this.restTemplate = restTemplate;
    }
   
    @PostMapping
    public ResponseEntity<String> create(@RequestBody AdminVo adminVo,@RequestHeader("Authorization") String authorizationHeader) {        
        if (log.isDebugEnabled()) {
            log.debug("Authorized");
        }
        
        //create auth0 signup json request
        Auth0SignupRequest auth0SignupRequest = new Auth0SignupRequest();
        auth0SignupRequest.setClient_id(auth0ClientId);
        auth0SignupRequest.setConnection(auth0AdminConnection);
        auth0SignupRequest.setEmail(adminVo.getCredentialVo().getEmail());
        auth0SignupRequest.setPassword(adminVo.getCredentialVo().getPassword());
        Auth0UserMetadata auth0UserMetadata = new Auth0UserMetadata();
        auth0UserMetadata.setOrg(adminVo.getOrg()); 
        auth0UserMetadata.setTech("");
        auth0UserMetadata.setRole(ADMIN);
        auth0SignupRequest.setUser_metadata(auth0UserMetadata);        
        HttpEntity<Auth0SignupRequest> entity = new HttpEntity<Auth0SignupRequest>(auth0SignupRequest);        
        ResponseEntity<String> response = restTemplate.postForEntity(auth0SignupUrl, entity, String.class); 
        
        log.info("Sign up response : "+response);
        
        return response;
    }   
    
    @GetMapping
    public ResponseEntity<String> getAll(@RequestHeader("Authorization") String authorizationHeader){
        //TODO implement the stuff
        throw new RuntimeException("Implement Me ... ");
    }
    
    @PutMapping
    public ResponseEntity<String> update(@RequestHeader("Authorization") String authorizationHeader){
        //TODO implement the stuff
        throw new RuntimeException("Implement Me ... ");
    }
    
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestHeader("Authorization") String authorizationHeader){
        //TODO implement the stuff
        throw new RuntimeException("Implement Me ... ");
    }

}
