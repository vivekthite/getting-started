/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @GetMapping("/greet")
    public String greet() {
        System.out.println("In greet");
        List<String> greetList = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random random = new Random();
        int index = random.nextInt(greetList.size());
        return greetList.get(index);
    }

    @GetMapping("/")
    public String home() {
        System.out.println("In home ... called from ribbon client while pinging ");
        return "Hello";
    }

}
