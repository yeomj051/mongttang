<template>
  <hr />
  <h2 class="title">내 NFT 목록</h2>
  <div class="container" v-for="(nftId, idx) in nftIds" :key="nftId">
    <div class="row">
      <div class="col"></div>
      <div class="col">
        <img
          src="http://dd93ub3tw0bvd.cloudfront.net/books/1/2/page0"
          width="200"
        />
      </div>
      <div class="col">
        <!-- <div>토큰 : {{ nftId }}</div> -->
        <br />
        <div class="money">현재 잔액 : {{ nftBalances[idx] }}</div>
        <div class="money">총 수익 금액 : {{ nftTotalEarneds[idx] }}</div>
        <br />
        <img
          src="@/assets/withdraw.png"
          v-on:click="doWithdraw(nftId, nftBalances[idx])"
        />
        <br />
      </div>
      <div class="col"></div>
    </div>
    <hr />
  </div>
</template>

<script>
import { getNFTList, withdraw } from "@/api/blockchain";
import { createRPCInstance } from "@/api";

export default {
  name: "NFTList",
  data() {
    return {
      nftIds: [],
      nftBalances: [],
      nftTotalEarneds: [],
    };
  },
  computed: {
    privateKey() {
      return this.$store.state.privateKey;
    },
  },
  created() {
    const rpcInstance = createRPCInstance();
    const userAccount = rpcInstance.eth.accounts.privateKeyToAccount(
      this.privateKey
    );
    console.log("userAddress : " + userAccount.address);
    getNFTList(userAccount.address)
      .then((res) => {
        this.nftIds = res[0];
        this.nftBalances = res[1];
        this.nftTotalEarneds = res[2];
      })
      .catch(console.error);
  },
  methods: {
    doWithdraw(tokenId, amount) {
      withdraw(tokenId, amount);
    },
  },
};
</script>
