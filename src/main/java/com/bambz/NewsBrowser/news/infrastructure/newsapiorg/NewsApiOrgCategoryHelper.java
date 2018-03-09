package com.bambz.NewsBrowser.news.infrastructure.newsapiorg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bambo on 09.03.2018.
 */
class NewsApiOrgCategoryHelper {

    private static final Set<String> ACCEPTABLE_CATEGORIES = new HashSet<>(
            Arrays.asList("business", "entertainment", "general", "health", "science", "sports", "technology")
    );

    String getCategoryIfAccetable(String category) {
        return ACCEPTABLE_CATEGORIES.contains(category) ? category : null;
    }

}
