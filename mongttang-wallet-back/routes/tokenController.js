import express from "express";
import { buyMTT } from "../api/blockchain.js";

const router = express.Router();

router.post("/buy", (request, response) => {
  const body = request.body;
  buyMTT(body.privateKey, body.amount);
});

router.post("/sell", (request, response) => {
  const body = request.body;
  sellMTT(body.privateKey, body.amount);
});

export default router;
