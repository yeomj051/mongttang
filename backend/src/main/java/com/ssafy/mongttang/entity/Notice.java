package com.ssafy.mongttang.entity;

import com.ssafy.mongttang.dto.ReqNoticeUpdateFormDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "notice")
public class Notice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeId;

    @Column(nullable = false)
    private String noticeTitle;

    @Column(nullable = false)
    private String noticeContent;

    @Builder
    public Notice(int noticeId, String noticeTitle, String noticeContent) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
    }

    public void update(ReqNoticeUpdateFormDto reqNoticeUpdateFormDto){
        this.noticeTitle = reqNoticeUpdateFormDto.getNoticeTitle();
        this.noticeContent = reqNoticeUpdateFormDto.getNoticeContent();
    }
}
