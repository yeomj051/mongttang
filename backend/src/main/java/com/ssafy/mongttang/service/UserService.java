package com.ssafy.mongttang.service;

import com.ssafy.mongttang.entity.User;
import com.ssafy.mongttang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User nicknameDpcn(String userNickname) {
        return userRepository.findByUserNickname(userNickname);
    }

}
