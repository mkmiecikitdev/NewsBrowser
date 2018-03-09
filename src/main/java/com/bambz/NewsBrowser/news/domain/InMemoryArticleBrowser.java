package com.bambz.NewsBrowser.news.domain;

import com.bambz.NewsBrowser.news.domain.dto.ArticleDto;

import java.util.Collections;
import java.util.List;

/**
 * Created by bambo on 06.03.2018.
 */
class InMemoryArticleBrowser implements ArticleBrowser {

    @Override
    public List<ArticleDto> getArticles(String lang, String category) {
        if(lang.toLowerCase().equals("pl") && category.toLowerCase().equals("technology")) {
            return Collections.singletonList(
                    ArticleDto.builder().build()
            );
        }

        return Collections.emptyList();
    }

}

