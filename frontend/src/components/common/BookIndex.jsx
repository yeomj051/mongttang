//BookInfo 추가버전
import React from 'react';

import LinearProgress, {
  linearProgressClasses,
} from '@mui/material/LinearProgress';
import Box from '@mui/material/Box';
import { styled } from '@mui/material/styles';

const BorderLinearProgress = styled(LinearProgress)(({ theme }) => ({
  height: 10,
  borderRadius: 5,
  [`&.${linearProgressClasses.colorPrimary}`]: {
    backgroundColor: '#E7D4C6',
  },
  [`& .${linearProgressClasses.bar}`]: {
    borderRadius: 5,
    backgroundColor: '#B79F93',
  },
}));

const TextWrapper = styled('div')`
  display: flex;
  justify-content: space-between;
`;

function BookIndex({ book }) {
  return (
    <div>
      <Box width={100}>
        <TextWrapper>
          <p>조회수</p>
          <p>{book.numOfViews}</p>
        </TextWrapper>
        <BorderLinearProgress variant="determinate" value={book.numOfViews} />
      </Box>
      <Box width={100}>
        <TextWrapper>
          <p>좋아요 수</p>
          <p>{book.numOfLike}</p>
        </TextWrapper>
        <BorderLinearProgress variant="determinate" value={book.numOfLike} />
      </Box>
      <Box width={100}>
        <TextWrapper>
          <p>댓글 수</p>
          <p>{book.numOfComment}</p>
        </TextWrapper>
        <BorderLinearProgress variant="determinate" value={book.numOfComment} />
      </Box>
    </div>
  );
}

export default BookIndex;
