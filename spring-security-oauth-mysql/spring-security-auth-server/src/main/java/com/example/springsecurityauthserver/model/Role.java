/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springsecurityauthserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author vivekanandt
 *
 */
@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="role_id")
    private int roleId;
    
    @Column(name="role")
    private String role;
    
}
