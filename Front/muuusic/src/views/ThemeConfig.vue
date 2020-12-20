<template>

<Header/>

<div class="functions">

  <Menu/>

  <div class="colors" v-if="dark">
  <a-button @click="changeTheme" ghost>切换主题</a-button>
  <a-button @click="initialTheme" ghost>切换原版</a-button>
  <br/>
  <a-button @click="updatePrimaryColor('#bfbfbf')" ghost>中性灰</a-button>
  <a-button @click="updatePrimaryColor('#2f54eb')" ghost>极客蓝</a-button>
  <a-button @click="updatePrimaryColor('#722ed1')" ghost>酱紫</a-button>
  <a-button @click="updatePrimaryColor('#eb2f96')" ghost>法式洋红</a-button>
  <a-button @click="updatePrimaryColor('#52c41a')" ghost>极光绿</a-button>
  <a-button @click="updatePrimaryColor('#13c2c2')" ghost>明青</a-button>
  <a-button @click="updatePrimaryColor('#1890ff')" ghost>拂晓蓝</a-button>
  <a-button @click="updatePrimaryColor('#faad14')" ghost>金盏花</a-button>
  <a-button @click="updatePrimaryColor('#fadb14')" ghost>日出</a-button>
  <a-button @click="updatePrimaryColor('#a0d911')" ghost>青柠</a-button>
  <a-button @click="updatePrimaryColor('#fa8c16')" ghost>薄暮</a-button>
  <a-button @click="updatePrimaryColor('#fa541c')" ghost>日暮</a-button>
  <a-button @click="updatePrimaryColor('#f5222d')" ghost>火山</a-button>
  </div>
  <div class="colors" v-else>
  <a-button @click="changeTheme">切换主题</a-button>
  <a-button @click="initialTheme">切换原版</a-button>
  <br/>
  <a-button @click="updatePrimaryColor('#bfbfbf')">中性灰</a-button>
  <a-button @click="updatePrimaryColor('#2f54eb')">极客蓝</a-button>
  <a-button @click="updatePrimaryColor('#722ed1')">酱紫</a-button>
  <a-button @click="updatePrimaryColor('#eb2f96')">法式洋红</a-button>
  <a-button @click="updatePrimaryColor('#52c41a')">极光绿</a-button>
  <a-button @click="updatePrimaryColor('#13c2c2')">明青</a-button>
  <a-button @click="updatePrimaryColor('#1890ff')">拂晓蓝</a-button>
  <a-button @click="updatePrimaryColor('#faad14')">金盏花</a-button>
  <a-button @click="updatePrimaryColor('#fadb14')">日出</a-button>
  <a-button @click="updatePrimaryColor('#a0d911')">青柠</a-button>
  <a-button @click="updatePrimaryColor('#fa8c16')">薄暮</a-button>
  <a-button @click="updatePrimaryColor('#fa541c')">日暮</a-button>
  <a-button @click="updatePrimaryColor('#f5222d')">火山</a-button>
  </div>
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
    primary:'#1890ff',
    link:'#1890ff',
    heading:'rgba(0, 0, 0, 0.85)',
    text:'rgba(0, 0, 0, 0.65)',
    textsecond:'rgba(0, 0, 0, 0.45)',
    border:'#d9d9d9',
    dark: false
    };
  },
  created(){
   if(this.$store.state.theme=="dark")
   {
      this.dark=true;
      this.heading='rgba(255, 255, 255, 0.65)';
      this.text= 'rgba(255,255,255,0.65)';
      this.textsecond='rgba(255, 255, 255, 0.45)';
      this.border='#434343';
   }
  },
  methods:{
    dealTheme(){
      window.less.modifyVars({
      '@primary-color': this.primary,
      '@link-color': this.link,
      '@heading-color':this.heading,
      '@text-color':this.text,
      '@text-color-secondary':this.textsecond,
      '@border-color-base':this.border,
      '@descriptions-bg':'#000000',
      })
    },
    storePrimary(primary){
      this.primary=primary;
    },
    changeTheme(){
      if(this.$store.state.theme=="dark")
      {
        this.dark=false;
        this.$store.dispatch('setTheme',"light");  
        this.heading='rgba(0, 0, 0, 0.65)';
        this.text= 'rgba(0,0,0,0.65)';
        this.textsecond='rgba(0,0,0,0.45)';
        this.border='#d9d9d9';
        this.dealTheme();
        document.querySelector('body').setAttribute('style', 'background-color:#ffffff')
      }
      else
      {
        this.dark=true;
        this.$store.dispatch('setTheme',"dark");
        this.heading='rgba(255, 255, 255, 0.65)';
        this.text= 'rgba(255,255,255,0.65)';
        this.textsecond='rgba(255, 255, 255, 0.45)';
        this.border='#434343';
        this.dealTheme();
        document.querySelector('body').setAttribute('style', 'background-color:#434343')          
      }
    },
    updatePrimaryColor(primary) {
      this.primary=primary;
      this.dealTheme();
    },
    updateTheme(primary,link,heading,text,textsecond,border) {
      this.primary=primary;
      this.heading=heading;
      this.text= text;
      this.textsecond=textsecond;
      this.border=border;
      window.less.modifyVars({
        '@primary-color': primary,
        'link-color':link,
        'heading-color':heading,
        'text-color':text,
        'text-color-secondary':textsecond,
        'border-color-base':border
      });
    },
    initialTheme(){
      this.$store.dispatch('setTheme',"light");
      this.dark=false;
      document.querySelector('body').setAttribute('style', 'background-color:#ffffff')
      this.updateTheme('#1890ff','#1890ff','rgba(0, 0, 0, 0.85)','rgba(0, 0, 0, 0.65)','rgba(0, 0, 0, 0.45)','#d9d9d9');   
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