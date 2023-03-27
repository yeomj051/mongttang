<template>
    <h2>
      NFT
    </h2>
    <div v-for="(nftId, idx) in nftIds" :key="nftId">
      <img src="http://dd93ub3tw0bvd.cloudfront.net/books/1/2/page0" width="200"/>
      <div>
        <div>
        토큰 : {{ nftId }}
        </div>
        <div>
          현재 잔액 : {{ nftBalances[idx] }}
        </div> 
        <div>
          총 수익 금액 : {{ nftTotalEarneds[idx] }}
        </div>       
        <button type="button" class="btn btn-primary">출금하기</button>
      </div>
        
    </div>
  </template>
  
  <script>
  import { getNTFList } from '@/api/blockchain';
  
  export default {
    name: 'NFTList',
    data(){
      return{
        nftIds : [],
        nftBalances : [],
        nftTotalEarneds : []
      }
    },
    created(){
      getNTFList()
      .then(res => {
        console.log(res);
        this.nftIds = res[0];
        this.nftBalances = res[1];
        this.nftTotalEarneds = res[2];        
      });
    },
  }
  </script>
