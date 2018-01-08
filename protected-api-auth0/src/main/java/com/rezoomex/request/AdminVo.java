/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.request;

import lombok.Data;

/**
 * The Class AdminVo.
 *
 * @author vivekanandt
 */

/**
 * Instantiates a new admin vo.
 */
@Data
public class AdminVo {

    /** The credential vo. */
    private CredentialVo credentialVo;

    /** The org. */
    private String       org;
}
