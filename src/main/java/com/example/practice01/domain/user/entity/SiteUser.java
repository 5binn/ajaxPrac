package com.example.practice01.domain.user.entity;

import com.example.practice01.domain.article.entity.Article;
import com.example.practice01.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SiteUser extends BaseEntity {
    private String username;
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Article> articleList;
}
