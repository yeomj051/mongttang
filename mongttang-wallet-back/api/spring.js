import { createAPIInstance } from "./index.js";

const apiInstance = createAPIInstance();

function postNFTID(bookId, nftId) {
  apiInstance.post("/book/token", {
    bookId: bookId,
    nftId: nftId,
  });
}

export { postNFTID };
