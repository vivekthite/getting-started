/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


/**
 * The Class WebSecurityConfig.
 *
 * @author vivekanandt
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
     // @formatter:off
        
        http.cors()
            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, SecurityConstants.M1_URI).permitAll()            
            .anyRequest().authenticated()  
            .and()
            //this disables session creation on spring security
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ;            
            
    // @formatter:on
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/**",
                        "/swagger-ui.html",
                        "/webjars/**");

    }
}
