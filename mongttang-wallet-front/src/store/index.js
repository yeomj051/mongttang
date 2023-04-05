import { createStore } from "vuex";

export default createStore({
  state: {
    privateKey: "",
    address: "",
  },
  getters: {
    getPrivateKey(state) {
      return state.privateKey;
    },
    getAddress(state) {
      return state.address;
    },
  },
  mutations: {
    SET_PRIVATEKEY(state, privateKey) {
      state.privateKey = privateKey;
    },
    SET_ADDRESS(state, address) {
      state.address = address;
    },
  },
  actions: {},
});
