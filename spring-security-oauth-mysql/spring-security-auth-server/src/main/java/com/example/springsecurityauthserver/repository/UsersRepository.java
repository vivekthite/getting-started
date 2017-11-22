/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springsecurityauthserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurityauthserver.model.Users;


/**
 * @author vivekanandt
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByName(String username);
    
}
