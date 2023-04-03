import express from "express";
import { getNFTList, withdraw } from "../api/blockchain.js";

const router = express.Router();

router.post("/withdraw", (request, response) => {
  const body = request.body;
  withdraw(body.privateKey, body.tokenId, body.amount);
});

export default router;
