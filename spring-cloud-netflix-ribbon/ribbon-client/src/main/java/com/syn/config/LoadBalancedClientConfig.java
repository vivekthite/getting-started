/*
 * All Rights Reserved. Synerzip 2017
 */
package com.syn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

/**
 * @author vivekanandt
 *
 */
//@Configuration
public class LoadBalancedClientConfig {

    @Autowired
    private IClientConfig ribbonClientConfig;

    @Bean
    public IPing iPing(IClientConfig config) {
        return new PingUrl(false, "/v1/hello/");
    }

    @Bean
    public IRule iRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }

}
