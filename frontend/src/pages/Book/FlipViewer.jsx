import React, { useEffect, useRef, useState } from 'react';
import HTMLFlipBook from 'react-pageflip';
import '../../assets/slick-theme.css';
import '../../assets/slick.css';
import '../../components/common/Leaves.css';

import BeforePage from '../../assets/icons/BeforePage.svg';
import NextPage from '../../assets/icons/NextPage.svg';
import tw, { styled, css } from 'twin.macro';
import { authApi } from 'api/axios';
import requests from 'api/config';
import { useParams } from 'react-router-dom';
import { useCallback } from 'react';

// import { bookImg } from 'api/data';

const PageContainer = styled.div`
  ${tw`flex h-[100vh] flex-col`}
`;

const ViewContainer = styled.div`
  ${tw`w-full h-full flex justify-center`}
`;
const PageWrapper = styled.div`
  // ${tw``}
`;

const BarWrapper = styled.div`
  ${tw`m-0 pr-1`}
`;

const BtnContainer = styled.div`
  ${tw`flex justify-end space-x-1 m-0 p-2`}
`;
const BtnWrapper = styled.div`
  ${tw`w-fit h-[24px] p-1 py-[12px] bg-btnBlack text-whiteText text-sub-bold rounded-full flex justify-center items-center shadow cursor-pointer`}
`;

const PageHeader = styled.div`
  ${tw`w-full h-16 bg-red-50 border-4 m-0 p-0`}
`;
const PageFooter = styled.div`
  ${tw`flex justify-center w-full h-16 bg-blue-50 border-4 m-0 p-0`}
`;

const Page = React.forwardRef((props, ref) => {
  return <PageWrapper ref={ref}>{props.children}</PageWrapper>;
});

function FlipViewer() {
  const [bookImg, setBookImg] = useState();
  const [currentPage, setCurrentPage] = useState(1);
  const [allPage, setAllPage] = useState();
  const bookRef = useRef(null);

  const params = useParams();
  const bookId = params.bookId;

  const onFlip = useCallback((e) => {
    setCurrentPage(Number.parseInt(e.data));
  }, []);

  const onInit = useCallback((e) => {
    setCurrentPage(bookRef.current.pageFlip().getCurrentPageIndex());
    const dir = bookRef.current.pageFlip().getPageCount();
    setAllPage(dir);
  });

  const handleFlipNext = () => {
    bookRef.current.pageFlip().flipNext();
  };
  const handleFlipPrev = () => {
    bookRef.current.pageFlip().flipPrev();
  };

  const turnPage = (e) => {
    bookRef.current.pageFlip().turnToPage(Number.parseInt(e));
  };

  useEffect(() => {
    const fetchBookImg = async () => {
      try {
        await authApi
          .get(requests.GET_BOOK_IMAGES(bookId))
          .then((res) => setBookImg(res.data.illustes));
      } catch (error) {
        throw error;
      }
    };
    fetchBookImg();
  }, [bookId]);

  return (
    <PageContainer>
      <PageHeader />
      <ViewContainer>
        <button onClick={handleFlipPrev} style={{ paddingRight: 10 }}>
          <img src={BeforePage} alt="beforePage" />
        </button>
        <HTMLFlipBook
          width={window.innerWidth * 0.3}
          height={window.innerWidth * 0.4}
          ref={bookRef}
          usePortrait={true}
          onFlip={onFlip}
          onInit={onInit}
          showCover={true}
        >
          {bookImg &&
            bookImg.map((img) => (
              <img
                key={img.pageNo}
                src={img.illustePath}
                width={bookRef.current.width}
                height={bookRef.current.height}
                alt="page"
              />
            ))}
        </HTMLFlipBook>
        <button onClick={handleFlipNext}>
          <img src={NextPage} alt="nextPage" />
        </button>
      </ViewContainer>
      <PageFooter>
        {bookImg !== undefined ? (
          <BarWrapper>
            <input
              onChange={(e) => {
                turnPage(e.target.value);
                setCurrentPage(e.target.value);
              }}
              value={currentPage}
              type="range"
              min={0}
              max={allPage - 1}
              style={{
                width: '50vw',
              }}
            />
            {Number.parseInt(currentPage) + 1 + '/' + allPage}
          </BarWrapper>
        ) : null}
      </PageFooter>
    </PageContainer>
  );
}

export default FlipViewer;
