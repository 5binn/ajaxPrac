package com.example.practice01.domain.article.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ArticleRequest {

    @Getter
    @Setter
    public static class create {
        @NotBlank
        private String title;
        @NotBlank
        private String content;
    }
}
