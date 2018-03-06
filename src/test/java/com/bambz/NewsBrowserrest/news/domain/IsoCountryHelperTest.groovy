package com.bambz.NewsBrowserrest.news.domain

import spock.lang.Specification

/**
 * Created by bambo on 06.03.2018.
 */
class IsoCountryHelperTest extends Specification {

    def "IsoCountryHelper should provide correct country english name from ISO lang" () {

        given:
            IsoCountryHelper helper = new IsoCountryHelper()

        when: "Client want to get country english name from ISO lang"
            def result = helper.countryFromIsoLang(lang)

        then: "result should be as #expectedResult"
            result == expectedResult

        where:
            lang      || expectedResult
            "pl"      || "Poland"
            "Fr"      || "France"
            "de"      || "Germany"
            "RU"      || "Russia"
            "gb"      || "United Kingdom"
            "uS"      || "United States"
            "gr"      || "Greece"
            "xxx"     ||  null

    }

}
