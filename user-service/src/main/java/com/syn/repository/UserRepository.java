/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syn.entity.User;


/**
 * The Interface UserRepository.
 *
 * @author vivekanandt
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
