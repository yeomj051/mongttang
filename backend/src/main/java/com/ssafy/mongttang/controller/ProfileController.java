package com.ssafy.mongttang.controller;

import com.ssafy.mongttang.dto.ResponseFollowingDto;
import com.ssafy.mongttang.entity.Follow;
import com.ssafy.mongttang.entity.User;
import com.ssafy.mongttang.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController{
    private static final String MESSAGE = "message";
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private final ProfileService profileService;

    @ApiOperation(value = "팔로잉 목록 조회", notes = "자신이 팔로우한 사용자의 목록을 조회한다.", response = Map.class)
    @GetMapping("/following/{userId}")
    public ResponseEntity<Map<String,Object>> getFollowing(@ApiParam(value = "회원 아이디", required = true, example = "0") @PathVariable int userId){
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        List<ResponseFollowingDto> followings = profileService.getFollowing(userId);

        if(followings == null){
            resultMap.put(MESSAGE, FAIL);
            status = HttpStatus.BAD_REQUEST;
        }else{
            resultMap.put(MESSAGE,SUCCESS);
            resultMap.put("followings",followings);
            status = HttpStatus.OK;
        }

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

}
