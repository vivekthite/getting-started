/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springsecurityauthserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurityauthserver.model.Role;


/**
 * @author vivekanandt
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
