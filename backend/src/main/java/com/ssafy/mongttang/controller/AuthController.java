package com.ssafy.mongttang.controller;


import com.ssafy.mongttang.dto.ReqIssueDto;
import com.ssafy.mongttang.entity.User;
import com.ssafy.mongttang.repository.UserRepository;
import com.ssafy.mongttang.service.TokenProviderService;
import com.ssafy.mongttang.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private static final String MESSAGE = "message";
    private static final String RESULT = "result";
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private final RedisTemplate redisTemplate;
    private final UserService userService;
    private final TokenProviderService tokenProviderService;

    @PostMapping("/reissue")
    public ResponseEntity<Map<String,Object>> reissue(@RequestBody ReqIssueDto reqIssueDto) {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        // 1. Refresh Token 검증
        if (!tokenProviderService.validateToken(reqIssueDto.getRefreshToken())) {
            resultMap.put(MESSAGE, FAIL);
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }

        // 2. Access Token 에서 User Id를 가져옵니다.
        User user = userService.getUser(reqIssueDto.getUserId());

        // 3. Redis 에서 User email 을 기반으로 저장된 Refresh Token 값을 가져옵니다.
        String refreshToken = (String) redisTemplate.opsForValue().get("RT:" + reqIssueDto.getUserId());

        // (추가) 로그아웃되어 Redis 에 RefreshToken 이 존재하지 않는 경우 처리
        if(ObjectUtils.isEmpty(refreshToken) || !refreshToken.equals(reqIssueDto.getRefreshToken())) {
            resultMap.put(MESSAGE, FAIL);
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }

        // 4. 새로운 토큰 생성
        String token = tokenProviderService.createAccessToken(user.getUserId(), user.getUserRole());
        resultMap.put(MESSAGE, SUCCESS);
        resultMap.put("accessToken", token);
        status = HttpStatus.ACCEPTED;
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
