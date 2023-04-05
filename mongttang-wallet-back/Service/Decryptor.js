import CryptoJS from "crypto-js";
import { DECRYPTION_KEY, DECRYPTION_IV } from "../config/index.js";

function decrypt(privateKeyEnc) {
  privateKeyEnc =
    "9/YRpHd6o/oDZwGJrSjsWFx6CEOqisE7i4HPHaLQvV7US+1TuYrOwA4GmzlWYk84ARS8itf+tww9h7vDmdnauuel6RbsMwtCv3+odgxO7HI=";
  const key = CryptoJS.enc.Utf8.parse(DECRYPTION_KEY);
  const iv = CryptoJS.enc.Utf8.parse(DECRYPTION_IV);

  const decryptedBytes = CryptoJS.AES.decrypt(privateKeyEnc, key, {
    iv: iv, // Pass the IV for CBC mode
    mode: CryptoJS.mode.CBC, // Set the mode to CBC
    padding: CryptoJS.pad.Pkcs7, // Set the padding to Pkcs7
  });
  const decryptedString = decryptedBytes.toString(CryptoJS.enc.Utf8);
  return decryptedString;
}

export { decrypt };
