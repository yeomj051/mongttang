<template>
  <TokenBalance></TokenBalance>
  <NFTList></NFTList>
</template>

<script>
import TokenBalance from '@/components/wallet/TokenBalance.vue';
import NFTList from '@/components/wallet/NFTList.vue';

export default {
  name: 'WalletView',

  components: {
    TokenBalance,
    NFTList,
  }
}
</script>
