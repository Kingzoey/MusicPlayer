<template>

<Header/>

<div class="functions">

  <Menu/>

  <div v-if="dark">
  <a-upload
      list-type="picture"
      action="//jsonplaceholder.typicode.com/posts/"
      :preview-file="previewFile"
    >
      <a-button ghost> <upload-outlined /> Upload </a-button>
    </a-upload>
  </div>
  <div  v-else>
  <a-upload
      list-type="picture"
      action="//jsonplaceholder.typicode.com/posts/"
      :preview-file="previewFile"
    >
      <a-button> <upload-outlined /> Upload </a-button>
    </a-upload>
  </div>

</div>

    <div class="container">
      <div class="box"></div>
    </div>

  <Player/>


</template>

<script>
import { UploadOutlined } from '@ant-design/icons-vue';
import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'

export default {
  name: 'About',
  components: {
    Header,
    Menu,
    Player,
    UploadOutlined,
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
    previewFile(file) {
      console.log('Your upload file:', file);
      // Your process logic. Here we just mock to the same file
      return fetch('https://next.json-generator.com/api/json/get/4ytyBoLK8', {
        method: 'POST',
        body: file,
      })
        .then(res => res.json())
        .then(({ thumbnail }) => thumbnail);
    },
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