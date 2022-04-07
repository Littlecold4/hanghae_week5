package com.sparta.week5.login;


import com.sparta.week5.login.SignupRequestDto;
import com.sparta.week5.login.User;
import com.sparta.week5.login.UserRoleEnum;
import com.sparta.week5.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto) {
// 회원 ID 중복 확인
        String username = requestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
// 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
        System.out.println(requestDto.isCEO());

// 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if(requestDto.isCEO()){
            role = UserRoleEnum.CEO;
        }
        User user = new User(username, password, role);
        userRepository.save(user);
    }
}