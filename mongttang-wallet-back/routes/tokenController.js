import express from "express";
import {
  buyMTT,
  sellMTT,
  getMTTBalance,
  getSSFBalance,
  approve,
  transferMTT,
  getAddress,
  deposit,
} from "../api/blockchain.js";
import { OWNER_PRIVATE_KEY, NFT_CONTRACT_ADDRESS } from "../config/index.js";
import { decrypt } from "../Service/Decryptor.js";
OWNER_PRIVATE_KEY;

const router = express.Router();

router.get("/mtt", (request, response) => {
  const query = request.query;
  const privateKey = decrypt(query.key);
  const address = getAddress(privateKey);
  const balance = getMTTBalance(address);
  response.send(balance);
});

router.get("/ssf", (request, response) => {
  const query = request.query;
  const privateKey = decrypt(query.key);
  const address = getAddress(privateKey);
  const balance = getSSFBalance(address);
  response.send(balance);
});

router.post("/buy", (request, response) => {
  const body = request.body;
  const privateKey = decrypt(body.privateKeyEnc);
  buyMTT(privateKey, body.amount);
});

router.post("/sell", (request, response) => {
  const body = request.body;
  const privateKey = decrypt(body.privateKeyEnc);
  sellMTT(privateKey, body.amount);
});

router.post("/read", (request, response) => {
  const body = request.body;
  const tokenId = body.tokenId;
  const amountToAuthor = body.amountToAuthor;
  const amountToManager = body.amountToManager;
  const privateKey = decrypt(body.privateKeyEnc);
  const managerAddress = getAddress(OWNER_PRIVATE_KEY);
  transferMTT(privateKey, managerAddress, amountToAuthor + amountToManager)
    .then(() => {
      approve(OWNER_PRIVATE_KEY, NFT_CONTRACT_ADDRESS, amountToAuthor);
    })
    .then(() => {
      deposit(OWNER_PRIVATE_KEY, tokenId, amountToAuthor);
    })
    .catch((error) => {
      console.log(error);
      response.statusCode = 500;
      response.end("Purchasing book failed. Error log : ", error);
    });
});

export default router;
