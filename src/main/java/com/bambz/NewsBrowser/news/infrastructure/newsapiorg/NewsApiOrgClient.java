package com.bambz.NewsBrowser.news.infrastructure.newsapiorg;


import com.bambz.NewsBrowser.news.infrastructure.newsapiorg.dto.NAOResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by bambo on 06.03.2018.
 */

@AllArgsConstructor
class NewsApiOrgClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final HttpHeaders httpHeaders;


    NAOResponseDto response(String lang, String category) {

        UriComponentsBuilder builder = getBuilder(lang, category);

        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        URI uri = builder.build().encode().toUri();
        System.err.println(uri);

        HttpEntity<NAOResponseDto> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                NAOResponseDto.class);

        return response.getBody();
    }

    private UriComponentsBuilder getBuilder(String lang, String category) {
        String COUNTRY_PARAM_KEY = "country";
        String CATEGORY_PARAM_KEY = "category";

        return UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam(COUNTRY_PARAM_KEY, lang)
                .queryParam(CATEGORY_PARAM_KEY, category);
    }

}
