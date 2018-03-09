package com.bambz.NewsBrowser.news.domain;

import com.bambz.NewsBrowser.news.domain.dto.NewsDto;
import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * Created by bambo on 06.03.2018.
 */

@AllArgsConstructor
public class NewsFacade {

    private final IsoCountryHelper isoCountryHelper;
    private final ArticleBrowser articleBrowser;

    public NewsDto show(String lang, String category) {

        Objects.requireNonNull(lang, "Lang cannot be null");
        Objects.requireNonNull(category, "Category cannot be null");

        return NewsDto.builder()
                .category(Category.getValidName(category))
                .country(isoCountryHelper.countryFromIsoLang(lang))
                .articles(articleBrowser.getArticles(lang, category))
                .build();
    }

}
