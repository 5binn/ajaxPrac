package com.example.practice01.global;


import com.example.practice01.global.request.Rq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final Rq rq;

    @GetMapping("/")
    public String home() {
        if (rq.isLogin()) {
            return "redirect:/article/list";
        } else
            return "redirect:/user/login";
    }

}
