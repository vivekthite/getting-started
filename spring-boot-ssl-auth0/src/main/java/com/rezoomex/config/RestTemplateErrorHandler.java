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


    /* (non-Javadoc)
     * @see org.springframework.web.client.ResponseErrorHandler#hasError(org.springframework.http.client.ClientHttpResponse)
     */
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus httpStatus = response.getStatusCode();
        HttpStatus.Series series = httpStatus.series();
        boolean hasError = HttpStatus.Series.CLIENT_ERROR.equals(series) || HttpStatus.Series.SERVER_ERROR.equals(series);
        return hasError;
    }


    /* (non-Javadoc)
     * @see org.springframework.web.client.ResponseErrorHandler#handleError(org.springframework.http.client.ClientHttpResponse)
     */
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {       
        log.error("Response error: {} {}", response.getStatusCode(), response.getStatusText());
    }

}
