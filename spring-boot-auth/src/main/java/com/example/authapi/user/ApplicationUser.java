/**
 * 
 */
package com.example.authapi.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationUser.
 *
 * @author vivekanandt
 */
@Entity

/**
 * Instantiates a new application user.
 */
@Data
public class ApplicationUser {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    /** The username. */
    private String username;
    
    /** The password. */
    private String password;
}
