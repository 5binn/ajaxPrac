package com.example.practice01.domain.article.response;

import com.example.practice01.domain.article.dto.ArticleDto;
import com.example.practice01.domain.article.entity.Article;
import lombok.Getter;

import java.util.List;

public class ArticleResponse {

    @Getter
    public static class getListAll {
        private List<ArticleDto> articleDtoList;

        public getListAll(List<Article> articleList) {
            this.articleDtoList = (articleList == null) ? null : articleList.stream().map(ArticleDto::new).toList();
        }

    }


}
