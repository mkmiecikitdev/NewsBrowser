package com.bambz.NewsBrowser.news.infrastructure.newsapiorg;

import com.bambz.NewsBrowser.news.domain.ArticleBrowser;
import com.bambz.NewsBrowser.news.domain.dto.ArticleDto;
import com.bambz.NewsBrowser.news.infrastructure.newsapiorg.dto.NAOArticleDto;
import com.bambz.NewsBrowser.news.infrastructure.newsapiorg.dto.NAOResponseDto;
import com.bambz.NewsBrowser.news.infrastructure.newsapiorg.dto.NAOSourceDto;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Created by bambo on 07.03.2018.
 */

@AllArgsConstructor
class NewsApiOrgAdapter implements ArticleBrowser {

    private static final String UNKNOWN = "Unknown";
    private static final String PLACEHOLDER = "https://image.ibb.co/cbDsf7/placeholder4.png";

    private final NewsApiOrgClient client;

    @Override
    public List<ArticleDto> getArticles(String lang, String category) {
        NAOResponseDto response = client.response(lang, category);
        return response.getArticles().stream().map(this::convert).collect(Collectors.toList());
    }

    private ArticleDto convert(NAOArticleDto naoArticleDto) {
        return ArticleDto.builder()
                .author(getValidStr(naoArticleDto.getAuthor()))
                .title(getValidStr(naoArticleDto.getTitle()))
                .description(getValidStr(naoArticleDto.getDescription()))
                .date(getValidDateStr(naoArticleDto.getPublishedAt()))
                .sourceName(getValidSource(naoArticleDto.getSource()))
                .articleUrl(getValidStr(naoArticleDto.getUrl()))
                .imageUrl(getValidImageUrl(naoArticleDto.getUrlToImage()))
                .build();
    }

    private String getValidStr(String validating) {
        if(StringUtils.isEmpty(validating)) {
            return UNKNOWN;
        }

        return validating;
    }

    private String getValidSource(NAOSourceDto naoSourceDto) {
        return ofNullable(naoSourceDto).map(NAOSourceDto::getName).orElse(UNKNOWN);
    }

    private String getValidDateStr(LocalDateTime date) {
        if(date == null) {
            return UNKNOWN;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    private String getValidImageUrl(String imageUrl) {
        return ofNullable(imageUrl).orElse(PLACEHOLDER);
    }


}

