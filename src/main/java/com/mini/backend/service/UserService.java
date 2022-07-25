package com.mini.backend.service;

import com.mini.backend.domain.User;
import com.mini.backend.dto.SignupRequestDto;
import com.mini.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto) {

        String userId = requestDto.getUserId();
        String password = passwordEncoder.encode(requestDto.getUserPassword()); // 패스워드 암호화
        String userName = requestDto.getUserName();

        User user = new User(userId, password, userName);
        userRepository.save(user);
    }

}
