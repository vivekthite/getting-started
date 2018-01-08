/**
 * 
 */
package com.rezoomex.service.jwt;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtClaims.
 *
 * @author vivekanandt
 */

/**
 * Instantiates a new jwt claims.
 */
@Data
public class JwtClaims {

/** The org. */
private String org;

/** The tech. */
private String tech;

/** The email. */
private String email;

/** The role. */
private String role;
}
