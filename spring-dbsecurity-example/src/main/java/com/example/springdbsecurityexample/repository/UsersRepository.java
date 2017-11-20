/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springdbsecurityexample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdbsecurityexample.domain.Users;


/**
 * @author vivekanandt
 *
 */
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findAllByEmail(String email);

}
