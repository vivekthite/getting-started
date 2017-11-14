/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 *
 * @author vivekanandt
 */
@Entity

/**
 * Instantiates a new user.
 */
@Data
public class User {

    /** The id. */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long   id;

    /** The name. */
    private String name;

    /** The password. */
    private String password;

    /** The confirm password. */
    private String confirmPassword;
    
    /** The roles. */
    @ManyToMany    
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
    /** The organization. */
    @ManyToOne(cascade=CascadeType.REMOVE)
    private Organization organization;

    /** The created at. */
    private Date   createdAt;

    /** The updated at. */
    private Date   updatedAt;

    /** The created by. */
    private String createdBy;

    /** The updayed by. */
    private String updayedBy;
}
