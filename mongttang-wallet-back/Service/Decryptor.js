import CryptoJS from "crypto-js";
import { DECRYPTION_KEY } from "../config/index.js";

function decrypt(privateKeyEnc) {
  const decrypted = CryptoJS.AES.decrypt(privateKeyEnc, DECRYPTION_KEY);
  return decrypted;
}

export { decrypt };
