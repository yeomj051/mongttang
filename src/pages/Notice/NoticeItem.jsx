import React, { useState } from 'react';
import FormatDate from 'utils/FormatDate';

import tw, { styled, css } from 'twin.macro';
import upToggleBtn from '../../assets/icons/upToggle.svg';
import downToggleBtn from '../../assets/icons/downToggle.svg';

const TitleWrapper = styled.div``;

const Title = styled.div``;
const Time = styled.div``;
const ToggleButton = styled.button`
  outline: none;
`;

const ContentContainer = styled.div``;

function NoticeListItem({ title, content, createdTime }) {
  const [isRead, setIsRead] = useState(false);
  const { year, month, day, hour, minute } = FormatDate(createdTime);

  const readContent = () => {
    setIsRead(!isRead);
  };

  return (
    <div>
      <TitleWrapper onClick={readContent}>
        <Title>
          <span>{title}</span>
        </Title>
        <Time>
          <span>
            {year}년 {month}월 {day}일 {hour}:{minute}
          </span>
        </Time>
        <ToggleButton>
          {isRead ? (
            <img src={upToggleBtn} alt="" />
          ) : (
            <img src={downToggleBtn} alt="" />
          )}
        </ToggleButton>
      </TitleWrapper>

      <ContentContainer>{isRead ? <></> : <p>{content}</p>}</ContentContainer>
    </div>
  );
}

export default NoticeListItem;
