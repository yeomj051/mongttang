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

function getMTTBalance(privateKey) {
  return apiInstance.get(`/token/mtt?key=${privateKey}`);
}

function getSSFBalance(privateKey) {
  return apiInstance.get(`/token/ssf?key=${privateKey}`);
}

function transferSSF(privateKey, toAddress, amount) {
  apiInstance.post("/token/ssf", {
    privateKeyEnc: privateKey,
    toAddress: toAddress,
    amount: amount,
  });
}
export {
  getNFTList,
  withdraw,
  buyMTT,
  sellMTT,
  getAddress,
  getMTTBalance,
  getSSFBalance,
  transferSSF,
};
