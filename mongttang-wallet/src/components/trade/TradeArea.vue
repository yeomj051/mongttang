<template>
    <div class="trade-area">
        <!--구입, 판매 상단메뉴-->
        <ul class="top-area">
            <li class="tab-buy">
                <span class="tab-menu">구입</span>
            </li>
            <li class="tab-sell">
                <span class="tab-menu">판매</span>
            </li>
        </ul>
        <!--상단메뉴 선택에 따라 구입, 판매메뉴 컴포넌트 변경-->
        <BuyMenu></BuyMenu>
    </div>
</template>
<script>
import BuyMenu from '@/components/trade/BuyMenu.vue';

export default {
    name: "TradeArea",
    components: {
        BuyMenu,
    },
}
</script>
<style>
.trade-area {
    margin: auto;
    width: 500px;
    height: 500px;
    border: 1px solid black;
}
.top-area {
    padding: 0px;
    display: flex;
    height: 50px;
    list-style: none;
}
li {
    position: relative;
    width: 50%;
    height: 100%;
}
.tab-menu {
    font-size: 20px;
    position: absolute;
    left: 45%;
    top: 30%;
    text-align: center;
    font-weight: bold;
}
</style>