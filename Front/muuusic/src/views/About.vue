<template>

<Header msg="Home"/>

<div class="functions">
  <div class="menu">
    <Menu msg="Home"/>
  </div>


<div class="content">

<div class="progressrow">
  <div class="circle">
    <a-progress type="circle" :percent="30" :width="200" :format="percent => `${percent} 曲`"/>
    <a-progress type="circle" :percent="70" :width="200" status="exception" />
    <a-progress type="circle" :percent="100" :width="200" />
  </div>

  <div class="progress">
    <a-progress :percent="30" />
    <a-progress :percent="50" status="active" />
    <a-progress :percent="70" status="exception" />
    <a-progress :percent="100" />
    <a-progress :percent="50" :show-info="false" />
  </div>
</div>
</div>

</div>
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

.functions{
  display: flex;
  text-align: left;
  line-height: 20px;
  width:100%;
  .content{
    flex:1;
  }
}

.progress{
  margin-left: 5px;
  width: 500px;
}
.circle{
  margin-left: 5px;
  width: 500px;
}

.functions{
  display: flex;
  text-align: left;
  line-height: 20px;
  width:100%;
  .content{
    flex:1;
  }
}

.progressrow{
  display: flex;
  text-align: left;
  line-height: 20px;
  width:100%;
  .progress{
    flex:1;
  }
}


</style>