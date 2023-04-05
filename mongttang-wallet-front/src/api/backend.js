import { createAPIInstance } from ".";

const apiInstance = createAPIInstance();

function getNFTList(address) {
  return apiInstance.get(`/nft?address=${address}`);
}

function getAddress(privateKey) {
  return apiInstance.get(`/user?key=${privateKey}`);
}

function withdraw(privateKey, tokenId, amount) {
  apiInstance.post("/nft/withdraw", {
    privateKey: privateKey,
    tokenId: tokenId,
    amount: amount,
  });
}

function buyMTT(privateKey, amount) {
  apiInstance.post("/token/buy", {
    privateKey: privateKey,
    amount: amount,
  });
}

function sellMTT(privateKey, amount) {
  apiInstance.post("/token/sell", {
    privateKey: privateKey,
    amount: amount,
  });
}
export { getNFTList, withdraw, buyMTT, sellMTT, getAddress };
