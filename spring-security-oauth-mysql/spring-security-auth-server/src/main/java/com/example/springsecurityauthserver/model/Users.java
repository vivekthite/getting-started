/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springsecurityauthserver.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author vivekanandt
 *
 */
@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int       userId;

    @Column(name="name")
    private String    name;

    @Column(name="password")
    private String    password;
    
    @Column(name="active")
    private boolean active;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns= {@JoinColumn(name="user_id")},inverseJoinColumns= {@JoinColumn(name="role_id")})
    private Set<Role> roles;
}
