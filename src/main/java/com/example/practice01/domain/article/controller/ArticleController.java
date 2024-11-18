package com.example.practice01.domain.article.controller;

import com.example.practice01.domain.article.entity.Article;
import com.example.practice01.domain.article.service.ArticleService;
import com.example.practice01.global.rsData.ResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public  String list(Model model) {
        ResultData<Article> resultData = this.articleService.findAll();
        model.addAttribute("articleList", resultData.getData());
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
    @PostMapping("/create")
    public String create() {
        return "redirect:/";
    }
}
