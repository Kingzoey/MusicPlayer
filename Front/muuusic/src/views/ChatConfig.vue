<template>

<Header/>

<div class="functions">

  <Menu/>

  <div v-if="dark">
  <a-button @click="changeTheme" ghost>切换详略</a-button>
  <a-button @click="initialTheme" ghost>切换提示</a-button>
  <br/>
  </div>
  <div  v-else>
  <a-button @click="changeTheme">切换详略</a-button>
  <a-button @click="initialTheme">切换提示</a-button>
  <br/>
  </div>

</div>

    <div class="container">
      <div class="box"></div>
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
  data(){
    return {
    dark: false,
    badgecolor:'red'
    };
  },
  created(){
  this.dark=this.$store.state.dark;
  },
  methods:{
    changebadgecolor(){

    }
  }
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