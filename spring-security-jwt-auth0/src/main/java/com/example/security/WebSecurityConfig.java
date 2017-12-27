/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

/**
 * @author vivekanandt
 *
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth0.audience}")
    private String audience;

    @Value("${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // @formatter:off
        
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/hello").permitAll()            
            .antMatchers("/users").authenticated()            
              ;
        
        JwtWebSecurityConfigurer
            .forRS256(audience, issuer)
            .configure(http)
            ;
 
        // @formatter:on

    }


}
