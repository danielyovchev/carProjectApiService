package com.example.core.implementation;

import com.example.core.interfaces.RestTemplateProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RestTemplateProviderImpl implements RestTemplateProvider {
    @Override
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
