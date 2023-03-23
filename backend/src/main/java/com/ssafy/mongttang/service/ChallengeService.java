package com.ssafy.mongttang.service;

import com.ssafy.mongttang.dto.ResponseBookInfoDto;
import com.ssafy.mongttang.dto.ResponseChallengeBookInfoDto;
import com.ssafy.mongttang.dto.ResponseThisWeekChallengeDto;
import com.ssafy.mongttang.entity.Book;
import com.ssafy.mongttang.entity.BookLike;
import com.ssafy.mongttang.entity.Challenge;
import com.ssafy.mongttang.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeService {
    private final ChallengRepository challengRepository;
    private final IllustRepository illustRepository;
    private final CommentRepository commentRepository;
    private final BookLikeRepository bookLikeRepository;

    public List<ResponseThisWeekChallengeDto> getThisWeekChallenge(int userId) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<Challenge> challengeList = challengRepository.findThisWeekChallenge(currentDateTime);
        List<ResponseThisWeekChallengeDto> result = new ArrayList<>();
        if(challengeList == null) return null;
        for(Challenge challenge : challengeList){
            // 좋아요 Top3만 가져오기
            // 좋아요 테이블에서 top3의 bookId 조회
            List<Book> bookList = bookLikeRepository.findTop3LikeBook(challenge.getChallengeId());
            if(bookList == null) return null;
            List<ResponseChallengeBookInfoDto> bookResult = new ArrayList<>();
            for(Book book: bookList) {
                //동화 표지 가져요기
                String coverImgPath = illustRepository.findCoverIllust(book.getBookId());
                //댓글 개수 가져오기
                int numOfComment = commentRepository.countByCommentBookId_BookId(book.getBookId());
                //좋아요 개수 가져오기
                int numOfLike = bookLikeRepository.countByBooklikeBookId_BookId(book.getBookId());
                //좋아요 여부 가져오기
                BookLike bookLike = bookLikeRepository.findByBooklikeBookIdAndBooklikeUserId(book, userId);
                bookResult.add(new ResponseChallengeBookInfoDto(book, coverImgPath, numOfComment, numOfLike, (bookLike == null) ? false : true));
            }
            result.add(new ResponseThisWeekChallengeDto(challenge, bookResult));
        }
        return result;
    }
}
