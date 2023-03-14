/**
 * 카카오/구글 로그인 이후 redirect uri로 연결할 페이지
 * 여기서 response data를 처리하고 메인 페이지로 연결한다
 */
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom/dist';

function SocialLogin() {
  const navigate = useNavigate();

  const userId = new URL(window.location.href).searchParams.get('userId');
  const userNickname = new URL(window.location.href).searchParams.get(
    'nickname',
  );
  const accessToken = new URL(window.location.href).searchParams.get(
    'accessToken',
  );
  const refreshToken = new URL(window.location.href).searchParams.get(
    'refreshToken',
  );

  localStorage.setItem('userId', userId);
  localStorage.setItem('userNickname', userNickname);
  localStorage.setItem('accessToken', accessToken);
  //refreshToken 저장 로직(임시)
  localStorage.setItem('refreshToken', refreshToken);

  useEffect(() => {
    navigate('/');
  }, []);
}

export default SocialLogin;
