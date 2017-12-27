/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.authapi.user;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author vivekanandt
 *
 */
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);
}
