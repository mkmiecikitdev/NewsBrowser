package com.bambz.NewsBrowser.news.infrastructure.newsapiorg;

import com.bambz.NewsBrowser.news.domain.NewsBrowser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bambo on 08.03.2018.
 */

@Configuration
class NewsApiOrgConfiguration {

    @Value("${NAO.url}")
    private String url;

    @Value("${NAO.appId.key}")
    private String appIdKey;

    @Value("${NAO.appId.value}")
    private String appIdValue;

    @Bean
    NewsBrowser articleBrowser(ObjectMapper objectMapper) {
        return new NewsApiOrgAdapter(newsApiOrgClient(objectMapper), newsApiOrgCategoryHelper(), newsApiOrgLangHelper());
    }


    private NewsApiOrgClient newsApiOrgClient(ObjectMapper objectMapper) {
        return new NewsApiOrgClient(restTemplate(objectMapper), url, httpHeaders());
    }

    private RestTemplate restTemplate(ObjectMapper objectMapper) {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(objectMapper);
        converters.add(jsonConverter);
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }

    private HttpHeaders httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(appIdKey, appIdValue);
        return headers;
    }

    private NewsApiOrgCategoryHelper newsApiOrgCategoryHelper() {
        return new NewsApiOrgCategoryHelper();
    }

    private NewsApiOrgLangHelper newsApiOrgLangHelper() {
        return new NewsApiOrgLangHelper();
    }

}
