import React, { useEffect, useRef, useState } from 'react';
import Slider from 'react-slick';
import '../../assets/slick-theme.css';
import '../../assets/slick.css';

import tw, { styled, css } from 'twin.macro';

import { bookImg } from 'api/data';

const ViewContainer = styled.div`
  ${tw`flex justify-center`}
`;

const BtnWrapper = styled.div`
  ${tw`w-fit h-[24px] p-1 py-[12px] text-sub-bold text-black rounded-full flex justify-center items-center shadow cursor-pointer`}
`;

//이미지 슬라이드
const ImgSlide = ({ key, src, mode }) => {
  if (mode === 1) {
    return (
      <div
        style={{
          display: 'flex',
          flexDirection: 'row',
          justifyContent: 'center',
          width: '65vw',
          // zIndex: 50,
          height: '80vh',
        }}
      >
        <img src={src} alt={key} />
      </div>
    );
  } else if (mode === 2) {
    return (
      <div
        style={{
          display: 'flex',
          flexDirection: 'row',
          justifyContent: 'center',
          // width: '65vw',
          // zIndex: 50,
          height: '80vh',
        }}
      >
        <img src={src} alt={key} />
      </div>
    );
  }
};

const NextArrow = (props) => {
  const { className, style, onClick } = props;
  return (
    <div
      className={className}
      style={{ ...style, backgroundColor: '#807E89' }}
      onClick={onClick}
    />
  );
};

const PrevArrow = (props) => {
  const { className, style, onClick } = props;
  return (
    <div
      className={className}
      style={{ ...style, backgroundColor: '#807E89' }}
      onClick={onClick}
    />
  );
};

function BookViewer() {
  const [slidesToShow, setSlidesToShow] = useState(1);
  const [modeStatus, setModeStatus] = useState(false); //페이지 모드

  const slider = useRef();

  const slidePlay = () => {
    slider.current.slickPlay();
  };

  const slidePause = () => {
    slider.current.slickPause();
  };
  useEffect(() => {
    if (modeStatus) setSlidesToShow(1);
    else setSlidesToShow(2);
  }, [modeStatus]);

  const settings = {
    dots: true, //페이징용 도트
    // fade: true, //페이드
    lazyLoad: false, //레이지로딩
    infinite: true, //무한반복 옵션
    // vertical: true, //수직 모드
    // verticalSwiping: true, //수직 스크롤링 옵션
    beforeChange: function (currentSlide, nextSlide) {
      console.log('before change', currentSlide, nextSlide);
    },
    afterChange: function (currentSlide) {
      console.log('after change', currentSlide);
    },
    speed: 500, //넘어가는 속도(클수록 느림)
    slidesToShow: slidesToShow, //한번에 보이는 페이지 수
    slidesToScroll: 1, //한번에 넘어가는 페이지 수(잘 안됨)
    autoplay: true, //자동재생 옵션
    autoplaySpeed: 1000, //자동재생 시간(클수록 늦게 넘어감)
    // centerMode: true,
    centerPadding: 0, //다른 슬라이드 보이기 싫으면 0
    arrows: true,
    nextArrow: <NextArrow />,
    prevArrow: <PrevArrow />,
    mode: slidesToShow,
  };

  return (
    <div>
      <ViewContainer>
        <Slider ref={slider} {...settings}>
          {bookImg
            ? bookImg.illustes.map((illuste) => {
                return (
                  <ImgSlide
                    src={illuste.illustePath}
                    key={illuste.pageNo}
                    mode={settings.mode}
                  />
                );
              })
            : null}
        </Slider>
      </ViewContainer>
      <BtnWrapper>
        {modeStatus ? (
          <button onClick={() => setModeStatus(!modeStatus)}>1단</button>
        ) : (
          <button onClick={() => setModeStatus(!modeStatus)}>2단</button>
        )}
      </BtnWrapper>
      <BtnWrapper>
        <button onClick={slidePlay}>재생</button>
      </BtnWrapper>
      <BtnWrapper>
        <button onClick={slidePause}>중지</button>
      </BtnWrapper>
    </div>
  );
}

export default BookViewer;
