package com.bambz.NewsBrowser.news.domain.dto;

import lombok.Builder;
import lombok.Getter;



/**
 * Created by bambo on 06.03.2018.
 */

@Builder
@Getter
public class ArticleDto {
    private String author;
    private String title;
    private String description;
    private String date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;
}
