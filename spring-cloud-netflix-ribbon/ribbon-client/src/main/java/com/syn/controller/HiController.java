/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.syn.config.LoadBalancedClientConfig;

/**
 * @author vivekanandt
 *
 */
@RestController
@RequestMapping("/v1/hi")
@RibbonClient(name = "hello-service", configuration = LoadBalancedClientConfig.class)
public class HiController {

    private static final String URL = "http://hello-service/v1/hello/greet";

    @Autowired
    private RestTemplate        restTemplate;

    @GetMapping
    public String hi() {
        return restTemplate.getForObject(URL, String.class);
    }
}
