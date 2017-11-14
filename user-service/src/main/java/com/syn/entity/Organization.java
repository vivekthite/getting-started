/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Organization.
 *
 * @author vivekanandt
 */
@Entity

/**
 * Instantiates a new organization.
 */
@Data
public class Organization {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    /** The name. */    
    private String name;
    
    /** The users. */
    @OneToMany(mappedBy="organization")
    private Set<User> users;
    
    /** The created at. */
    private Date createdAt;
    
    /** The updated at. */
    private Date updatedAt;
    
    /** The created by. */
    private String createdBy;
    
    /** The updayed by. */
    private String updayedBy;
}
