package com.ssafy.mongttang.service;


import com.ssafy.mongttang.dto.ResponseReportCommentInfoDto;
import com.ssafy.mongttang.repository.CommentReportRepository;
import com.ssafy.mongttang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final CommentReportRepository commentReportRepository;

    private final UserRepository userRepository;



    public List<ResponseReportCommentInfoDto> getReportComments() {
        return commentReportRepository.findAll().stream().map(commentReport
                -> new ResponseReportCommentInfoDto(commentReport, userRepository.findByUserId(commentReport.getCommentreportReportUserId()))).collect(Collectors.toList());
    }
}
