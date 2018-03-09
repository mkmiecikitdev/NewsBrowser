package com.bambz.NewsBrowser.news.domain;

import com.bambz.NewsBrowser.news.domain.dto.NewsDto;


/**
 * Created by bambo on 06.03.2018.
 */
public interface NewsBrowser {

    NewsDto getNews(String lang, String category);

}
