<template>

<Header/>

<div class="functions">

  <Menu/>

  <div class="colors">
  <a-button @click="changeTheme">切换主题</a-button>
  <a-button @click="updateTheme('#1890ff','#1890ff','rgba(0, 0, 0, 0.85)','rgba(0, 0, 0, 0.65)','rgba(0, 0, 0, 0.45)','#d9d9d9')">切换原版</a-button>
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
    border:'#d9d9d9'
    };
  },

  methods:{
    dealTheme(){
      window.less.modifyVars({
      '@primary-color': this.primary,
      'link-color': this.link,
      'heading-color':this.heading,
      'text-color':this.text,
      'text-color-secondary':this.textsecond,
      'border-color-base':this.border
      })
    },
    storePrimary(primary){
      this.primary=primary
    },
    changeTheme(){
      if(this.$store.state.theme=="dark")
      {
        this.$store.dispatch('setTheme',"light");  
        this.heading='rgba(0, 0, 0, 0.65)';
        this.text= 'rgba(0,0,0,0.65)';
        this.textsecond='rgba(0,0,0,0.45)';
        this.border='#ffffff';
        this.dealTheme();
        document.querySelector('body').setAttribute('style', 'background-color:#ffffff')
      }
      else
      {
        this.$store.dispatch('setTheme',"dark");
        window.less.modifyVars({
          '@heading-color': 'rgba(255, 255, 255, 0.65)',
          '@text-color': 'rgba(255,255,255,0.65)',
          '@text-color-secondary':'rgba(255, 255, 255, 0.45)',
          'border-color-base':'#434343'
        }) 
        document.querySelector('body').setAttribute('style', 'background-color:#434343')          
      }
    },
    updatePrimaryColor(primary) {
      window.less.modifyVars({
        '@primary-color': primary
      });
    },
    updateTheme(primary,link,heading,text,textsecond,border) {
      window.less.modifyVars({
        '@primary-color': primary,
        'link-color':link,
        'heading-color':heading,
        'text-color':text,
        'text-color-secondary':textsecond,
        'border-color-base':border
      });
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