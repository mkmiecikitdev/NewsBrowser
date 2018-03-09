package com.bambz.NewsBrowser.news.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bambo on 06.03.2018.
 */

@Configuration
class NewsConfiguration {

    @Bean
    NewsFacade newsFacade(NewsBrowser newsBrowser) {
        return new NewsFacade(newsBrowser);
    }

    NewsFacade newsFacade() {
        NewsBrowser newsBrowser = new InMemoryNewsBrowser();
        return new NewsFacade(newsBrowser);
    }


}
