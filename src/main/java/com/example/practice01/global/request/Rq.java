package com.example.practice01.global.request;

import com.example.practice01.domain.user.entity.SiteUser;
import com.example.practice01.domain.user.service.UserService;
import com.example.practice01.global.rsData.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class Rq {
    private final UserService userService;
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final HttpSession session;
    private final User user;

    @Setter
    private SiteUser siteUser = null;

    public Rq(UserService userService, HttpServletRequest request, HttpServletResponse response,
              HttpSession session) {
        this.userService = userService;
        this.request = request;
        this.response = response;
        this.session = session;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof User) {
            this.user = (User) authentication.getPrincipal();
            getSiteUser();
        } else {
            this.user = null;
        }
    }

    public boolean isLogin() {
        return user != null;
    }

    public boolean isLogout() {
        return !this.isLogin();
    }

    public SiteUser getSiteUser() {
        if (isLogout()) {
            return null;
        }
        if (siteUser == null) {
            ResultData<SiteUser> rs = this.userService.findByUsername(getLoggedInUsername());
            this.siteUser = rs.getData();
        }
        return siteUser;
    }

    public String getLoggedInUsername() {
        if (isLogout()) {
            return null;
        }
        return user.getUsername();
    }
}
