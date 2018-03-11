package com.bambz.NewsBrowser.news.infrastructure.newsapiorg;


import com.bambz.NewsBrowser.news.domain.dto.SearchCriteriaDto;
import com.bambz.NewsBrowser.news.infrastructure.newsapiorg.dto.NAOResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
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


    NAOResponseDto response(String lang, String category, SearchCriteriaDto searchCriteriaDto) {

        UriComponentsBuilder builder = getBuilder(lang, category, searchCriteriaDto);

        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        URI uri = builder.build().encode().toUri();
        HttpEntity<NAOResponseDto> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                NAOResponseDto.class);

        return response.getBody();
    }

    private UriComponentsBuilder getBuilder(String lang, String category, SearchCriteriaDto searchCriteriaDto) {
        String COUNTRY_PARAM_KEY = "country";
        String CATEGORY_PARAM_KEY = "category";
        String SEARCH_PARAM_KEY = "q";
        String PAGE_PARAM_NAME = "page";
        String PAGE_SIZE_PARAM_NAME = "pageSize";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam(COUNTRY_PARAM_KEY, lang)
                .queryParam(CATEGORY_PARAM_KEY, category)
                .queryParam(PAGE_PARAM_NAME, searchCriteriaDto.getPage())
                .queryParam(PAGE_SIZE_PARAM_NAME, searchCriteriaDto.getPageSize());

        if(!StringUtils.isEmpty(searchCriteriaDto.getQ())) {
            builder.queryParam(SEARCH_PARAM_KEY, searchCriteriaDto.getQ());
        }

        return builder;
    }

}
