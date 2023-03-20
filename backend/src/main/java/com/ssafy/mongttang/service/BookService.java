package com.ssafy.mongttang.service;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import com.ssafy.mongttang.dto.ReqSaveBookDto;
import com.ssafy.mongttang.entity.Book;
import com.ssafy.mongttang.entity.Challenge;
import com.ssafy.mongttang.entity.Illust;
import com.ssafy.mongttang.entity.User;
import com.ssafy.mongttang.repository.BookRepository;
import com.ssafy.mongttang.repository.ChallengRepository;
import com.ssafy.mongttang.repository.IllustRepository;
import com.ssafy.mongttang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BookService {
    private final UserRepository userRepository;
    private final ChallengRepository challengeRepository;
    private final BookRepository bookRepository;
    private final IllustRepository illustRepository;
    private final S3Service s3Service;

    public int saveBook(int userId, ReqSaveBookDto reqSaveBookDto, ArrayList<MultipartFile> imgList) throws IOException {
        User user = userRepository.findByUserId(userId);
        Challenge challenge = challengeRepository.findByChallengeId(reqSaveBookDto.getChallengeId());
        if(user == null || challenge == null || !user.getUserRole().equals("ROLE_ARTIST")) return 0;

        Book book = bookRepository.save(new Book(challenge,user,reqSaveBookDto));

        if(book == null) return 0;
        else{
            ArrayList<String> imgPathList = s3Service.uploadBook(imgList, book.getBookChallengeId().getChallengeId(), book.getBookId());
            if(imgPathList == null || imgPathList.isEmpty()) return 0;

            ArrayList<Illust> illustList = savePhoto(book, imgList, imgPathList);
            if(illustList.size() == imgList.size()) return book.getBookId();
            else{
                bookRepository.delete(book);
                s3Service.deleteFolder("books/" + reqSaveBookDto.getChallengeId() + "/" + book.getBookId());

                return 0;
            }
        }
    }

    public ArrayList<Illust> savePhoto(Book book, ArrayList<MultipartFile> imgList, ArrayList<String> imgPathList){

        ArrayList<Illust> illustList = new ArrayList<>();

        for (int i = 0; i < imgList.size(); i++) {
            String illustOriginalFilename = imgList.get(i).getOriginalFilename();
            String illustFilePath = imgPathList.get(i);
            illustList.add(illustRepository.save(new Illust(book, illustOriginalFilename, illustFilePath, i)));
        }
        return illustList;
    }
}
