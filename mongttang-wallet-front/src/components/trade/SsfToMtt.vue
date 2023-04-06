<template>
  <div>
    <div class="row trade-choice">
      <div class="col-5">
        <img src="../../assets/MonttangCoin.png" class="token-icon" />몽땅토큰
        100개
      </div>
      <div class="col-3"></div>
      <div class="col-4">
        <img class="pointer clickable" v-on:click="buy(100)" src="@/assets/1SSF.png" />
      </div>
    </div>
    <div class="row trade-choice">
      <div class="col-5">
        <img src="../../assets/MonttangCoin.png" class="token-icon" />몽땅토큰
        200개
      </div>
      <div class="col-3"></div>
      <div class="col-4">
        <img class="pointer clickable" v-on:click="buy(200)" src="@/assets/2SSF.png" />
      </div>
    </div>
    <div class="row trade-choice">
      <div class="col-5">
        <img src="../../assets/MonttangCoin.png" class="token-icon" />몽땅토큰
        500개
      </div>
      <div class="col-3"></div>
      <div class="col-4">
        <img class="pointer clickable" v-on:click="buy(500)" src="@/assets/5SSF.png" />
      </div>
    </div>
    <div class="row trade-choice">
      <div class="col-5">
        <img src="../../assets/MonttangCoin.png" class="token-icon" />몽땅토큰
        1000개
      </div>
      <div class="col-3"></div>
      <div class="col-4">
        <img class="pointer clickable" v-on:click="buy(1000)" src="@/assets/10SSF.png" />
      </div>
    </div>
    <div class="row trade-choice">
      <div class="col-5">
        <img src="../../assets/MonttangCoin.png" class="token-icon" />몽땅토큰
        10000개
      </div>
      <div class="col-3"></div>
      <div class="col-4">
        <img
          class="pointer clickable"
          v-on:click="buy(10000)"
          src="@/assets/100SSF.png"
        />
      </div>
    </div>
  </div>
</template>
<script>
import { buyMTT, getMTTBalance, getSSFBalance } from "@/api/backend";

export default {
  computed: {
    privateKey() {
      return this.$store.getters.getPrivateKey;
    },
    ssf() {
      return this.$store.getters.getSsf;
    },
    mtt(){
      return this.$store.getters.getMtt;
    }
  },
  methods: {
    buy(amount) {
      if(this.ssf >= amount){
        buyMTT(this.privateKey, amount)
        .then((res)=>{
          if(res){
            window.alert("거래가 완료되었습니다.");
            getMTTBalance(this.privateKey).then((response) => {
              console.log(response);
              this.$store.commit("SET_MTT", response.data);
            });
            getSSFBalance(this.privateKey).then((response) => {
              console.log(response);
              this.$store.commit("SET_SSF", response.data);
            });
          }else{
            window.alert("거래가 실패하였습니다.");
          }
        });
      }else{
        window.alert("SSF 잔액이 부족합니다.");
      }
    },
  },
};
</script>
<style>
.trade-choice {
  margin-bottom: 15px;
}
.buy-button {
  margin-top: 5px;
  color: #ffffff;
  border-style: none;
  background-color: #00d8ff;
}
.clickable:active{
  filter: opacity(0.5) drop-shadow(0 0 0 #ff0000);
}
</style>
