package com.bambz.NewsBrowser.news.infrastructure.newsapiorg;

import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 * Created by bambo on 06.03.2018.
 */
class NewsApiOrgLangHelper {

    String countryFromIsoLang(String lang) {
        Locale l = new Locale("", lang);
        String country = l.getDisplayCountry(Locale.ENGLISH);

        if(isNotValidCountry(lang, country)) return null;
        return country;
    }

    private boolean isNotValidCountry(String lang, String country) {
        return StringUtils.isEmpty(country) || country.toLowerCase().equals(lang);
    }

}
