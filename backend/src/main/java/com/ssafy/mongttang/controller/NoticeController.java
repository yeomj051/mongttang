package com.ssafy.mongttang.controller;


import com.ssafy.mongttang.dto.NoticeCreateFormDto;
import com.ssafy.mongttang.dto.NoticeInfoDto;
import com.ssafy.mongttang.dto.NoticeUpdateFormDto;
import com.ssafy.mongttang.entity.Notice;
import com.ssafy.mongttang.service.NoticeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {
    private NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    private static final String MESSAGE = "message";
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";



    //공지사항 조회
    @ApiOperation(value = "공지사항 상세 조회", notes = "공지사항 번호에 해당하는 공지사항 정보 반환")
    @GetMapping("/{noticeId}")
    public ResponseEntity<Map<String, Object>> getNotice(@PathVariable @ApiParam(value = "조회할 공지사항 번호", example = "0") int noticeId) {
        Map<String, Object> map = new HashMap<>();
        NoticeInfoDto notice = noticeService.getNotice(noticeId);
        if(notice != null) {
            map.put(MESSAGE, SUCCESS);
            map.put("notice", notice);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } else {
            map.put(MESSAGE, FAIL);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }

    //공지사항 수정
    @ApiOperation(value = "공지사항 글 수정", notes = "수정할 공지사항 정보 입력")
    @PatchMapping("/{noticeId}")
    public ResponseEntity<Map<String, Object>> updateNotice(@PathVariable int noticeId,
                                                            @Valid @RequestBody @ApiParam(value = "수정 글 정보 담은 dto") NoticeUpdateFormDto noticeUpdateFormDto) {
        Map<String, Object> map = new HashMap<>();

        Notice updatedNotice = noticeService.updateNotice(noticeId, noticeUpdateFormDto);
        if(updatedNotice != null) {
            map.put(MESSAGE, SUCCESS);
            map.put("notice", updatedNotice);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } else {
            map.put(MESSAGE, FAIL);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }

    }

    //공지사항 삭제
    @ApiOperation(value = "공지사항 삭제", notes = "공지사항 번호에 해당하는 공지사항 정보 삭제, DB에서 삭제 여부에 따라 'success' 또는 'fail' 반환")
    @DeleteMapping("/{noticeId}")
    public ResponseEntity<Map<String, Object>> deleteNotice(@PathVariable @ApiParam(value = "삭제할 공지사항 번호", example = "0") int noticeId) {
        Map<String, Object> map = new HashMap<>();
        if(noticeService.deleteNotice(noticeId) == 1) {
            map.put(MESSAGE, SUCCESS);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } else {
            map.put(MESSAGE, FAIL);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }
}
