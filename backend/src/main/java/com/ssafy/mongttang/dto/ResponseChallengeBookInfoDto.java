package com.ssafy.mongttang.dto;

import com.ssafy.mongttang.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseChallengeBookInfoDto {
    private int bookId;
    private String bookTitle;
    private int userId;
    private String userNickname;
    private String coverImgURL;
    private String profileImgURL;
    private int numOfComment;

    private int numOfLike;

    private boolean isLike;
    public ResponseChallengeBookInfoDto(Book book, String coverImgURL, int numOfComment, int numOfLike, boolean isLike) {
        this.bookId = book.getBookId();
        this.bookTitle = book.getBookTitle();
        this.userId = book.getBookUserId().getUserId();
        this.userNickname = book.getBookUserId().getUserNickname();
        this.coverImgURL = coverImgURL;
        this.profileImgURL = book.getBookUserId().getUserProfileImg();
        this.numOfComment = numOfComment;
        this.numOfLike = numOfLike;
        this.isLike = isLike;
    }
}
