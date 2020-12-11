<template>


  <a-affix :offset-top=0>
    <Header msg="Home"/>
  </a-affix>

<a-layout id="components-layout-demo-side" style="min-height: 100vh">
 <a-layout-sider v-model:collapsed="collapsed" collapsible collapsedWidth:0>
  <Menu msg="Home"/>
</a-layout-sider>

    <a-layout>
    <a-layout-content style="margin: 0 16px">
  <a-carousel autoplay>
    <div><h3>1</h3></div>
    <div><h3>2</h3></div>
    <div><h3>3</h3></div>
    <div><h3>4</h3></div>
  </a-carousel>
</a-layout-content>
</a-layout>

<a-statistic title="Feedback" :value="1128" style="margin-right: 10px">
  <template #suffix>
    <like-outlined />
  </template>
</a-statistic>


<a-statistic title="Liked" :value="93" class="demo-class">
        <template #suffix>
          <span> / 100</span>
        </template>
      </a-statistic>


</a-layout>
 

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

#components-layout-demo-side {
  height: 32px;
  background: rgba(255, 255, 255, 0);
  margin: 16px;
}

</style>