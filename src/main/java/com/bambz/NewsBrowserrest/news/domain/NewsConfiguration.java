package com.bambz.NewsBrowserrest.news.domain;

/**
 * Created by bambo on 06.03.2018.
 */
class NewsConfiguration {

    NewsFacade newsFacade() {
        return new NewsFacade(new IsoCountryHelper());
    }

}
