/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author vivekanandt
 *
 */
@Service
public class SampleService {

    @Secured("ROLE_USER")
    public String secure() {
        return "Secure";
    }

    @PreAuthorize("true")
    public String authorize() {
        return "authorize";
    }

    @PreAuthorize("false")
    public String deny() {
        return "deny";
    }
}
