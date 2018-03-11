package com.bambz.NewsBrowser.news.domain.dto;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * Created by bambo on 11.03.2018.
 */
@Data
public class SearchCriteriaDto {

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 20;

    @ApiParam("Keywords or a phrase to search for")
    private String q;

    @ApiParam("Use this to page through the results if the total results found is greater than the page size")
    private Integer page = DEFAULT_PAGE;

    @ApiParam("The number of results to return per page (request). 20 is the default, 100 is the maximum")
    private Integer pageSize = DEFAULT_PAGE_SIZE;

}
