package com.ssafy.mongttang.controller;

import com.ssafy.mongttang.dto.UserPrincipalDto;
import com.ssafy.mongttang.entity.User;
import com.ssafy.mongttang.service.TokenProviderService;
import com.ssafy.mongttang.service.UserService;
import com.ssafy.mongttang.util.TokenUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private static final String MESSAGE = "message";
    private static final String RESULT = "result";
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private final RedisTemplate redisTemplate;
    private final UserService userService;
    private final TokenProviderService tokenProviderService;

    @ApiOperation(value = "닉네임 중복 검사", notes = "회원의 닉네임의 중복 여부를 검사합나다.", response = Map.class)
    @GetMapping("/{userNickname}")
    public ResponseEntity<Map<String,Object>> nicknameDpcn(@ApiParam(value = "닉네임", required = true, example = "홍길동")
                                                               @PathVariable String userNickname){
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        User user = userService.nicknameDpcn(userNickname);

        if(user == null){
            resultMap.put(MESSAGE , SUCCESS);
            status = HttpStatus.OK;
        } else {
            resultMap.put(MESSAGE, FAIL);
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "닉네임 수정", notes = "회원의 닉네임을 수정한다.", response = Map.class)
    @PatchMapping("/{userId}")
    public ResponseEntity<Map<String,Object>> nicknameModify(@ApiParam(value = "수정할 회원정보(아이디)", required = true, example = "1") @PathVariable int userId,
                                                             @ApiParam(value = "수정할 회원정보(변경할 닉네임)", required = true, example  = "홍동길") @RequestParam String userNickname){
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        User user = userService.nicknameModify(userId, userNickname);

        if(user == null){
            resultMap.put(MESSAGE, FAIL);
            status = HttpStatus.BAD_REQUEST;
        } else {
            resultMap.put(MESSAGE, SUCCESS);
            resultMap.put("userNickname", user.getUserNickname());
            status = HttpStatus.OK;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @GetMapping("/logout")
    public ResponseEntity<Map<String,Object>> logout(Principal principal, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        // 3. Redis 에서 해당 User email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        if (redisTemplate.opsForValue().get("RT:" + principal.getName()) != null) {
            // Refresh Token 삭제
            redisTemplate.delete("RT:" + principal.getName());
        }

        String accessToken = TokenUtils.getJwtFromRequest(request);

        // 4. 해당 Access Token 유효시간 가지고 와서 BlackList 로 저장하기
        Long expiration = tokenProviderService.getExpiration(accessToken);
        redisTemplate.opsForValue()
                .set(accessToken, "logout", expiration, TimeUnit.MILLISECONDS);

        resultMap.put(MESSAGE, SUCCESS);
        status = HttpStatus.OK;

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}