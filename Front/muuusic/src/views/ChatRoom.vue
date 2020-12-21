<template>

<Header/>

<div class="functions">

  <Menu/>
  <div class="lists">

    <a-input-search
      v-model:value="searchvalue"
      placeholder="input search text"
      enter-button
      @search="onSearch"
    />
    <br /><br />
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
    <a-pagination simple v-model:current="current" :total="50" hideOnSinglePage size="small" style="color:rgba(0,0,0,1);"/>
  </div>
  </div>

  <div class="chat">
  <a-tabs v-model:activeKey="activeKey" type="editable-card" @edit="onEdit">
    <a-tab-pane v-for="pane in panes" :key="pane.key" :tab="pane.title" :closable="pane.closable">
      {{ pane.content }}
    </a-tab-pane>
  </a-tabs>

  <a-textarea v-model:value="contexts" placeholder="Contexts" :auto-size="{ minRows: 15, maxRows:20  }" readonly/>
  <a-textarea v-model:value="words" showCount :maxlength="100" :auto-size="{ minRows: 2, maxRows:3  }"/>
        <a-button type="primary" block>
          发送
        </a-button>
        <a-button type="dashed" block v-if="!dark">
          清空
        </a-button>
        <a-button type="dashed" block ghost v-else>
          清空
        </a-button>
  </div>
</div>

  <Player/>


</template>

<script>

import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'

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

const panes = [
      { title: 'Tab 1', content: 'Content of Tab 1', key: '1', closable: false },
      { title: 'Tab 2', content: 'Content of Tab 2', key: '2' },
      { title: 'Tab 3', content: 'Content of Tab 3', key: '3' },
    ];

export default {

  components: {
    Header,
    Menu,
    Player,
  },

  data() {
    return {
      messagelist,
      activeKey: panes[0].key,
      panes,
      newTabIndex: 0,
      current: 1,
      contexts:'',
      searchvalue:'',
      words:'',
      dark:false
    }
  },
  created(){
    this.dark=this.$store.state.dark;
  },
  methods: {
    callback(key) {
      console.log(key);
    },
    onEdit(targetKey, action) {
      console.log(targetKey, action);
      this[action](targetKey);
    },
    add() {
      const panes = this.panes;
      const activeKey = `newTab${this.newTabIndex++}`;
      panes.push({ title: 'New Tab', content: 'Content of new Tab', key: activeKey });
      this.panes = panes;
      this.activeKey = activeKey;
    },
    remove(targetKey) {
      let activeKey = this.activeKey;
      let lastIndex;
      this.panes.forEach((pane, i) => {
        if (pane.key === targetKey) {
          lastIndex = i - 1;
        }
      });
      const panes = this.panes.filter(pane => pane.key !== targetKey);
      if (panes.length && activeKey === targetKey) {
        if (lastIndex >= 0) {
          activeKey = panes[lastIndex].key;
        } else {
          activeKey = panes[0].key;
        }
      }
      this.panes = panes;
      this.activeKey = activeKey;
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
</style>