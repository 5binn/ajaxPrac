package com.example.practice01.domain.user.service;

import com.example.practice01.domain.user.entity.SiteUser;
import com.example.practice01.domain.user.repository.UserRepository;
import com.example.practice01.global.rsData.ResultCode;
import com.example.practice01.global.rsData.ResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResultData create(String username, String password) {
        if (this.findByUsername(username).getData() != null) {
            return ResultData.of(ResultCode.F_06,"중복된 ID가 존재합니다.");
        }
        SiteUser user = SiteUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
        this.userRepository.save(user);
        return ResultData.of(ResultCode.S_02, "회원가입 완료");
    }

    public ResultData findByUsername(String username) {
        Optional<SiteUser> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            return ResultData.of(ResultCode.F_04,"해당 ID가 존재하지 않습니다.", null);
        }
        return ResultData.of(ResultCode.S_01, "불러오기 성공", user.get());
    }
}
