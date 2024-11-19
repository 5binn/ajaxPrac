package com.example.practice01.domain.article.controller;

import com.example.practice01.domain.article.dto.ArticleDto;
import com.example.practice01.domain.article.entity.Article;
import com.example.practice01.domain.article.request.ArticleRequest;
import com.example.practice01.domain.article.response.ArticleResponse;
import com.example.practice01.domain.article.service.ArticleService;
import com.example.practice01.global.request.Rq;
import com.example.practice01.global.rsData.ResultCode;
import com.example.practice01.global.rsData.ResultData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    private final Rq rq;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model) {
        if (!rq.isLogin()) {
            return "redirect:/";
        }
        ResultData<List<Article>> resultData = this.articleService.findAll();
        List<ArticleDto> articleList = new ArticleResponse.getListAll(resultData.getData()).getArticleDtoList();
        model.addAttribute("articleList", articleList);
        return "article/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list/{page}")
    public String listReload(@PathVariable(value = "page") int page, Model model) {
        ResultData<Article> resultData = this.articleService.findAll();
        model.addAttribute("articleList", resultData.getData());
        return "article/list::#articleList";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String create(ArticleRequest.create createRq) {
        return "article/create";
    }


}
