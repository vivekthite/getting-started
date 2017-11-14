/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springsecurityexample.config;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * @author vivekanandt
 *
 */
public class CustomFilter implements Filter {

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        System.out.println("destroy::called");

    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter::called");
        HttpServletRequest httpServletRequest = (HttpServletRequest)arg0;
        Principal principal = httpServletRequest.getUserPrincipal();
        System.out.println(principal);

    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("init::called");

    }

}
