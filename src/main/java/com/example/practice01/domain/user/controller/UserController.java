package com.example.practice01.domain.user.controller;

import com.example.practice01.domain.user.request.UserRequest;
import com.example.practice01.domain.user.service.UserService;
import com.example.practice01.global.rsData.ResultCode;
import com.example.practice01.global.rsData.ResultData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/create")
    public String create() {
        return "user/create";
    }

    @PostMapping("/create")
    public ResultData create(@Valid @RequestBody UserRequest.create createRq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultData.of(ResultCode.F_06, "검증오류");
        }
        ResultData resultData = this.userService.create(createRq.getUsername(), createRq.getPassword());
        return ResultData.of(resultData.getResultCode(), resultData.getMsg());
    }
}
