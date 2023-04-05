import React, { useEffect, useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
import tw, { styled, css } from 'twin.macro';

import requests from 'api/config';
import { defaultApi, authApi } from 'api/axios';
import FollowList from './FollowList';
import UserIcon from 'assets/images/UserIcon.svg';
import ProfileImg2 from 'components/common/ProfileImg2';
import EditProfileIcon from 'assets/icons/pencil03.svg';
import BookListItem from 'components/common/BookListItem';
import { userStore } from 'store/userStore';

const ProfileContainer = styled.div`
  ${tw`flex flex-col items-center justify-center w-full z-10 pt-[80px]`}
`;
const NickNameWrapper = styled.div`
  ${tw`flex items-center pt-2`}
`;

const NickName = styled.span`
  ${tw`text-[40px]`}
`;
const InfoWrapper = styled.div`
  ${tw`flex items-center justify-between cursor-pointer rounded-full shadow`}
`;
const Following = styled.span`
  ${tw`text-[30px] px-2`}
`;
const Follower = styled.span`
  ${tw`text-[30px] px-2`}
`;
const UserInfo = styled.span`
  ${tw`text-[35px] pt-2`}
`;

const CompletedBookContainer = styled.div`
  ${tw`flex flex-col px-48`}
`;

const CompletedBookList = styled.div`
  ${tw`flex py-2`}
`;

const InCompleteBookList = styled.div`
  ${tw`flex`}
`;

const LikedBookContainer = styled.div`
  ${tw`flex flex-col px-48`}
`;
const LikedBookList = styled.div`
  ${tw`flex py-2`}
`;

const PurchasedBookContainer = styled.div`
  ${tw`flex flex-col px-48`}
`;
const PurchasedBookList = styled.div`
  ${tw`flex py-2`}
`;

function MyProfile() {
  const userId = Number(localStorage.getItem('userId'));
  const [userImg, setUserImg] = useState(UserIcon);
  const [userNickname, setUserNickname] = useState('');
  const [userInfo, setUserInfo] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [userFollower, setUserFollower] = useState('');
  const [userFollowing, setUserFollowing] = useState('');
  const [myBooks, setMyBooks] = useState('');
  const [inCompleteBooks, setInCompleteBooks] = useState('');
  const [interestBooks, setInterestBooks] = useState('');
  const [paidBooks, setPaidBooks] = useState('');
  const [showFollow, setShowFollow] = useState(false);
  const [followings, setFollowings] = useState([]);
  const [followers, setFollowers] = useState([]);
  const wallet = userStore((state) => state.userWallet);
  const showFollowHandler = () => {
    setShowFollow(!showFollow);
  };
  const openWallet = () => {
    window.open(
      `http://j8a308.p.ssafy.io:3333/?key=${wallet}`,
      'MyWallet',
      'toolbar=no, menubar=no, width=550, height=780',
    );
  };
  //프로필 조회 api사용
  useEffect(() => {
    const get_user = async () => {
      try {
        const { data } = await authApi.get(requests.GET_PROFILE(userId));
        setUserNickname(data.profile.userNickname);
        setUserFollower(data.profile.numOfFollower);
        setUserFollowing(data.profile.numOfFollowing);
        setUserInfo(data.profile.userInfo);
        setUserImg(data.profile.profileImgURL);
        setMyBooks(data.profile.myBooks);
        setInCompleteBooks(data.profile.inCompleteBooks);
        setInterestBooks(data.profile.interestBooks);
        setPaidBooks(data.profile.paidBooks);
        console.log(data);
      } catch (error) {
        throw error;
      }
    };
    const get_following = async () => {
      try {
        const { data } = await authApi.get(requests.GET_FOLLOWING(userId));
        setFollowings(data.followings);
        console.log(data);
      } catch (error) {
        throw error;
      }
    };
    const get_follower = async () => {
      try {
        const { data } = await authApi.get(requests.GET_FOLLOWER(userId));
        setFollowers(data.followers);
        console.log(data);
      } catch (error) {
        throw error;
      }
    };

    get_following();
    get_follower();
    get_user();
  }, [userImg]);

  return (
    <div>
      <ProfileContainer>
        <ProfileImg2 userImg={userImg} />
        <NickNameWrapper>
          <NickName>{userNickname}</NickName>
          <Link to="/myprofile/edit">
            <img
              src={EditProfileIcon}
              alt="edit icon"
              className="w-[40px] h-[40px]"
            />
          </Link>
        </NickNameWrapper>
        <InfoWrapper onClick={showFollowHandler}>
          <Following>팔로잉 {userFollowing}</Following>
          <Follower>팔로워 {userFollower}</Follower>
        </InfoWrapper>
        {showFollow ? (
          <FollowList followers={followers} followings={followings} />
        ) : (
          ''
        )}
        {userInfo ? (
          <UserInfo>{userInfo}</UserInfo>
        ) : (
          <UserInfo>소개를 작성해 주세요</UserInfo>
        )}
        {/* <NickName onClick={openWallet}>지갑보러가기</NickName> */}
      </ProfileContainer>
      <CompletedBookContainer>
        <span className="text-[40px]">완성한 동화</span>
        <CompletedBookList>
          {myBooks.length !== 0
            ? myBooks.map((book) => {
                return (
                  <BookListItem
                    key={book.bookId}
                    width="w-[180px]"
                    height="h-[240px]"
                    book={book}
                  />
                );
              })
            : null}
        </CompletedBookList>
      </CompletedBookContainer>

      {/* <InCompleteBookList>
        <span className="text-[40px]">작업중인 동화</span>
        {inCompleteBooks.length !== 0
          ? inCompleteBooks.map((book) => {
              return (
                <BookListItem
                  key={book.bookId}
                  width="w-[180px]"
                  height="h-[250px]"
                  book={book}
                  incomplete={true}
                />
              );
            })
          : null}
      </InCompleteBookList> */}
      <LikedBookContainer>
        <span className="text-[40px]">관심목록</span>
        <LikedBookList>
          {interestBooks.length !== 0
            ? interestBooks.map((book) => {
                return (
                  <BookListItem
                    key={book.bookId}
                    width="w-[180px]"
                    height="h-[250px]"
                    book={book}
                  />
                );
              })
            : null}
        </LikedBookList>
      </LikedBookContainer>
      <PurchasedBookContainer>
        <PurchasedBookList>
          <span className="text-[40px]">구매목록</span>
          {paidBooks.length !== 0
            ? paidBooks.map((book) => {
                return (
                  <BookListItem
                    key={book.bookId}
                    width="w-[180px]"
                    height="h-[250px]"
                    book={book}
                  />
                );
              })
            : null}
        </PurchasedBookList>
      </PurchasedBookContainer>
    </div>
  );
}

export default MyProfile;