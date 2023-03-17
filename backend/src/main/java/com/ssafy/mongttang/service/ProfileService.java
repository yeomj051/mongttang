package com.ssafy.mongttang.service;

import com.ssafy.mongttang.dto.ResponseFollowerDto;
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

    public Follow followArtist(int userId, int artistId) {
        User user = userRepository.findByUserId(userId);
        User artist = userRepository.findByUserId(artistId);
        System.out.println(artist.getUserRole());
        if(user == null || artist == null || !artist.getUserRole().equals("ROLE_ARTIST")) return null;
        else{
            Follow follow = followRepository.findByFollowFromAndFollowTo(user,artist);
            if(follow == null){
                return followRepository.save(new Follow(user,artist));
            }
            return null;
        }
    }

    public int followCancleArtist(int userId, int artistId) {
        User user = userRepository.findByUserId(userId);
        User artist = userRepository.findByUserId(artistId);
        System.out.println(artist.getUserRole());
        if(user == null || artist == null || !artist.getUserRole().equals("ROLE_ARTIST")) return 0;
        else{
            Follow follow = followRepository.findByFollowFromAndFollowTo(user,artist);
//            System.out.println(followRepository.findByFollowToAndFollowFrom(userId,artistId).toString());
            if(follow == null){
                return 0;
            }else{
                followRepository.delete(follow);
                return 1;
            }
        }
    }

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

    public List<ResponseFollowerDto> getFollower(int userId) {
        User user = userRepository.findByUserId(userId);
        if(user == null) return null;
        else {
            List<Follow> followList = followRepository.findByFollowTo(user);
            List<ResponseFollowerDto> followers = new ArrayList<>();
            for (Follow follow : followList) {
                ResponseFollowerDto responseFollowerDto = new ResponseFollowerDto(follow.getFollowFrom());
                followers.add(responseFollowerDto);
            }
            return followers;
        }
    }


}
