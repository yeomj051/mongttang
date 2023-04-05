import express from "express";
import { getAddress } from "../api/blockchain.js";

const router = express.Router();

router.get("/", (request, response) => {
  const query = request.query;
  const privateKey = decrypt(query.key);
  const address = getAddress(privateKey);
  response.send(address);
});

export default router;
