<template>
<div :class="playertheme == '0'?'player':'player-dark'">
    <a-layout-footer :style="{background: 'rgba(0,0,0,.45)'}">
    <a-row>
    <a-col :span="1"></a-col>
    <a-space>
    <a-button type="primary" shape="circle" size="large" @click="backward">
        <template #icon><BackwardOutlined/></template>
    </a-button>

    <a-button type="primary" shape="circle" size="large" @click="play">
      <PauseOutlined  class="icon" v-if=playing />
      <CaretRightOutlined  class="icon" v-else />
    </a-button>

    <a-button type="primary" shape="circle" size="large" @click="forward">
      <template #icon><ForwardOutlined /></template>
    </a-button>

    <a-col :span="1"></a-col>
    <a-col :span="1"></a-col>
    <a-avatar src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3471207712,2066053191&fm=26&gp=0.jpg"/>

     <a-button type="primary" shape="circle" size="large" @click="restart" >
     <template #icon><UndoOutlined/></template>
     </a-button>  
    </a-space>
    <a-col :span="1"></a-col>
    <a-col :span="14"><a-slider :tip-formatter="formatter" v-model:value="songtime" :max="songtotaltime" @change="ontimeChange"/></a-col>
    <a-col :span="1"></a-col>

     <a-button type="primary"  size="large" @click="showDrawer" >
      <ColumnWidthOutlined  class="icon" v-if=visible />
      <UnorderedListOutlined  class="icon" v-else />
     </a-button>  

    </a-row>
    </a-layout-footer>


    
</div>

    <a-layout-footer :style="{background: 'rgba(255,255,255,0)'}" >
    </a-layout-footer>
    <a-layout-footer :style="{background: 'rgba(255,255,255,0)'}" >
    </a-layout-footer>

   <a-drawer
    title="播放器"
    :placement="placement"
    :closable="false"
    :visible="visible"
    @close="onClose"
    v-if="!playertheme"
  >
  <a-space>
    <a-progress 
    type="circle"
      :stroke-color="{
        '0%': '#108ee9',
        '100%': '#87d068',
      }"
      :percent="percent"
    />
    <a-button-group>
      <a-button @click="decline">
        <template #icon><BackwardOutlined /></template>
      </a-button>
      <a-button @click="increase">
        <template #icon><ForwardOutlined /></template>
      </a-button>
    </a-button-group>
  </a-space>


    <a-list item-layout="horizontal" :data-source="songlistdata">
    <template #renderItem="{ item, index }">
      <a-list-item>
        <a-list-item-meta>
          <template #title>
            <a href="item.avatar">{{ item.name }}</a>
          </template>
          <template #avatar>
            <a-avatar :src="item.avatar" />
          </template>
        </a-list-item-meta>
      </a-list-item>
    </template>
  </a-list>

  </a-drawer>
     <a-drawer
    title="播放器"
    :placement="placement"
    :closable="false"
    :visible="visible"
    @close="onClose"
    :drawerStyle="{background: 'rgba(0,0,0,.7)'}"
    :headerStyle="{background: 'rgba(0,0,0,.5)'}"
    v-else
  >
  <a-space>
    <a-progress 
    type="circle"
      :stroke-color="{
        '0%': '#108ee9',
        '100%': '#87d068',
      }"
      :percent="percent"
    />
    <a-button-group>
      <a-button @click="decline" ghost>
        <template #icon><BackwardOutlined /></template>
      </a-button>
      <a-button @click="increase" ghost>
        <template #icon><ForwardOutlined /></template>
      </a-button>
    </a-button-group>
  </a-space>

    <a-list item-layout="horizontal" :data-source="songlistdata">
    <template #renderItem="{ item, index }">
      <a-list-item>
        <a-list-item-meta>
          <template #title>
            <a href="item.avatar">{{ item.title }}</a>
          </template>
          <template #avatar>
            <a-avatar src="item.img" />
          </template>
        </a-list-item-meta>
      </a-list-item>
    </template>
  </a-list>


  </a-drawer>

</template>

<script>
import { ref, reactive } from 'vue'
  import {
    CaretRightOutlined,
    LoadingOutlined,
    PauseOutlined,
    BackwardOutlined,
    ForwardOutlined,
    UndoOutlined,
    ColumnWidthOutlined,
    UnorderedListOutlined
  } from '@ant-design/icons-vue';

export default {
    components: {
    CaretRightOutlined,
    LoadingOutlined,
    PauseOutlined,
    BackwardOutlined,
    ForwardOutlined,
    UndoOutlined,
    ColumnWidthOutlined,
    UnorderedListOutlined
  },
  data() {
    return {
      playing:false,
      visible: false,
      placement: 'right',
      userName: '',
      iconLoading: false,
      percent: 0,
      playertheme:false,
      songtime:0,
      songtotaltime:0,
      timer:null,
      songlistdata:[],
    }
  },
  created(){
    this.playertheme=this.$store.state.dark;
    this.playing=!this.$store.state.playing;
    if(this.playing==false)
      this.play();
    else
      this.playing = !this.playing;
    this.songtotaltime=this.$store.state.audio.duration;
    this.timer = setInterval(this.formatter, 1000);
    
  },
  computed: {
    isFollow () {
      return this.$store.state.dark;　　//需要监听的数据
    },
    isplaying () {
      return this.$store.state.audio;　　//需要监听的数据
    },
  },
  watch: {
    isFollow(newVal,oldVal){
      this.playertheme=this.$store.state.dark;
    },
    isplaying(newVal,oldVal) {
      this.$store.dispatch("shiftSong");
      this.$store.state.audio.src =this.$store.state.songlist[0].src; 　　//需要监听的数据
      this.$store.state.audiotime=0;
    },
  },
  methods: {
    play() {
      this.playing = !this.playing;
      if(this.playing==true){
        this.$store.state.audio.src = this.$store.state.songlist[0].url;
        console.log('总体结果：',this.$store.state.songlist[0].url);
        this.$store.state.audio.currentTime=this.$store.state.audiotime;
        this.$store.state.audio.play();
        this.songtotaltime=this.$store.state.audio.duration;
      }
      else{
        this.$store.dispatch('resetTime', this.$store.state.audio.currentTime);
        this.$store.state.audio.pause();
      }
      this.$store.dispatch('play', this.playing);

    },
    forward(){
      this.$store.dispatch("shiftSong");
      this.restart();
      this.play();
      this.play();
    },
    backward(){
      this.$store.dispatch("popSong");
    },
    restart(){
      this.$store.state.audio.currentTime=0;
      this.$store.state.audiotime=0;
    },
    showDrawer() {
      this.visible = true;
      this.updateSonglist();
    },
    onClose() {
      this.visible = false;
    },
    increase() {
      let percent = this.percent + 10;
      if (percent > 100) {
        percent = 100;
      }
      this.percent = percent;
      this.$store.state.audiotime=percent*this.songtotaltime/100;
      this.$store.state.audio.currentTime=percent*this.songtotaltime/100;
    },
    decline() {
      let percent = this.percent - 10;
      if (percent < 0) {
        percent = 0;
      }
      this.percent = percent;
      this.$store.state.audiotime=percent*this.songtotaltime/100;
      this.$store.state.audio.currentTime=percent*this.songtotaltime/100;
    },
    formatter() {
      this.songtime=this.$store.state.audio.currentTime;
      this.songtotaltime=this.$store.state.audio.duration;
      this.percent=parseInt(this.songtime/this.songtotaltime*100);
      return `${parseInt(this.$store.state.audio.currentTime)}s`;
      if(this.$store.state.audio.currentTime==this.$store.state.audio.duration)
      {
        this.$store.dispatch("popSong");
      }
    },
    ontimeChange(songtime) {
      this.$store.state.audiotime=this.songtime;
      this.$store.state.audio.currentTime=this.songtime;
    },
    updateSonglist(){

      //console.log('总体：',this.$store.state.songlist);

      var list=[];
      list=JSON.stringify(this.$store.state.songlist);
      this.songlistdata=JSON.parse(list);
      console.log('总体结果：',this.songlistdata[0].avatar);
    }
  },
  beforeDestroy() {
    this.$store.dispatch('resetTime', this.$store.state.audio.currentTime);
    if(this.timer) { 
        clearInterval(this.timer); 
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
.player
{
  position:fixed; bottom:0; 
  left: 0;
  right: 0;
  background:#f5f5f5;
} 
.player-dark
{
  position:fixed; bottom:0; 
  left: 0;
  right: 0;
  background:#434343;
}
</style>