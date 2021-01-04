<template>

<Header/>

<div class="functions">

  <Menu/>

  <a-radio-group name="radioGroup" v-model:value="value">
    <a-radio value="1">
      列表播放
    </a-radio>
    <a-radio value="2">
      单曲循环
    </a-radio>
    <a-radio value="3">
      列表循环
    </a-radio>
    <a-radio value="4">
      乱序播放
    </a-radio>
  </a-radio-group>
</div>

  <Player/>


</template>

<script>

import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'

export default {
  name: 'About',
  components: {
    Header,
    Menu,
    Player
  },
    data() {
    return {
      value: '1',
    };
  },
}
</script>

<style scoped>

.functions{
  display: flex;
  text-align: left;
  line-height: 20px;
  width:100%;
  .content{
    flex:1;
  }
}

</style>