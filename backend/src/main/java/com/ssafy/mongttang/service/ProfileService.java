package com.ssafy.mongttang.service;

import com.ssafy.mongttang.dto.ResponseFollowingDto;
import com.ssafy.mongttang.dto.UserInterface;
import com.ssafy.mongttang.entity.Follow;
import com.ssafy.mongttang.entity.User;
import com.ssafy.mongttang.repository.FollowRepository;
import com.ssafy.mongttang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProfileService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;
    public List<ResponseFollowingDto> getFollowing(int userId) {
        User user = userRepository.findByUserId(userId);
        if(user == null) return null;
        else {
            List<Follow> followList = followRepository.findByFollowFrom(user);
            List<ResponseFollowingDto> followings = new ArrayList<>();
            for (Follow follow : followList) {
                ResponseFollowingDto responseFollowingDto = new ResponseFollowingDto(follow.getFollowTo());
                followings.add(responseFollowingDto);
            }
            return followings;
        }
    }
}
