/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syn.entity.Role;


/**
 * The Interface RoleRepository.
 *
 * @author vivekanandt
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
