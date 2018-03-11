package com.bambz.NewsBrowser.news.domain

import spock.lang.Specification


/**
 * Created by bambo on 05.03.2018.
 */
class NewsSpec extends Specification {

    NewsFacade newsFacade

    def setup() {
        newsFacade = new NewsConfiguration().newsFacade()
    }

    def "'show' method should return not null news which contains country and category for correct lang and category and correct article" () {

        given: "Client want to get technological news from Poland"
            def lang = "pl"
            def category = "technology"

        when: "Client perform 'getNews' method for above params"
            def newsDto = newsFacade.show(lang, category, searchCritecriaDto)

        then: "Base should have starting values"
            newsDto != null
            newsDto.category == "technology"
            newsDto.country == "Poland"
            newsDto.articles != null
            newsDto.articles.size() == 1
    }

    def "'show' method should return not null news which doesn't contain country and category for incorrect lang and category" () {

        given: "Client want to get technological news from Poland"
            def lang = "xx"
            def category = "badcategory"

        when: "Client perform 'getNews' method for above params"
            def newsDto = newsFacade.show(lang, category, searchCritecriaDto)

        then: "Base should have starting values"
            newsDto != null
            newsDto.category == null
            newsDto.country == null
            newsDto.articles != null
            newsDto.articles.size() == 0
    }
}
