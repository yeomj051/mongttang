ERC-20은 Ethereum Request for Comment 20의 약자이다. 20은 리퀘스트 숫자다. 이더리움 네트워크의 개선안을 제안하는 EIPs(Ethereum Improvement Proposals)에서 관리하는 공식 프로토콜이다. 옆줄(-) 없이 'ERC20', 'ERC 20'이라고 쓰기도 한다. 이알씨이십, 이알씨이영, 이알씨이공, 이알씨트웨니 등으로 읽는다. ERC-20은 이더리움 블록체인 네트워크에서 정한 표준 토큰 스펙이다. 필요한 이더리움과 호환성이 있는 모든 요구 사항을 충족시키는 표준은 ERC-20으로 간주된다. ERC-20 토큰은 이더리움과 교환 가능하며 이더리움 지갑으로 전송이 가능하다.

ERC 721

NFT의 Standard. 대부분은 이 형식을 따름

ERC20. ERC721에 토큰id, 메타데이터json 파일이 추가된 형태

토큰ID NFT에 붙는 개별 식별 번호

메타데이터 JSON ⇒ NFT에 넣을 정보를 담는 그릇

IPFS = 분산 저장조. 위변조 불가능

블록체인 자체에 Image, Metadata를 넣으면 비싸니까 ipfs 사용

이번 NFT 테스트시 준비물

Remix IDE

Metamask

테스트용 이더리움

ERC721 소스코드

메타데이터 json 파일v

nft 이미지

Pinata 계정 (IPFS 사용하기 위해)

Alphawallet (NFT 이미지를 핸드폰에서 보고싶을 경우)

과정

1. 이미지를 ipfs에 올린다 → hash
2. metadata JSON 파일을 ipfs에 올린다 → hash
3. ERC721 민터 코드를 디플로이한다
4. NFT를 민트한다
5. Alphawallet에서 확인한다

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6daa7ada-eccb-4a1e-a6aa-304486de2187/Untitled.png)

ipfs:// 뒤에다가

pinata에서 얻어놨던 토큰id (CID) 넣고 create하면됨.

NFT에 등록된 이미지 정보 등임

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/931daed3-390c-4c8b-9de9-9fe4e4552f36/Untitled.png)

그담에 to에 보내려는 지갑주소넣고,

tokenURI에 생성하려는 NFT주소 넣고 transact누르면

하실거냐고 물어보는데, 한다고 하면됨.

Solidity의 modifier 와 payable

pragma solidity 0.4.11;
import "TokenFactory.sol"
contract CrowdSaleSample {
TokenFactory public token;
mapping   (address => uint256)  balances;
address public owner;
modifier onlyOwner {
require(msg.sender == owner);
_;
}
function FLToken(){
owner = msg.sender;
}
function() payable {
if (now > endBlock) throw;
token.distribute(msg.sender);
}
function distribute(address depositor) onlyOwner {
balances[depositor] +=  100;
}