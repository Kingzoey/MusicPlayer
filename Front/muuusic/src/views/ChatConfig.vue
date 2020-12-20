<template>

<Header/>

<div class="functions">

  <Menu/>

  <div v-if="dark">
  <a-button @click="changeTheme" ghost>切换详略</a-button>
  <a-button @click="initialTheme" ghost>切换提示</a-button>
  <br/>
  <a-button @click="changebadgecolor('#bfbfbf')" ghost>中性灰</a-button>
  <a-button @click="changebadgecolor('#2f54eb')" ghost>极客蓝</a-button>
  <a-button @click="changebadgecolor('#722ed1')" ghost>酱紫</a-button>
  <a-button @click="changebadgecolor('#eb2f96')" ghost>法式洋红</a-button>
  <a-button @click="changebadgecolor('#52c41a')" ghost>极光绿</a-button>
  <a-button @click="changebadgecolor('#13c2c2')" ghost>明青</a-button>
  <a-button @click="changebadgecolor('#1890ff')" ghost>拂晓蓝</a-button>
  <a-button @click="changebadgecolor('#faad14')" ghost>金盏花</a-button>
  <a-button @click="changebadgecolor('#fadb14')" ghost>日出</a-button>
  <a-button @click="changebadgecolor('#a0d911')" ghost>青柠</a-button>
  <a-button @click="changebadgecolor('#fa8c16')" ghost>薄暮</a-button>
  <a-button @click="changebadgecolor('#fa541c')" ghost>日暮</a-button>
  <a-button @click="changebadgecolor('#f5222d')" ghost>火山</a-button>
  </div>
  <div  v-else>
  <a-button @click="changeTheme">切换详略</a-button>
  <a-button @click="initialTheme">切换提示</a-button>
  <br/>
  <a-button @click="changebadgecolor('#bfbfbf')">中性灰</a-button>
  <a-button @click="changebadgecolor('#2f54eb')">极客蓝</a-button>
  <a-button @click="changebadgecolor('#722ed1')">酱紫</a-button>
  <a-button @click="changebadgecolor('#eb2f96')">法式洋红</a-button>
  <a-button @click="changebadgecolor('#52c41a')">极光绿</a-button>
  <a-button @click="changebadgecolor('#13c2c2')">明青</a-button>
  <a-button @click="changebadgecolor('#1890ff')">拂晓蓝</a-button>
  <a-button @click="changebadgecolor('#faad14')">金盏花</a-button>
  <a-button @click="changebadgecolor('#fadb14')">日出</a-button>
  <a-button @click="changebadgecolor('#a0d911')">青柠</a-button>
  <a-button @click="changebadgecolor('#fa8c16')">薄暮</a-button>
  <a-button @click="changebadgecolor('#fa541c')">日暮</a-button>
  <a-button @click="changebadgecolor('#f5222d')">火山</a-button>
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