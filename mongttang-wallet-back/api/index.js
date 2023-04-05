import { BLOCKCHAIN_URL } from "../config/index.js";
import Web3 from "web3";

function createRPCInstance() {
  const web3 = new Web3(new Web3.providers.HttpProvider(`${BLOCKCHAIN_URL}`));
  return web3;
}

function createAccount() {
  const web3 = new Web3(new Web3.providers.HttpProvider(`${BLOCKCHAIN_URL}`));
  const account = web3.eth.accounts.create();
  console.log(account);
}

export { createRPCInstance, createAccount };
