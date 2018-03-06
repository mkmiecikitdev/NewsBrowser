package com.bambz.NewsBrowserrest.news.domain;

import com.bambz.NewsBrowserrest.news.domain.dto.NewsDto;
import lombok.AllArgsConstructor;

import java.util.Collections;

/**
 * Created by bambo on 06.03.2018.
 */

@AllArgsConstructor
public class NewsFacade {

    private IsoCountryHelper isoCountryHelper;

    public NewsDto show(String lang, String category) {

        return NewsDto.builder()
                .category(Category.getLabelFromStr(category))
                .country(isoCountryHelper.countryFromIsoLang(lang))
                .articles(Collections.emptyList())
                .build();
    }



}
