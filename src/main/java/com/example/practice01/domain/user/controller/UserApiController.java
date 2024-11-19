package com.example.practice01.domain.user.controller;

import com.example.practice01.domain.user.request.UserRequest;
import com.example.practice01.domain.user.service.UserService;
import com.example.practice01.global.rsData.ResultCode;
import com.example.practice01.global.rsData.ResultData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/create")
    public ResultData create(@Valid @RequestBody UserRequest.create createRq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultData.of(ResultCode.F_06, "검증오류");
        }
        ResultData resultData = this.userService.create(createRq.getUsername(), createRq.getPassword());
        return ResultData.of(resultData.getResultCode(), resultData.getMsg());
    }
}
