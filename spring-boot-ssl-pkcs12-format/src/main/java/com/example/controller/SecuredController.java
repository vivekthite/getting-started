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
@RequestMapping("/api/v1/secured")
public class SecuredController {

    @GetMapping
    public String secured() {
        return "I am secured over https.";
    }

}
