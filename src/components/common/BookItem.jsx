/**
 * 메인화면 및 챌린지화면에 들어갈 동화 상세로 이어질 컴포넌트
 */
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import tw, { styled, css } from 'twin.macro';

import BookInfo from './BookInfo';

const BookImage = styled.div`
  ${tw`border-b w-40 h-40 transition duration-300 ease-in-out hover:opacity-40 hover:scale-110`}
`;

//props로 가져와야하는 정보 : 책 아이디(경로지정용), 책 이미지, 책 정보들(책 제목, 작가명, 댓글 수, 좋아요 수), 책 링크
function BookItem({
  bookId,
  bookImgUrl,
  artistNickname,
  bookTitle,
  numOfLike,
  numOfComment,
}) {
  const [isHover, setIsHover] = useState(false); //마우스가 올라가있는지
  const bookImg = 'https://tecdn.b-cdn.net/img/new/fluid/city/113.webp'; //더미데이터
  // const bookImg = bookImgUrl;

  const navigate = useNavigate();

  const handleHover = (props) => {
    setTimeout(() => {
      setIsHover(props);
    }, 150);
  };

  return (
    <BookImage
      onMouseOver={() => handleHover(true)}
      onMouseOut={() => handleHover(false)}
      onClick={() => navigate(`/books/${bookId}`)}
    >
      <img src={bookImg} alt="book" />
      {isHover ? (
        <BookInfo
          title={bookTitle}
          artist={artistNickname}
          likes={numOfLike}
          comments={numOfComment}
        />
      ) : null}
    </BookImage>
  );
}

export default BookItem;
