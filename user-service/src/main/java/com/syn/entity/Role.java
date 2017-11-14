/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Role.
 *
 * @author vivekanandt
 */
@Entity
@Data
public class Role {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long      id;

    /** The name. */
    private String    name;

    /** The users. */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
