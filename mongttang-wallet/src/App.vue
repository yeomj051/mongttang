<template>
  <router-view />
</template>

<script>
export default {
  created() {
    const URLSearch = new URLSearchParams(location.search);
    const privateKey = URLSearch.get(`key`);
    console.log(privateKey);
    this.$store.commit("SET_PRIVATEKEY", privateKey);
    console.log("asegaswehgashash" + this.$store.state.privateKey);
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
