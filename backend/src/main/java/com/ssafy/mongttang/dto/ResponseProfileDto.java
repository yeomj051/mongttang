package com.ssafy.mongttang.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class ResponseProfileDto {

    private int userId;
    private String profileImgURL;
    private String userNickname;
    private String userInfo;
    private int numOfFollower;
    private int numOfFollowing;

    private boolean isFollow;
    private ArrayList<BookInfo> myBooks;
    private ArrayList<BookInfo> inCompleteBooks;
    private ArrayList<BookInfo> interestBooks;
    private ArrayList<BookInfo> paidBooks;

    public void addMyprofileInfo(ArrayList<BookInfo> inCompleteBooks, ArrayList<BookInfo> paidBooks) {
        this.inCompleteBooks = inCompleteBooks;
        this.paidBooks = paidBooks;
    }
}


