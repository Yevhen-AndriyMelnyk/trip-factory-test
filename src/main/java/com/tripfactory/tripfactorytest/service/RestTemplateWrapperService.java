package com.tripfactory.tripfactorytest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateWrapperService {

    @Autowired
    private RestTemplate restTemplate;

    public String sendSoapRequest(String xml, String url) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.TEXT_XML);
        HttpEntity<String> entity = new HttpEntity<>(xml, header);
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }
}
