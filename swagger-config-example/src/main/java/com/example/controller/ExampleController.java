/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vivekanandt
 *
 */
@RestController
@RequestMapping("/v1/examples")
public class ExampleController {

    @GetMapping("/m1")
    public String m1() {
        return "This is example of spring boot swagger config";
    }
}
