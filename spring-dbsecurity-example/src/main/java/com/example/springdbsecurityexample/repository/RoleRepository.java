/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springdbsecurityexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdbsecurityexample.domain.Role;


/**
 * @author vivekanandt
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
