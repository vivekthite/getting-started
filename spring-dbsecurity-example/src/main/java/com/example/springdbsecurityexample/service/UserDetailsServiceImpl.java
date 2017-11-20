/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springdbsecurityexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springdbsecurityexample.domain.CustomUserDetails;
import com.example.springdbsecurityexample.domain.Users;
import com.example.springdbsecurityexample.repository.UsersRepository;


/**
 * @author vivekanandt
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = usersRepository.findAllByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
        return new CustomUserDetails(users);
    }

}
