/**
 * 
 */
package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Task.
 *
 * @author vivekanandt
 */
@Entity

/**
 * Instantiates a new task.
 */
@Data
public class Task {

    /** The id. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    /** The description. */
    private String description;
}
