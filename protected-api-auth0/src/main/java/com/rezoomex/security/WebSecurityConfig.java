/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.security;

import static com.rezoomex.constants.SecurityConstants.ADMIN_URI;
import static com.rezoomex.constants.SecurityConstants.CANDIDATE_URI;
import static com.rezoomex.constants.SecurityConstants.GENERATE_TOKEN_URI;
import static com.rezoomex.constants.SecurityConstants.QUESTION_URI;
import static com.rezoomex.constants.SecurityConstants.RANDOM_QUESTION_URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

/**
 * The Class WebSecurityConfig.
 *
 * @author vivekanandt
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /** The auth 0 issuer. */
    @Value("${auth0.issuer}")
    private String auth0Issuer;

    @Value("${auth0.audience}")
    private String auth0Audience;

    //superadmin scope    
    /** The super admin scope crud admin. */
    @Value("${auth0.superadmin-scope.crud-admin}")
    private String superAdminScopeCrudAdmin;

    //admin scope start

    /** The admin scope crud candidate. */
    @Value("${auth0.admin-scope.crud-candidate}")
    private String adminScopeCrudCandidate;

    /** The admin scope crud question. */
    @Value("${auth0.admin-scope.crud-question}")
    private String adminScopeCrudQuestion;

    //admin scope end

    //candidate scope
    /** The candidate scope read random question. */
    @Value("${auth0.candidate-scope.read-random-question}")
    private String candidateScopeReadRandomQuestion;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
     // @formatter:off
        //auth0 configuration
        JwtWebSecurityConfigurer
            .forRS256(auth0Audience, auth0Issuer)
            .configure(http)
            .cors()
            .and()
            .csrf().disable()
            .authorizeRequests()
            //.antMatchers(HttpMethod.POST, SIGNUP_URI).permitAll()
            .antMatchers(HttpMethod.POST, GENERATE_TOKEN_URI).permitAll()
            .antMatchers(HttpMethod.POST,ADMIN_URI).hasAuthority(superAdminScopeCrudAdmin)
            .antMatchers(HttpMethod.GET,ADMIN_URI).hasAuthority(superAdminScopeCrudAdmin)
            .antMatchers(HttpMethod.PUT,ADMIN_URI).hasAuthority(superAdminScopeCrudAdmin)
            .antMatchers(HttpMethod.DELETE,ADMIN_URI).hasAuthority(superAdminScopeCrudAdmin)
            .antMatchers(HttpMethod.POST,CANDIDATE_URI).hasAuthority(adminScopeCrudCandidate)
            .antMatchers(HttpMethod.GET,CANDIDATE_URI).hasAuthority(adminScopeCrudCandidate)
            .antMatchers(HttpMethod.PUT,CANDIDATE_URI).hasAuthority(adminScopeCrudCandidate)
            .antMatchers(HttpMethod.DELETE,CANDIDATE_URI).hasAuthority(adminScopeCrudCandidate)
            .antMatchers(HttpMethod.POST,QUESTION_URI).hasAuthority(adminScopeCrudQuestion)
            .antMatchers(HttpMethod.GET,QUESTION_URI).hasAuthority(adminScopeCrudQuestion)
            .antMatchers(HttpMethod.PUT,QUESTION_URI).hasAuthority(adminScopeCrudQuestion)
            .antMatchers(HttpMethod.DELETE,QUESTION_URI).hasAuthority(adminScopeCrudQuestion)
            .antMatchers(HttpMethod.GET,RANDOM_QUESTION_URI).hasAuthority(candidateScopeReadRandomQuestion)
            .anyRequest().authenticated()  
            .and()            
            //this disables session creation on spring security
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;   
     // @formatter:on 
        
        /*
        
        // @formatter:off
        //spring security configuration
        http.cors()
            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, SecurityConstants.CANDIDATE_SIGNUP_URI).permitAll()
            .antMatchers(HttpMethod.POST, SecurityConstants.CANDIDATE_LOGIN_URI).permitAll()
            .anyRequest().authenticated()  
            .and()
            //this disables session creation on spring security
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ;            
            
    // @formatter:on
    
    */
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // @formatter:off
        web.ignoring()
            //swagger URIs
            .antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/**",
                    "/swagger-ui.html",
                    "/webjars/**")
            //token uris
            .antMatchers(GENERATE_TOKEN_URI)
            ;

        // @formatter:on


    }
}
