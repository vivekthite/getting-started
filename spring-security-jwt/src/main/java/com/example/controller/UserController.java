/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vivekanandt
 *
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/users")
    public String getUsers() {
        return "Amar,Akbar,Anthony";
    }
}
