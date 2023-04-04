import express from "express";
import { withdraw } from "../api/blockchain.js";
import { create } from "ipfs-http-client";

// Node 에서는 require 이 뒤에 .js 를 붙이지 않아도 된다.

const router = express.Router();

const ipfs = create({
  host: "j8a308.p.ssafy.io",
  port: 5001,
  protocol: "http",
});

router.post("/ipfs", (request, response) => {
  let imageData = Buffer.from([]);
  console.log(request.data);
  request.on("data", (chunk) => {
    imageData = Buffer.concat([imageData, chunk]);
  });

  request.on("end", async () => {
    try {
      // Add the received image data to IPFS and get its CID
      console.log("업로드 시도중");
      console.log(Buffer.from(imageData));
      const { cid } = await ipfs.add(Buffer.from(imageData));
      console.log(`Image added to IPFS with CID ${cid}`);

      // Return the CID as a response to the client
      response.statusCode = 200;
      response.setHeader("Content-Type", "text/plain");
      response.end(cid);
    } catch (error) {
      console.error("Error adding image to IPFS:", error);
      response.statusCode = 500;
      response.end("Error adding image to IPFS");
    }
  });
});

router.post("/withdraw", (request, response) => {
  const body = request.body;
  console.log(request);
  withdraw(body.privateKey, body.tokenId, body.amount);
});

export default router;
