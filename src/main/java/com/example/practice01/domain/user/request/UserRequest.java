package com.example.practice01.domain.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UserRequest {

    @Getter
    @Setter
    public static class create {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }
}
