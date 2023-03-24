import React from 'react';
import { useState, useEffect } from 'react';
import {
  Route,
  Routes,
  BrowserRouter,
  Navigate,
  useNavigate,
} from 'react-router-dom';

import NavBar from 'components/common/NavBar';

// component
import Home from './pages/Home/Home';
import MyProfile from 'pages/MyProfile/MyProfile';
import MyProfileEdit from 'pages/MyProfile/MyProfileEdit';
import NicknameEdit from 'pages/MyProfile/NicknameEdit';
import IntroductionEdit from 'pages/MyProfile/IntroductionEdit';
import AdminNavBar from 'pages/Admin/AdminNavBar';
import AdminNotice from 'pages/Admin/AdminNotice';
import AdminChallenge from 'pages/Admin/AdminChallenge';
import AdminCommentReport from 'pages/Admin/AdminCommentReport';
import AdminBookReport from 'pages/Admin/AdminBookReport';
import ChallengeCreaete from 'pages/Admin/ChallengeCreate';
import NoticeCreate from 'pages/Admin/NoticeCreate';
import PrevChallenge from 'pages/Challenge/PrevChallenge';
// react-cookie
import { CookiesProvider } from 'react-cookie';
// react-query
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import UserLogin from 'pages/Login/UserLogin';
import Notice from 'pages/Notice/Notice';
import Test from 'pages/Home/Test';
import BookViewer from 'components/viewer/BookViewer';
const queryClient = new QueryClient();
function App() {
  return (
    <CookiesProvider>
      <QueryClientProvider client={queryClient}>
        <BrowserRouter className="App">
          <NavBar />
          <AdminNavBar />

          <Routes>
            <Route path="/" element={<BookViewer />} />
            <Route path="/home" element={<Home />} />
            <Route path="/login" element={<UserLogin />} />
            <Route path="/notice" element={<Notice />} />
            <Route path="/myprofile" element={<MyProfile />} />
            <Route path="/myprofile/edit" element={<MyProfileEdit />} />
            <Route path="/myprofile/edit/nickname" element={<NicknameEdit />} />
            <Route path="/prevchallenge" element={<PrevChallenge />} />
            <Route
              path="/myprofile/edit/introduction"
              element={<IntroductionEdit />}
            />
            <Route path="/admin/notice" element={<AdminNotice />} />
            <Route path="/admin/challenge" element={<AdminChallenge />} />
            <Route path="/admin/report/book" element={<AdminBookReport />} />
            <Route
              path="/admin/report/comment"
              element={<AdminCommentReport />}
            />
            <Route
              path="/admin/challenge/create"
              element={<ChallengeCreaete />}
            />
            <Route path="/admin/notice/create" element={<NoticeCreate />} />
          </Routes>
        </BrowserRouter>
      </QueryClientProvider>
    </CookiesProvider>
  );
}

export default App;