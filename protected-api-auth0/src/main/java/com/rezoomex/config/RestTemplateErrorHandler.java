/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.config;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import lombok.extern.slf4j.Slf4j;


// TODO: Auto-generated Javadoc
/**
 * The Class RestTemplateErrorHandler.
 *
 * @author vivekanandt
 */

/** The Constant log. */
@Slf4j
public class RestTemplateErrorHandler implements ResponseErrorHandler {
    
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {       
        boolean hasError = HttpStatus.Series.SUCCESSFUL != response.getStatusCode().series();
        return hasError;
    }
    
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {       
        log.error("Response error: {} {}", response.getStatusCode(), response.getStatusText());
    }

}
