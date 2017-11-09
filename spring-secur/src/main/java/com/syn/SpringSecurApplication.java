/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurApplication implements CommandLineRunner {

    @Autowired
    private SampleService sampleService;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        return new InMemoryUserDetailsManager(Arrays.asList(User.withUsername("user")
                        .password("pass")
                        .roles("USER")
                        .build()));
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurApplication.class, args);
	}

    @Override
    public void run(String... arg0) throws Exception {
        /*SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken("user", "pass", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));
        */
        /*System.out.println(sampleService.secure());
        System.out.println(sampleService.authorize());
        System.out.println(sampleService.deny());*/
    }
}
