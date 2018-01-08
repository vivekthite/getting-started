/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.auth0.request;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Auth0TokenRequest.
 *
 * @author vivekanandt
 */

/**
 * Instantiates a new auth 0 token request.
 */
@Data
public class Auth0TokenRequest {
    
    /** The grant type. */
    private String grant_type;
    
    /** The username. */
    private String username;
    
    /** The password. */
    private String password;
    
    /** The audience. */
    private String audience;
    
    /** The scope. */
    private String scope;
    
    /** The client id. */
    private String client_id;
    
    /** The client secret. */
    private String client_secret;
    
    /** The realm. */
    private String realm;
}
