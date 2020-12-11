<template>


  <Header msg="Home"/>

<div class="functions">

<div class="menu">
  <Menu msg="Home"/>
</div>

<div class="content">

<div class="carouselrow">
<div class="carousel">
  <a-carousel autoplay>
    <div><h3>1</h3></div>
    <div><h3>2</h3></div>
    <div><h3>3</h3></div>
    <div><h3>4</h3></div>
  </a-carousel>
</div>

<div class="review">
<a-statistic title="Feedback" :value="1128" style="margin-right: 10px">
  <template #suffix>
    <like-outlined />
  </template>
</a-statistic>

<br />

<a-statistic title="Liked" :value="93" class="demo-class">
        <template #suffix>
          <span> / 100</span>
        </template>
</a-statistic>

<br />

<a-statistic title="Publish Day" :value="2" class="demo-class">
        <template #suffix>
          <span>012 /9 / 10</span>
        </template>
      </a-statistic>
</div>
</div>

<div class="comments">
    <a-list item-layout="vertical" size="large" :data-source="listData">
      <template #renderItem="{ item, index }">
        <a-list-item key="item.title">
          <template v-if="!loading" #actions>
            <span v-for="{ type, text } in actions" :key="type">
              <component v-bind:is="type" style="margin-right: 8px"></component>
              {{ text }}
            </span>
          </template>
          <template #extra>
            <img
              v-if="!loading"
              width="272"
              alt="logo"
              src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
            />
          </template>
          <a-skeleton :loading="loading" active avatar>
            <a-list-item-meta :description="item.description">
              <template #title>
                <a :href="item.href">{{ item.title }}</a>
              </template>
              <template #avatar><a-avatar :src="item.avatar"/></template>
            </a-list-item-meta>
            {{ item.content }}
          </a-skeleton>
        </a-list-item>
      </template>
    </a-list>
  </div>

</div>
</div>



<a-divider />

    <a href="#"><a-switch :checked="!loading" @change="onChange" />Link</a>

<Player msg="Player"/>



</template>

<script>
// @ is an alias to /src
import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'
import { LikeOutlined,StarOutlined, MessageOutlined} from '@ant-design/icons-vue';
const listData = [];
for (let i = 0; i < 3; i++) {
  listData.push({
    href: '/About',
    title: `热门曲目 ${i}`,
    avatar: 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3471207712,2066053191&fm=26&gp=0.jpg',
    description:
      '这首歌超棒的！',
    content:
      '电影太仁慈,总能让错过的人重新相遇;生活不一样,有的人说过再见就再也不见了。这首歌让我想起了往事........',
  });
}
export default {
  name: 'Home',
  components: {
    Header,
    Menu,
    Player,
    LikeOutlined,
    StarOutlined,
    MessageOutlined,
  },
  data() {
    return {
      loading: true,
      listData,
      actions: [
        { type: 'star-outlined', text: '156' },
        { type: 'like-outlined', text: '156' },
        { type: 'message-outlined', text: '2' },
      ],
    };
  },
  methods: {
    onChange(checked) {
      this.loading = !checked;
    },
  },
}
</script>

<style scoped>
/* For demo */
.ant-carousel ::v-deep(.slick-slide) {
  text-align: center;
  height: 300px;
  line-height: 300px;
  background: #364d79;
  overflow: hidden;
}

.ant-carousel ::v-deep(.slick-slide h3) {
  color: #fff;
}

.functions{
  display: flex;
  text-align: left;
  line-height: 100px;
  
  width:100%;
   .content{
    flex:1;
   }
}

.carouselrow{
  display: flex;
  text-align: left;
  line-height: 60px;
  width:1200px;
  .review{
    flex:1;
  }
}
  .review{
    
    margin-left: 5%;
    width:80%;
  }
  .carousel{
    width: 1000px;
  }
.comments {
  text-align: left;
  width: 1200px;
}
.content{
   margin-left: 5px;
}

</style>