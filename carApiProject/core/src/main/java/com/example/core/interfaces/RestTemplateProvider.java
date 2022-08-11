package com.example.core.interfaces;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateProvider {
    RestTemplate getRestTemplate();
}
