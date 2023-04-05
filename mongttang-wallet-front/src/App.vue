<template>
  <router-view />
</template>

<script>
import { getAddress } from "@/api/backend";

export default {
  created() {
    const URLSearch = new URLSearchParams(location.search);
    const privateKey = URLSearch.get(`key`);
    console.log(privateKey);
    this.$store.commit("SET_PRIVATEKEY", privateKey);

    const userAddress = getAddress(encodeURIComponent(privateKey))
      .then((req) => {
        console.log("여깁니다");
        console.log(req.data);
        console.log(userAddress);
        this.$store.commit("SET_ADDRESS", userAddress);
      })
      .catch((err) => {
        console.log("저깁니다");
        console.log(err);
      });
  },
};
</script>

<style>
@font-face {
  font-family: "GangwonEdu_OTFBoldA";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEdu_OTFBoldA.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}
.title {
  color: #34bbbb;
}
#app {
  font-family: "GangwonEdu_OTFBoldA";
  text-align: center;
}
</style>
