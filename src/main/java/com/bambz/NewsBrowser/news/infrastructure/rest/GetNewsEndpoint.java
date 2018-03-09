package com.bambz.NewsBrowser.news.infrastructure.rest;

import com.bambz.NewsBrowser.news.domain.NewsFacade;
import com.bambz.NewsBrowser.news.domain.dto.NewsDto;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bambo on 08.03.2018.
 */

@RestController
@AllArgsConstructor
class GetNewsEndpoint {

    private final NewsFacade newsFacade;

    @GetMapping("/news/{lang}/{category}/")
    NewsDto getNews(@ApiParam("The 2-letter ISO 3166-1 code of the country") @PathVariable String lang, @PathVariable String category) {
        return newsFacade.show(lang, category);
    }

}
