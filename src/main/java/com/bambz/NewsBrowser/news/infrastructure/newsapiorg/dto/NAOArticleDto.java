package com.bambz.NewsBrowser.news.infrastructure.newsapiorg.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by bambo on 07.03.2018.
 */

@Getter
public class NAOArticleDto {

    private NAOSourceDto source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime publishedAt;

}

