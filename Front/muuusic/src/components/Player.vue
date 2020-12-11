<template>
    <a-layout-footer style="text-align: left" >
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

     <a-button type="primary" shape="circle" size="large" @click="forward" >
     <template #icon><UndoOutlined/></template>
     </a-button>  
    </a-space>
    <a-col :span="1"></a-col>
    <a-col :span="14"><a-slider :tip-formatter="null" /></a-col>
    <a-col :span="1"></a-col>

     <a-button type="primary"  size="large" @click="showDrawer" >
      <ColumnWidthOutlined  class="icon" v-if=visible />
      <UnorderedListOutlined  class="icon" v-else />
     </a-button>  

    </a-row>
    </a-layout-footer>


   <a-drawer
    title="播放器"
    :placement="placement"
    :closable="false"
    :visible="visible"
    @close="onClose"
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
    <a-empty />
    <a-empty />
    <a-empty />
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
    }
  },
  methods: {
    play() {
      this.playing = !this.playing;
    },
    showDrawer() {
      this.visible = true;
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
    },
    decline() {
      let percent = this.percent - 10;
      if (percent < 0) {
        percent = 0;
      }
      this.percent = percent;
    },
  },
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
</style>