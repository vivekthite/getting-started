/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springsecurityexample.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author vivekanandt
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                        .inMemoryAuthentication()
                        .withUser("abc")
                        .password("abc")
                        .roles("user")
                        .and()
                        .withUser("xyz")
                        .password("xyz")
                        .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                        .authorizeRequests()
                        .anyRequest()
                        .fullyAuthenticated()
                        .and()
                        //.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
                        .httpBasic();
        http.csrf().disable();
    }

    @Bean
    public Filter customFilter() {
        return new CustomFilter();
    }
}
