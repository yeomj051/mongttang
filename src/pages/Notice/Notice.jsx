/**
 * 공지사항 조회 페이지
 *
 *
 */
import React from 'react';
import requests from 'api/config';
import { authApi } from 'api/axios';

import tw, { styled, css } from 'twin.macro';
import NoticeListItem from './NoticeItem';

const NoticeList = styled.div``;

function Notice(pageId) {
  const pageLimit = 3; //현재 등록된 공지수 / 10?
  const notice = authApi
    .get(requests.GET_NOTICE(pageId, pageLimit))
    .then((response) => response.notice);

  return (
    <div>
      <div className="header" />
      <NoticeList>
        {[...notice].map((article) => (
          <NoticeListItem
            key={article.noticeId}
            title={article.noticeTitle}
            content={article.noticeContent}
            createdTime={article.createdTime}
          />
        ))}
      </NoticeList>
    </div>
  );
}

export default Notice;
