<template>

  <a-affix :offset-top=0>
    <Header msg="Home"/>
  </a-affix>

<a-row class="Rowfirst" align="left" gutter="20">

<a-col span="5">
  <Menu msg="Home"/>
</a-col>

 <a-col span="10">
  <a-carousel autoplay>
    <div><h3>1</h3></div>
    <div><h3>2</h3></div>
    <div><h3>3</h3></div>
    <div><h3>4</h3></div>
  </a-carousel>
</a-col>

<a-col span="2">
<a-statistic title="Feedback" :value="1128" style="margin-right: 10px">
  <template #suffix>
    <like-outlined />
  </template>
</a-statistic>
</a-col>

<br/>

<a-col span="2">
<a-statistic title="Liked" :value="93" class="demo-class">
        <template #suffix>
          <span> / 100</span>
        </template>
      </a-statistic>
</a-col>




</a-row>

 

  <a-affix :offset-bottom=0>
    <Player msg="Player"/>
  </a-affix>


</template>

<script>
// @ is an alias to /src
import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'
import { LikeOutlined } from '@ant-design/icons-vue';
export default {
  name: 'Home',
  components: {
    Header,
    Menu,
    Player,
    LikeOutlined
  }
}
</script>

<style scoped>
/* For demo */
.ant-carousel ::v-deep(.slick-slide) {
  text-align: center;
  height: 200px;
  line-height: 200px;
  background: #364d79;
  overflow: hidden;
}

.ant-carousel ::v-deep(.slick-slide h3) {
  color: #fff;
}
</style>