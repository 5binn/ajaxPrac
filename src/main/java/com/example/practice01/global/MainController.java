package com.example.practice01.global;


import com.example.practice01.global.request.Rq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final Rq rq;

    @GetMapping("/")
    public String main() {
        if (rq.isLogin()) {
            return "redirect:/article/list";
        } else
            return "redirect:/user/login";

    }

}
