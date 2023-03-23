package com.ssafy.mongttang.dto;

import com.ssafy.mongttang.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ResponseCommentDto {
    private int commentId;
    private int userId;
    private int bookId;
    private String commentContent;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public ResponseCommentDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.userId = comment.getCommentUserId().getUserId();
        this.bookId = comment.getCommentBookId().getBookId();
        this.commentContent = comment.getCommentContent();
        this.createdTime = comment.getCreatedTime();
        this.updatedTime = comment.getUpdatedTime();
    }
}
