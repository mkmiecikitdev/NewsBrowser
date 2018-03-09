package com.bambz.NewsBrowser.news.domain;

/**
 * Created by bambo on 06.03.2018.
 */
enum Category {

    BUSINESS,
    ENTERTAINMENT,
    GENERAL,
    HEALTH,
    SCIENCE,
    SPORTS,
    TECHNOLOGY;

    static String getValidName(String str) {
        try {
            return Category.valueOf(str.toUpperCase()).name().toLowerCase();
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

}

