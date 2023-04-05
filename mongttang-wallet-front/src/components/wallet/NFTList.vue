<template>
  <hr />
  <h2 class="title">내 NFT 목록</h2>
  <div class="container" v-for="(nftId, idx) in nftIds" :key="nftId">
    <div class="row">
      <div class="col"></div>
      <div class="col">
        <img
          src="https://mblogthumb-phinf.pstatic.net/MjAyMTAxMDVfMjE5/MDAxNjA5ODA0NDYxODAx.ieWcq6luZGB9apxLjS_uh-ROYCQS61ubqCW_pA2fTrMg.Zx56vtprvTOoc0sn9oy7eyWGj8TXXlpClSEoWFehQnMg.PNG.bluelaz1103/SE-c3e732d3-5ceb-423f-bbb7-26cf288fe3e0.png?type=w800"
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
          class="pointer"
          src="@/assets/withdraw.png"
          data-bs-toggle="modal"
          data-bs-target="#withdrawModal"
          v-on:click="doWithdraw(nftId, nftBalances[idx])"
        />
        <br />
      </div>
      <div class="col"></div>
    </div>
    <hr />
  </div>

  <!-- 출금 Modal -->
  <div
    class="modal fade"
    id="withdrawModal"
    tabindex="-1"
    aria-labelledby="withdrawModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="withdrawModalLabel">
            출금 요청이 신청되었습니다.
          </h1>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          블록체인의 특성상, 출금이 반영되기까지 시간이 다소 걸릴 수 있습니다.
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-bs-dismiss="modal">
            확인
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { withdraw } from "@/api/backend";
import { getNFTList } from "@/api/blockchain";

export default {
  name: "NFTList",
  data() {
    return {
      nftIds: [],
      nftBalances: [],
      nftTotalEarneds: [],
      cat: "",
    };
  },
  computed: {
    privateKey() {
      return this.$store.getters.getPrivateKey;
    },
    address() {
      return this.$store.getters.getAddress;
    },
  },
  created() {
    getNFTList(this.address).then((res) => {
      this.nftIds = res[0];
      this.nftBalances = res[1];
      this.nftTotalEarneds = res[2];
    });
  },
  methods: {
    doWithdraw(tokenId, amount) {
      const encoded = encodeURIComponent(this.privateKey);
      withdraw(encoded, tokenId, amount);
    },
  },
};
</script>
