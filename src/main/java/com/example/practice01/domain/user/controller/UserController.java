package com.example.practice01.domain.user.controller;

import com.example.practice01.domain.user.request.UserRequest;
import com.example.practice01.domain.user.service.UserService;
import com.example.practice01.global.request.Rq;
import com.example.practice01.global.rsData.ResultCode;
import com.example.practice01.global.rsData.ResultData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final Rq rq;

    @GetMapping("/create")
    public String create() {
        return "user/create";
    }

    @GetMapping("/login")
    public String login() {
        if (rq.isLogin()) {
            return "redirect:/article/list";
        } else {
            return "user/login";
        }
    }
}
