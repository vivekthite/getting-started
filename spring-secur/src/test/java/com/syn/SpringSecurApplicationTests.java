/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringSecurApplication.class})
public class SpringSecurApplicationTests {

    @Autowired
    private SampleService sampleService;

    private Authentication authentication;

    @Before
    public void init() {
        this.authentication =
                        new UsernamePasswordAuthenticationToken("user", "pass", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }

    @After
    public void close() {
        SecurityContextHolder.clearContext();
    }

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void testSecure() {
        assertThat("Secure").isEqualTo(sampleService.secure());
	}

    @Test
    public void authenticated() {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        assertThat("Secure").isEqualTo(sampleService.secure());

    }

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void authorize() {
        assertThat("authorize").isEqualTo(sampleService.authorize());
    }

    @Test
    public void authorize1() {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        assertThat("authorize").isEqualTo(sampleService.authorize());
    }

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void deny() {
        assertThat("deny").isEqualTo(sampleService.deny());
    }

    @Test(expected = AccessDeniedException.class)
    public void deny1() {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        assertThat("deny").isEqualTo(sampleService.deny());
    }
}
