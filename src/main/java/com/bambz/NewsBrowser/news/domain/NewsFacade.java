package com.bambz.NewsBrowser.news.domain;

import com.bambz.NewsBrowser.news.domain.dto.NewsDto;
import com.bambz.NewsBrowser.news.domain.dto.SearchCriteriaDto;
import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * Created by bambo on 06.03.2018.
 */

@AllArgsConstructor
public class NewsFacade {

    private final NewsBrowser newsBrowser;

    public NewsDto show(String lang, String category, SearchCriteriaDto searchCriteriaDto) {

        Objects.requireNonNull(lang, "Lang cannot be null");
        Objects.requireNonNull(category, "Category cannot be null");
        Objects.requireNonNull(searchCriteriaDto, "Search criteria cannot be null");

        return newsBrowser.getNews(lang, category, searchCriteriaDto);
    }

}
