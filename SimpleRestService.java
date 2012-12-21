package com.jeffsheets.rest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class SimpleRestService {
    @Autowired
    private RestTemplate restTemplate;

    public String getMessage() {
        String result;
        try {
            String httpResult = restTemplate.getForObject("http://google.com", String.class);
            result = "TMS Message SUCCESS result: " + httpResult;
        } catch (HttpStatusCodeException e) {
            result = "Get FAILED with HttpStatusCode: " + e.getStatusCode() + "|" + e.getStatusText();
        } catch (RuntimeException e) {
            result = "Get FAILED\n" + ExceptionUtils.getFullStackTrace(e);
        }
        return result;
    }
}
