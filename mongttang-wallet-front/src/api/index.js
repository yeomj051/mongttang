import axios from "axios";
import { API_BASE_URL } from "../config/index.env";

function createAPIInstance() {
  const instance = axios.create({
    baseURL: API_BASE_URL,
    headers: {
      "Content-Type": "application/json",
      Authorization: "",
    },
  });
  return instance;
}

export { createAPIInstance };
