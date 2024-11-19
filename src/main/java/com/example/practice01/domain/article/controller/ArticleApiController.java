package com.example.practice01.domain.article.controller;

import com.example.practice01.domain.article.request.ArticleRequest;
import com.example.practice01.domain.article.service.ArticleService;
import com.example.practice01.global.rsData.ResultCode;
import com.example.practice01.global.rsData.ResultData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleApiController {
    private final ArticleService articleService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public ResultData create(@Valid @RequestBody ArticleRequest.create createRq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultData.of(ResultCode.F_06, "검증오류");
        }
        ResultData resultData = this.articleService.create(createRq.getTitle(), createRq.getContent());
        return ResultData.of(resultData.getResultCode(), resultData.getMsg());
    }
}
