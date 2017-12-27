/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.authapi.user;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author vivekanandt
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private ApplicationUserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(ApplicationUserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(username, user.getPassword(), Collections.emptyList());
    }

}
