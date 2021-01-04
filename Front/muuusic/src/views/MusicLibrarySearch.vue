<template>

<Header/>

<div class="functions">

  <Menu/>
  <div class="content" >

  <l style="color:rgba(0,0,0,1);" v-if="!dark">第三方音乐搜索</l>
  <l style="color:rgba(255,255,255,1);" v-else>第三方音乐搜索</l>
  <br/>
  <br/>
     <a-input-search
      v-model:value="searchvalue"
      placeholder="输入歌名或者歌手名"
      enter-button
      @search="onSearch"
      style="width:90%;"
    />
  <br/> 
  <br/>
  <div class="list">
  <a-list item-layout="vertical" size="large" :pagination="pagination" :data-source="listData">
    <template #renderItem="{ item, index }">
      <a-list-item key="item.title">
        <template #actions>
          <span v-for="{ type, text } in actions" :key="type">
            <component v-bind:is="type" style="margin-right: 8px" />
            {{ text }}
          </span>
        </template>
        <template #extra>
          <img
            width="180"
            alt="logo"
            :src="item.img"
          />
        </template>
        <a-list-item-meta :description="item.description">
          <template #title>
            <a @click="addsong(item.title,item.id,item.img,item.avatar)">{{ item.title }}</a>
          </template>
          <template #avatar><a-avatar :src="item.avatar"/></template>
        </a-list-item-meta>
        {{ item.content }}
      </a-list-item>
    </template>
  </a-list>
  </div>

<br/><br/>
<br/><br/>
<br/><br/>

  </div>
</div>
<br/>
<br/>

  <Player/>


</template>

<script>
import { StarOutlined, LikeOutlined, MessageOutlined } from '@ant-design/icons-vue';
import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'

const listData = [];
for (let i = 0; i < 0; i++) {
  listData.push({
    id:15,
    href: 'https://www.antdv.com/',
    title: `ant design vue part ${i}`,
    img: 'https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png',
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    description:
      'Ant Design, a design language for background applications, is refined by Ant UED Team.',
    content:
      'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
  });
}

export default {
  name: 'About',
  components: {
    Header,
    Menu,
    Player,
    StarOutlined,
    LikeOutlined,
    MessageOutlined,
  },
  data() {
    return {
      searchvalue:'',
      searchedvalue:[],
      searchedavatar:'',
      searchedname:'',
      searchedid:'',
      dark:false,
      listData,
      pagination: {
        onChange: page => {
          console.log(page);
          style="{}";
        },
        pageSize: 3,
      },
      actions: [
        { type: 'StarOutlined', text: '156' },
        { type: 'LikeOutlined', text: '156' },
        { type: 'MessageOutlined', text: '2' },
      ],
    }
  },
  created(){
    this.dark=this.$store.state.dark;
  },
  methods: {
    onSearch() {
      this.axios.get('http://localhost:3000/cloudsearch', {
        params:{
          keywords:this.searchvalue
        }
}).then(res => {
  this.listData = [];
  for (let i = 0; i < res.data.result.songs.length; i++) {

    this.axios.get('http://localhost:3000/artist/detail', {
      params:{
        id:res.data.result.songs[i].ar[0].id
      }
      }).then(arres => { 
    var temp={};
    temp.content="歌手简介："+arres.data.data.artist.briefDesc;      
    temp.avatar=arres.data.data.artist.cover;        
    temp.id=res.data.result.songs[i].id;
    temp.href=res.data.result.songs[i].al.picUrl;
    temp.title=res.data.result.songs[i].name;
    temp.description="专辑名："+res.data.result.songs[i].al.name;
    temp.img=res.data.result.songs[i].al.picUrl;
    this.listData.push(temp);
    
    
    });
}   
});

  },
  addsong(name,id,img,avatar){
    this.axios.get('http://localhost:3000/song/url', {
    params:{
      id:id
    }
}).then(res => {

    this.axios.get('http://localhost:3000/lyric', {
    params:{
      id:id
    }
}).then(ress => {
    var temp={};
    temp.url=res.data.data[0].url;
    temp.lyric=ress.data.lrc.lyric;
    temp.tlyric=ress.data.tlyric.lyric;
    temp.img=img;
    temp.avatar=avatar;
    temp.name=name;
    this.$store.dispatch('addSong',temp);
    //console.log('总体结果：',this.$store.state.songlist)
  });

});
    },

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
  text-align: center;
}
.list
{
  margin-left:30px;
   text-align: left;
}
/deep/.ant-input {
  background-color: rgba(0,0,0,0.01);
}
</style>