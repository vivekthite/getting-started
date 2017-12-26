/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.helloworld.config;

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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                        .antMatchers("/all/**")
                        .permitAll()
                        .antMatchers("/admin/**")
                        .hasAuthority("ADMIN")
                        .antMatchers("/dba/**")
                        .hasAuthority("DBA")
                        .anyRequest()
                        .authenticated()
                        .and()
                        .formLogin()
                        .and()
                        .exceptionHandling()
                        .accessDeniedPage("/api/v1/restricted");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("all").password("all").authorities("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").authorities("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("dba").authorities("DBA");
    }
}
