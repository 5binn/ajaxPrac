package com.example.practice01.domain.article.dto;

import com.example.practice01.domain.article.entity.Article;
import com.example.practice01.domain.user.entity.SiteUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createDate;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime modifyDate;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.author = article.getAuthor().getUsername();
        this.createDate = article.getCreateDate();
        this.modifyDate = article.getModifiedDate();
    }
}
