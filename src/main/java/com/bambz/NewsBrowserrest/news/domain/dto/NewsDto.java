package com.bambz.NewsBrowserrest.news.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

/**
 * Created by bambo on 06.03.2018.
 */

@Builder
@Getter
public class NewsDto {

    @ApiModelProperty("Country for which messages have been read")
    private String country;

    @ApiModelProperty("Category for which messages have been read")
    private String category;

    @ApiModelProperty("Articles for country and category")
    private Collection<ArticleDto> articles;

}
