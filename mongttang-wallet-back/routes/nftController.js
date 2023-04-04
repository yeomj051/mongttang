import express from "express";
import { withdraw } from "../api/blockchain.js";
import { create } from "ipfs-http-client";
import multer from "multer";

// Node 에서는 require 이 뒤에 .js 를 붙이지 않아도 된다.

const router = express.Router();

const ipfs = create({
  host: "j8a308.p.ssafy.io",
  port: 5001,
  protocol: "http",
});
const upload = multer();

router.post("/ipfs", upload.array("images", 20), async (request, response) => {
  try {
    // Extract the image data from the request
    const imageData = request.files.map((file) => file.buffer);
    const body = request.body;

    // Add the received image data to IPFS and get their CIDs
    console.log("업로드 시도중");
    const cidPromises = imageData.map((data) => ipfs.add(data));
    const cids = await Promise.all(cidPromises);
    const cidStrings = cids.map((cid) => cid.cid.toString());
    console.log(`Images added to IPFS with CIDs ${cidStrings}`);

    const metadata = {
      name: `${body.title}`,
      image: `https://ipfs.io/ipfs/${cidStrings[0]}`,
      description: "몽땅연필에서 제작된 동화입니다.",
      attributes: [],
    };

    for (let i = 0; i < cidStrings.length; i++) {
      metadata.attributes.push({
        trait_type: `page : ${i + 1}`,
        image: `https://ipfs.io/ipfs/${cidStrings[i]}`,
      });
    }

    const jsonString = JSON.stringify(metadata);
    const jsonBuffer = Buffer.from(jsonString);
    const metadataCid = await ipfs.add(jsonBuffer);
    console.log(metadata);
    console.log(metadataCid);

    // Return the CIDs as a response to the client
    response.statusCode = 200;
    response.setHeader("Content-Type", "text/plain");
    response.write(metadataCid);
    response.end(cidStrings.join(","));
  } catch (error) {
    console.error("Error adding images to IPFS:", error);
    response.statusCode = 500;
    response.end("Error adding images to IPFS");
  }
});

router.post("/withdraw", (request, response) => {
  const body = request.body;
  console.log(request);
  withdraw(body.privateKey, body.tokenId, body.amount);
});

export default router;
