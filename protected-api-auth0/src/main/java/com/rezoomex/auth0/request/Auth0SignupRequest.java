/**
 * 
 */
package com.rezoomex.auth0.request;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class SignupRequest.
 *
 * @author vivekanandt
 */

/**
 * Instantiates a new signup request.
 * auth0 standard signup request.
 */
@Data
public class Auth0SignupRequest {

/** The client id. */
private String client_id;

/** The email. */
private String email;

/** The password. */
private String password;

/** The connection. */
private String connection;

/** The user metadata. */
private Auth0UserMetadata user_metadata;
}
