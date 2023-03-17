package com.ssafy.mongttang.controller;


import com.ssafy.mongttang.dto.ReqChallengeCreateFormDto;
import com.ssafy.mongttang.dto.ResponseChallengeInfoDto;
import com.ssafy.mongttang.dto.ResponseChallengeUpdateDto;
import com.ssafy.mongttang.service.AdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    private static final String MESSAGE = "message";
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @ApiOperation(value = "관리자가 새로운 챌린지 등록", notes = "관리자가 새로운 챌린지를 등록한다.", response = Page.class)
    @PostMapping("/challenge")
    public ResponseEntity<Map<String, Object>> addNewChallenge(@ApiParam(value = "등록할 새로운 챌린지 정보를 담은 dto") @RequestBody ReqChallengeCreateFormDto reqChallengeCreateFormDto) {
        Map<String, Object> map = new HashMap<>();

        ResponseChallengeInfoDto challenge = adminService.addNewChallenge(reqChallengeCreateFormDto);
        if(challenge != null){
            map.put(MESSAGE, SUCCESS);
            map.put("challenge", challenge);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } else {
            map.put(MESSAGE, FAIL);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "관리자가 새로운 챌린지 등록", notes = "관리자가 새로운 챌린지를 등록한다.", response = Page.class)
    @PatchMapping("/challenge/{challengeId}")
    public ResponseEntity<Map<String, Object>> updateChallenge(@PathVariable @ApiParam(value = "수정할 챌린지 아이디 번호") int challengeId,
                                                               @ApiParam(value = "등록할 새로운 챌린지 정보를 담은 dto") @RequestBody ReqChallengeCreateFormDto reqChallengeCreateFormDto) {
        Map<String, Object> map = new HashMap<>();

        ResponseChallengeUpdateDto challenge = adminService.updateChallenge(challengeId, reqChallengeCreateFormDto);
        if(challenge != null){
            map.put(MESSAGE, SUCCESS);
            map.put("challenge", challenge);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } else {
            map.put(MESSAGE, FAIL);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }
}
