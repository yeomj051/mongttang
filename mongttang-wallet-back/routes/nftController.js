import express from "express";
import { getNFTList, withdraw } from "../api/blockchain.js";
// Node 에서는 require 이 뒤에 .js 를 붙이지 않아도 된다.

const router = express.Router();

router.get("/", (request, response) => {
  const query = request.query;
  getNFTList(query.address)
    .then((res) => {
      const json = {
        nftIds: res[0],
        nftBalances: res[1],
        nftTotalEarneds: res[2],
      };
      response.send(json);
    })
    .catch(console.error);
});

router.post("/withdraw", (request, response) => {
  const body = request.body;
  console.log(request);
  withdraw(body.privateKey, body.tokenId, body.amount);
});

export default router;
