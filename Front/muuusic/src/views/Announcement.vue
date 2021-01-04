<template>

<Header/>

<div class="functions">

  <Menu/>
  <div class="lists">

  <a-list item-layout="horizontal" :data-source="messagelist">
    <template #renderItem="{ item, index }">
      <a-list-item>
        <a-list-item-meta >
        <template #description>
        {{ item.description }}
        </template>
          <template #title>
            <a href="https://www.antdv.com/">{{ item.title }}</a>
          </template>
          <template #avatar>
            <a-avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
          </template>
        </a-list-item-meta>
      </a-list-item>
    </template>
  </a-list>
  <div class="pagination">   
    <a-pagination simple v-model:current="current" :total="50" hideOnSinglePage size="small" />
  </div>
  </div>


  <div class="chat">


  <a-textarea v-model:value="contexts" placeholder="Contexts" :auto-size="{ minRows: 18, maxRows:20  }" style="color:rgba(0,0,0,1);" readonly/>
  <br/><br/>
  <a-row>
    <a-col :span="12">
    <a-space size="large">
  <l style="color:rgba(0,0,0,1);" v-if="!dark">您对该次活动的评价：</l>
  <l style="color:rgba(255,255,255,1);" v-else>您对该次活动的评价：</l>
  <a-rate v-model:value="stars" allow-half />

    <SmileOutlined style="color:rgba(0,0,0,1);" v-if="stars>=2.5&&!dark" />
    <FrownOutlined style="color:rgba(0,0,0,1);" v-else-if="stars<2.5&&!dark" />
    <SmileOutlined style="color:rgba(255,255,255,1);" v-if="stars>=2.5&&dark" />
    <FrownOutlined style="color:rgba(255,255,255,1);" v-else/>

    </a-space>
    </a-col>
    <a-col :span="12">
   <a-space size="large">
  <l style="color:rgba(0,0,0,1);" v-if="!dark">全体用户对该活动的评价：</l>
  <l style="color:rgba(255,255,255,1);" v-else>全体用户对该活动的评价：</l>
  <a-rate v-model:value="allstars" allow-half />

    <SmileOutlined style="color:rgba(0,0,0,1);" v-if="allstars>=2.5&&!dark" />
    <FrownOutlined style="color:rgba(0,0,0,1);" v-else-if="allstars<2.5&&!dark" />
    <SmileOutlined style="color:rgba(255,255,255,1);" v-if="allstars>=2.5&&dark" />
    <FrownOutlined style="color:rgba(255,255,255,1);" v-else/>

  </a-space>
    </a-col>
  </a-row>
  <br/>
        <a-button type="primary" block>
          确认
        </a-button>
        <a-button type="dashed" block v-if="!dark">
          删除
        </a-button>
        <a-button type="dashed" block ghost v-else>
          删除
        </a-button>
  </div>
</div>

  <Player/>


</template>

<script>

import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'
import { SmileOutlined ,FrownOutlined} from '@ant-design/icons-vue';

  const messagelist = [
  {
    title: 'Ant Design Title 1',
    description: 'Ant Design Title 1Content of Tab 1Content of Tab 1Content of Tab 1',
  },
  {
    title: 'Ant Design Title 2',
    description: 'Ant Design Title 3',
  },
  {
    title: 'Ant Design Title 3',
    description: 'Ant Design Title 5',
  },
  {
    title: 'Ant Design Title 4',
    description: 'Ant Design Title 6',
  },
];

export default {

  components: {
    Header,
    Menu,
    Player,
    SmileOutlined,
    FrownOutlined
  },

  data() {
    return {
      messagelist,
      current: 1,
      contexts:'你好',
      words:'',
      stars: 2.5,
      allstars: 2.5,
      dark:false,
    }
  },
  created(){
    this.dark=this.$store.state.dark;
  },
  methods: {

  }
}
</script>

<style scoped>

.functions{
  display: flex;
  text-align: left;
  line-height: 20px;
  width:100%;
  .chat{
    flex:1;
  }
}

.lists{
  margin-left: 10px;
  width:170px;
  height:550px;
  position: relative;
}

.chat{
  margin-left: 20px;
  width:800px;

}

.pagination{
  position: absolute; 
  bottom: 0; 
}
/deep/.ant-input {
  background-color: rgba(0,0,0,0.01);
}
/deep/.ant-pagination-simple .ant-pagination-simple-pager input {
    background-color: rgba(0,0,0,0.01);
}
</style>