/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rezoomex.service.jwt.JwtClaims;
import com.rezoomex.service.jwt.JwtService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class QuestionsController.
 *
 * @author vivekanandt
 */
@RestController
@RequestMapping("/api/v1/questions")
@Slf4j
public class QuestionsController {

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<String> create(@RequestHeader("Authorization") String authorizationHeader) {
        if (log.isDebugEnabled()) {
            log.debug("Authorized");
        }
        JwtClaims jwtClaims = jwtService.extractJwtClaims(authorizationHeader);
        //TODO implement the stuff
        throw new RuntimeException("Implement Me ... ");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestHeader("Authorization") String authorizationHeader) {
        if (log.isDebugEnabled()) {
            log.debug("Authorized");
        }
        JwtClaims jwtClaims = jwtService.extractJwtClaims(authorizationHeader);
        //TODO implement the stuff
        throw new RuntimeException("Implement Me ... ");
    }

    @GetMapping
    public ResponseEntity<String> getAll(@RequestHeader("Authorization") String authorizationHeader) {
        if (log.isDebugEnabled()) {
            log.debug("Authorized");
        }
        JwtClaims jwtClaims = jwtService.extractJwtClaims(authorizationHeader);
        //TODO implement the stuff
        throw new RuntimeException("Implement Me ... ");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestHeader("Authorization") String authorizationHeader) {
        if (log.isDebugEnabled()) {
            log.debug("Authorized for delete:questions");
        }
        JwtClaims jwtClaims = jwtService.extractJwtClaims(authorizationHeader);
        //TODO implement the stuff
        throw new RuntimeException("Implement Me ... ");
    }

    @GetMapping("/random")
    public ResponseEntity<String> getRandomQuestions(@RequestHeader("Authorization") String authorizationHeader) {
        if (log.isDebugEnabled()) {
            log.debug("Authorized");
        }
        JwtClaims jwtClaims = jwtService.extractJwtClaims(authorizationHeader);
        //TODO implement the stuff
        throw new RuntimeException("Implement Me ... ");
    }
}
