import React from 'react';
import BookListItem from './BookListItem';
import tw, { styled, css } from 'twin.macro';
import BookBadge from './BookBadge';
import BookIndex from './BookIndex';

const BookListWrapper = styled.div`
  ${tw`flex flex-wrap py-2`}
`;

const BookItemContainer = styled.div`
  ${tw`flex flex-row`}
`;

function BookList({ width, height, books }) {
  if (books.length === 0) {
    return <p>책 내역이 없습니다.</p>; // or return an empty component like <></>
  }

  // console.log(books);
  return (
    <BookListWrapper>
      {books
        ? books.map((book) => (
            <BookItemContainer key={book.bookId}>
              <BookBadge rank={book.total}>
                <BookListItem book={book} width={width} height={height} />
              </BookBadge>
              <BookIndex book={book} />
            </BookItemContainer>
          ))
        : ''}
    </BookListWrapper>
  );
}

export default BookList;
