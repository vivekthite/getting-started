/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springsecurityauthserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurityauthserver.model.CustomUserDetails;
import com.example.springsecurityauthserver.model.Users;
import com.example.springsecurityauthserver.repository.UsersRepository;

/**
 * @author vivekanandt
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return new CustomUserDetails(users);
    }

}
