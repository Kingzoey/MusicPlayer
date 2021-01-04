<template>

<Header/>

<div class="functions">

  <Menu/>
  <div class="content" >
  <a-row type="flex" justify="center" align="top">
  <a-col :span="11">
  <router-link to= Musiclibrarysearchthird>
  <a-button primary style="height:500px;width:300px;" v-if="!dark">
    <HomeOutlined/>
  </a-button>
  <a-button primary ghost style="height:500px;width:300px;" v-else>
    <HomeOutlined/>
  </a-button>
  </router-link>
  </a-col>
 
 <a-divider type="vertical" style="height:500px;"></a-divider>

 <a-col :span="11">

  </a-col>
  </a-row>
  </div>
</div>

  <Player/>


</template>

<script>
import { RadarChartOutlined ,HomeOutlined} from '@ant-design/icons-vue';
import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'

export default {
  name: 'About',
  components: {
    Header,
    Menu,
    Player,
    RadarChartOutlined,
    HomeOutlined
  },
  data() {
    return {
      dark:false
    }
  },
  created(){
    this.dark=this.$store.state.dark;
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

.content{
  width:80%;
  height:400px;
  margin-top:30px;
  text-align: center
}

</style>