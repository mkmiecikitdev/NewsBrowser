package com.bambz.NewsBrowserrest.news.domain

import spock.lang.Specification


/**
 * Created by bambo on 05.03.2018.
 */
class NewsSpec extends Specification {

    NewsFacade newsFacade

    def setup() {
        newsFacade = new NewsConfig().newsFacade()
    }

    def "'show' method should return not null news containing not null articles list " () {

        given: "Client want to get technological news from Poland"
            def lang = "pl"
            def category = "technology"

        when: "Client perform 'show' method for above params"
            def newsDto = newsFacade.show(lang, category)

        then: "Base should have starting values"
            newsDto != null
            newDto.articles != null

    }



}
