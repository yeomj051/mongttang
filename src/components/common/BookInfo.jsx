import React from 'react';
import tw, { styled, css } from 'twin.macro';

const Title = styled.div``;
const Artist = styled.div``;
const Likes = styled.div``;
const Comments = styled.div``;

function BookInfo({ title, artist, likes, comments }) {
  return (
    <div>
      <Title>제목</Title>
      <Artist>작가명</Artist>
      <Likes>좋아요수</Likes>
      <Comments>댓글수</Comments>
    </div>
  );
}

export default BookInfo;
