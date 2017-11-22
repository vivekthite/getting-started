/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springsecurityauthserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vivekanandt
 *
 */
@RestController
@RequestMapping("/v1/hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello";
    }
}
