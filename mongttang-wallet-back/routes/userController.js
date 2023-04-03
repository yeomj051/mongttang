import express from "express";
import { getAddress } from "../api/blockchain.js";

const router = express.Router();

router.get("/", (request, response) => {
  const query = request.query;
  const address = getAddress(query.key);
  response.send(address);
});

export default router;
