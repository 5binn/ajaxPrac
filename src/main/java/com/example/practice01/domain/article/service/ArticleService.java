package com.example.practice01.domain.article.service;

import com.example.practice01.domain.article.entity.Article;
import com.example.practice01.domain.article.repository.ArticleRepository;
import com.example.practice01.global.request.Rq;
import com.example.practice01.global.rsData.ResultCode;
import com.example.practice01.global.rsData.ResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final Rq rq;

    public ResultData<Article> findAll() {
        List<Article> articleList = articleRepository.findAll();
        if (articleList.isEmpty()) {
            return ResultData.of(ResultCode.F_04,"해당 데이터가 존재하지 않습니다.");
        }
        return ResultData.of(ResultCode.S_01,"불러오기 성공");
    }

    public ResultData<Article> create(String title, String content) {
            Article article = Article.builder()
                    .title(title)
                    .content(content)
                    .author(rq.getSiteUser())
                    .build();
            articleRepository.save(article);
            return ResultData.of(ResultCode.S_02, "게시글 등록 완료");
    }
}
