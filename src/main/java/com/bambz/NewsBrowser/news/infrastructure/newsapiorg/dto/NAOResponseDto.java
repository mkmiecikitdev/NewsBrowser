package com.bambz.NewsBrowser.news.infrastructure.newsapiorg.dto;

import lombok.Getter;

import java.util.List;

/**
 * Created by bambo on 06.03.2018.
 */

@Getter
public class NAOResponseDto {

    private String status;
    private Integer totalResults;
    private List<NAOArticleDto> articles;

}
