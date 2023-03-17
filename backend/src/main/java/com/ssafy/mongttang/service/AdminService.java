package com.ssafy.mongttang.service;

import com.ssafy.mongttang.dto.ReqChallengeCreateFormDto;
import com.ssafy.mongttang.dto.ResponseChallengeInfoDto;
import com.ssafy.mongttang.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    @Transactional
    public ResponseChallengeInfoDto addNewChallenge(ReqChallengeCreateFormDto reqChallengeCreateFormDto) {
        return new ResponseChallengeInfoDto(adminRepository.save(reqChallengeCreateFormDto.toEntity()));
    }
}
