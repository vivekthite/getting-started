/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syn.entity.Organization;


/**
 * The Interface OrganizationRepository.
 *
 * @author vivekanandt
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
