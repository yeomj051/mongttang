# 2023-03-08 정리

## Figma를 통한 목업 작성

작품 상세 설명 페이지를 구상해보았다.
이번 주 내로 화면 디자인 및 목업 작성을 끝내는 것이 목표
![0308피그마](/uploads/471b2f7d60495c75ce793be525b7bee0/0308피그마.PNG)

## 현업 전문가 PJT 리뷰

조영도 전문가 님께서 프로젝트 리뷰를 해주셨다. 이하 리뷰를 거치면서 정리한 내용

프라이빗 네트워크의 경우 NFT의 가치가 퍼블릭에 비해 상대적으로 떨어지게 된다.(플랫폼에 NFT가 종속되기 때문)
컨테스트(챌린지) 방식으로 구성하게 된다면 투표를 통해서 상위권의 작품에게 NFT를 발행해주는 방식은 어떨지 싶음
비용적인 측면도 있고, 가치를 가지는 토큰이기 때문에 무작위적인 발행은 가치의 희소성을 떨어뜨린다고 생각함
저작권 보호만이 목적이면 우리 플랫폼을 통하지 않아도 됨.(이미 등록만 하면 되는 OpenSea와 같은 서비스가 있기 때문)
NFT의 가치가 부여되는 순간은 누가 NFT를 발행했는지가 핵심. 단순히 저작활동을 통해서 발행된 NFT와 본 플랫폼의 컨테스트를 통해 인증을 받은 NFT의 가치는 다르게 될 것. 또한 NFT가 실질적으로 저작권을 보호해줄 수는 없음.

### 사전질문1

원래는 NFT가 가리키는 메타데이터를 조작하게 설계되면 안된다. 하지만 실제로 이를 지키고 있는 서비스는 많지 않음. NFT 프로젝트를 참고할 때 주의할 것

### 사전질문 2

NFT는 저작권이나 지적 재산권과는 관련없음. 현재로서는 디지털 자산에 대한 소유권에 대한 인증서에 불과.

### 사전질문 3

할 수만 있다면 Sepolia 및 Goerli와 같은 테스트 서버라도 활용해보는 것이 좋다. 프라이빗 네트워크도 좋은 방안. 프라이빗에서 발행한 NFT를 퍼블릭 네트워크로 재배포를 하는 브릿지라는 기술이 있긴 하지만 프로젝트 진행에 있어서 가스비가 걸림돌이 되어서는 안되기 때문에 구현 가능성을 고려해 우선순위를 낮출 필요가 있다. 실제 회사의 경우 이더리움을 구매함

### 추가질문 1

자체지갑을 제공하고 싶다. 기존에 생각했던 것은 프라이빗 네트워크 상의 지갑을 만드는 것이었는데 퍼블릭 네트워크도 문제가 없는지?
퍼블릭 네트워크로 하는 것도 프라이빗과 큰 차이가 없고, 생성할 때 비용이 들지도 않음. 단 작가가 자기 지갑에 들어간 NFT를 다른 플랫폼에서도 사용할 수 있어야 하기 때문에 거래소 등에서 제공하는 중앙형 지갑과는 다르게 구성해야 할 수도 있다.
작가의 작품에 대한 권리를 좀더 중요시한다면 진입장벽을 고려하더라도 탈중앙형 지갑, 사용성을 좀더 중요시한다면 중앙형 지갑으로의 방향을 생각해볼 법하다.

이후 제안해주신 아이디어를 고려해서 챌린지에서 상위권 성적을 기록한 작품에 대해서만 NFT를 발급하는 방식으로 바꾸려는 방안을 검토중.

# 2023-03-09 정리

Figma를 통한 목업 작업을 이어서 하는 중이다. 주요 화면 구성 디자인은 밀리의 서재, 리디북스, 카카오페이지, 네이버웹툰, Storybird 등을 참고했다.

뷰어랑 에디터 부분이 실질적으로 메인 기능을 맡게 될 가능성이 높기 때문에 구현 방향에 대해서 여러모로 조사중이다.

![뷰어_에디터](/uploads/f8b19e68912d8223705523d314947518/뷰어_에디터.PNG)
![에디터_내부](/uploads/093065d22e17013e8ff907181fd17de5/에디터_내부.PNG)

# 2023-03-10 정리

전날에 이어 목업 작업을 계속했고, 관리자 페이지를 제외한 목업은 거의 완성했다.
다음주 시작 전까지 프론트엔드 개발환경 세팅을 마치고 개발에 착수할 예정이다.

![ahrdjq](/uploads/a4ada04a3df61867c66bb2b9da566205/ahrdjq.PNG)
![미니프로필](/uploads/65c9e608553d5525ae0f0437d1c05a21/미니프로필.PNG)

# 2023-03-13 정리

목업 작업을 오늘 중에 마무리하려 했으나, 완벽하게 끝내지는 못했다(세부적인 디자인만 남은 상태). 공지사항 및 추후에 쓸 수도 있는 크라우드 펀딩 페이지에 대한 목업을 작성했고, 일부 화면을 수정했다.

백엔드팀과 함께 API 명세서를 검토하고 수정했으며, 이후 API 주소를 연결하기 위한 config.js 파일을 작성 중이다.

![API](/uploads/8bca25ba044216415181ab11c7ebe36d/API.PNG)
![FIGMA1](/uploads/bfae90fcfa616e22911ec0cdc3d3bafa/FIGMA1.PNG)

# 2023-03-14 정리

프론트엔드 개발환경 세팅을 완료하고 본격적으로 개발에 착수했다.

### 로그인 화면 개발

사진에는 보이지 않지만 배경 나뭇잎이 움직이는 CSS 애니메이션을 구현했다
현재 소셜로그인 관련 백엔드 API가 완성되면 바로 테스트해볼 수 있도록 기능구현까지는 완료된 상태
![dhsmf](/uploads/5619fe85f800c1834554e4e59d812f41/dhsmf.PNG)

# 2023-03-15 정리

### 로그인 화면 개발

- 액세스 토큰 만료됐을 때 리프레시 토큰을 통한 재발급 기능 구현
- 유저정보 전역 관리를 위한 userStore.js 추가
- 로그인 관련 API 연결
- 소셜로그인 이후 리다이렉트 URL 및 유저정보 저장 기능 구현

### 공지사항 화면 개발

- 공지사항 목록 조회 API와 연결해서 리스트 받아오는 기능 구현
- 아직 띄워진 화면은 없음

# 2023-03-16 정리

### 팀 회의

아침에 또다시 회의를 했다. 바뀐 기획에 맞춰 명세서를 수정하기 위함. 오래된 명세를 수정하면서 블록체인 관련해서 서로 달랐던 개념을 맞추는데 많은 시간을 할애했다.

### 공지사항 페이지 완료

팀원이 작업하고 있는 헤더부분 컴포넌트가 완료되면 씌우기만 하면 된다

**작업하면서 배운 부분**

React에서는 String 내부에서 텍스트 개행문자인 \n이 자동적으로 적용이 안된다.

적용을 위해서는 css에서 white-space: pre 속성을 적용해줘야 한다.

pre, pre-line, pre-wrap 3가지 바리에이션이 있는데 기존과의 차이점은 아래 이미지와 같다.

**기존(normal)**

![normal](/uploads/c916faf2739359d88470e44e2b008548/normal.PNG)

**pre-line**

![pre-line](/uploads/33c55743106eef892f11c196e25770b5/pre-line.PNG)

**pre-wrap**

![pre-wrap](/uploads/3ac32236e267272459d6f56415a2521a/pre-wrap.PNG)

`noticeContent.replace(/\r\n/gi, '<br>')` 와 같이 정규식을 활용해 개행문자가 있으면 br 태그로 실제 화면에서도 개행이 되도록 처리했다.

그 외에 css 작업을 styled component를 활용해서 진행했고, em, rem등 반응형 웹페이지를 위한 단위를 써서 화면이 작아져도 같은 비율을 유지하도록 작업했다.

공지사항 내용의 경우 더미데이터를 넣어서 테스트해본 결과 API 구현 자체에는 문제가 없음을 확인했다. 나중에 백엔드와 연결하는 작업만 처리하면 될듯 하다.

### 모달창

모달 컴포넌트를 만들었다.

모달 외부를 클릭하면 모달창이 꺼지는 기능과, 외부 스크롤을 방지하는 기능까지 구현했다

```
function Modal({ onClose, children }) {
  const modalRef = useRef(null);
  const handleClose = () => {
    onClose?.();
  };

  //모달 외부 클릭시 모달창 꺼짐
  useOutsideClick(modalRef, handleClose);

  //외부 스크롤 방지
  useEffect(() => {
    const $body = document.querySelector('body');
    const overflow = $body.style.overflow;
    $body.style.overflow = 'hidden';
    return () => {
      $body.style.overflow = overflow;
    };
  }, []);

  return (
    <ModalOverlay>
      <ModalWrapper ref={modalRef}>
        <ContentWrapper>{children}</ContentWrapper>
      </ModalWrapper>
    </ModalOverlay>
  );
}
```

외부스크롤 방지를 위한 커스텀훅 useOutsideClick은 다음과 같다

```
function useOutsideClick(ref, callback) {
  useEffect(() => {
    const handleClick = (event) => {
      if (ref.current && !ref.current.contains(event.target)) {
        callback?.();
      }
    };

    window.addEventListener("mousedown", handleClick);

    return () => window.removeEventListener("mousedown", handleClick);
  }, [ref, callback]);
}
```

모달창 컴포넌트를 활용해 로그아웃 모달창을 구현하였고, API 연결까지 완료하였다.

# 2023-03-17 정리

팀 중간발표를 및 평가를 진행했다.

### 회원탈퇴 모달창 및 API 구현

프론트엔드 단에서 로그아웃과 기능상 다른 점이 무엇이 있을까 생각해봤는데 없는듯 싶다.
있다면 리다이렉트할 주소의 차이 아닐까

![탈퇴](/uploads/6c70abb81b5c202a7a15f5d7e53b3782/탈퇴.PNG)

# 2023-03-20 정리

### 메인화면 컴포넌트 구현

메인화면을 구성할 동화책, 타이머, 책 선반, 챌린지 상세정보 컴포넌트를 만들었다.

메인화면 구성요소(컴포넌트)는 거의 다 구현했기 때문에 내일 오전 중으로 메인화면 개발을 끝낼 예정이다.

### 이미지 위에 텍스트 덮는 방법

이미지와 텍스트를 감싸는 wrap 요소에 position:relativ를 부여하고, text요소에 position:absolute를 추가해주면 된다. 단, 위치값을 일일히 수정해줘야한다는 단점이 있다.

![todaycommit](/uploads/65bf7bb1eb557c1877ec33a765fc4435/todaycommit.PNG)

# 2023-03-21 정리

## 챌린지 관련 화면 구현

이전 챌린지, 챌린지 상세 모두 메인 화면과 큰 차이가 없었다. 만들면서 padding 수치 등도 수정했다.

![이전_챌린지](/uploads/0b4dd8efb166ea2b628bf9717312f6bc/이전_챌린지.PNG)
![챌린지_상세1](/uploads/aae55f3e7cf5aa76ad957b506d539642/챌린지_상세1.PNG)
![챌린지_상세2](/uploads/cb1a915960db5421323d2dc0f4318191/챌린지_상세2.PNG)

## 프로필 모달 구현

생각보다 필요한 API가 많아서 렌더링할 화면까지는 없고, API 연동해서 기능만 구현한 상태

### LocalStorage vs ContextAPI(or Redux..이하 상태관리툴)

문득 개발하다가 든 생각이었다. user 정보를 담은 user state는 새로고침을하면 사라지는데 그냥 모든 state를 localstorage로 관리하면 안되나? 하는 생각

조사해본 바 localstorage는 느리고, state가 변화되어도 해당 state를 사용하는 컴포넌트들에 state를 공유하지 않는다. 즉 화면이 다시 렌더링이 되지 않는다.

그렇기에 일반적으로 localstorage는 사용자 설정, 테마, 인증 토큰과 같은 세션 기능에 사용된다.(자주 변화하지 않는 정적인 상태)

그리고 애플리케이션 시작 시에 localstorage에서 정보를 읽어와서 관련 state를 업데이트하는 방식이 일반적

결론은 둘다 사용해야한다는것

# 2023-03-22 정리

### 많이 쓰게되는 CSS 정리

display: flex (tw에선 flex)

기본 정렬은 flex-row → div 내 아이템들이 가로(row)로 정렬

flex-col로 하면 세로로 정렬

align-items (tw에선 items-) : div의 중심가로축을 기준으로 아이템 정렬

justify-content(tw에선 justify-) : div의 중심축(flex 정렬방향에 따라 다름)을 기준으로 아이템 정렬

### 트러블 슈팅

input태그는 한 줄로밖에 입력을 받지 못한다(줄바꿈이 안됨)

입력폼에서 줄바꿈을 하고싶으면 textarea를 사용합시다

[input tag 개행(줄바꿈) 안 될 때는 textarea tag로](https://sezzled.tistory.com/166)

### react-query를 사용한 서버 데이터 동기화

좋아요를 누르면 백엔드에서 좋아요 수를 받아와서 표시하게 하고싶다

때문에 react query를 써서 구현을 해보았다

```jsx
//좋아요 수 가져오기
const { status, data, error } = useQuery(
 "getlikes",
 authApi(requests.GET_BOOK_DETAIL(userId, bookId))
);

//좋아요 누르면 실행
const likesMutation = useMutation(
 authApi(requests.POST_BOOKLIKE(userId, bookId)),
 {
  onSuccess: () => {
   queryClient.setQueryData("getlikes");
  },
 }
);

const dislikesMutation = useMutation(
 authApi(requests.DELETE_BOOKLIKE(userId, bookId)),
 {
  onSuccess: () => {
   queryClient.setQueryData("getlikes");
  },
 }
);
```

사실 좋아요를 누르면 보내는 POST 요청에서 response 값에 새로 업데이트 된 좋아요 수를 백엔드에서 보내주면 간단하게 처리될 일이지만, 프론트엔드에서 해당 로직을 구현한다면 이런 식으로 처리할 수 있지 않을까 생각해봤다.
