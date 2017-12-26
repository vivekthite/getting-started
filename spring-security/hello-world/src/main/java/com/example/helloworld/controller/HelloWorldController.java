/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.helloworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vivekanandt
 *
 */
@RestController
@RequestMapping("/api/v1/hello")
public class HelloWorldController {


    @GetMapping("/all")
    public String user() {
        return "Hello All " + getPrincipal();
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin " + getPrincipal();
    }

    @GetMapping("/dba")
    public String db() {
        return "Hello DBA " + getPrincipal();
    }

    @GetMapping("/restricted")
    public String accesDenied() {
        return "Acccess Denied";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            return "Logged out successfully";
        } else {
            return "Already logged out";
        }

    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName=principal.toString();
        }
        return userName;
    }
}
