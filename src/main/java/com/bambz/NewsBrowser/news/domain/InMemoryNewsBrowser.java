package com.bambz.NewsBrowser.news.domain;

import com.bambz.NewsBrowser.news.domain.dto.ArticleDto;
import com.bambz.NewsBrowser.news.domain.dto.NewsDto;
import com.bambz.NewsBrowser.news.domain.dto.SearchCriteriaDto;

import java.util.Collections;
import java.util.List;

/**
 * Created by bambo on 06.03.2018.
 */
class InMemoryNewsBrowser implements NewsBrowser {

    @Override
    public NewsDto getNews(String lang, String category, SearchCriteriaDto searchCriteriaDto) {
        List<ArticleDto> articles = Collections.emptyList();
        String country = null;
        String cat = null;

        if(lang.toLowerCase().equals("pl") && category.toLowerCase().equals("technology")) {
            articles = Collections.singletonList(
                    ArticleDto.builder().build()
            );

            country = "Poland";
            cat = "technology";
        }

        return NewsDto.builder()
                .articles(articles)
                .category(cat)
                .country(country)
                .build();
    }

}

