/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.springdbsecurityexample.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author vivekanandt
 *
 */
@Getter
@Setter
public class UserNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -9111718923481448580L;
    private String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }


}
