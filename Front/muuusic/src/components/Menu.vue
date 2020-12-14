<template>
  <div style="width: 256px" >

    <a-menu
      v-model:openKeys="openKeys"
      v-model:selectedKeys="selectedKeys"
      mode="inline"
      theme="light"
      :inline-collapsed="collapsed"
    >
      <a-menu-item key="1"  @click="toggleCollapsed">
        <MenuUnfoldOutlined v-if="collapsed" />
        <MenuFoldOutlined v-else />
        <span>收起</span>
      </a-menu-item>
      <a-menu-item key="2">
        <DesktopOutlined />
        <span>广场</span>
        <router-link to= "/"></router-link>
      </a-menu-item>
      <a-menu-item key="3">
        <PieChartOutlined />
        <span>个人</span>
        <router-link to= About></router-link>
      </a-menu-item>
      <a-menu-item key="4">
        <InboxOutlined />
        <span>乐库</span>
        <router-link to= Musiclibrary></router-link>
      </a-menu-item>
      <a-sub-menu key="sub1">
        <template #title>
          <span><MailOutlined /><span>信息</span></span>
        </template>
        <a-menu-item key="5">评论</a-menu-item>
        <a-menu-item key="6">回复</a-menu-item>
        <a-menu-item key="7">私信<router-link to= Chatroom></router-link></a-menu-item>
        <a-menu-item key="8">公告<router-link to= Announcement></router-link></a-menu-item>
      </a-sub-menu>
      <a-sub-menu key="sub2">
        <template #title>
          <span><AppstoreOutlined /><span>设置</span></span>
        </template>
        <a-menu-item key="9">主题设置</a-menu-item>
        <a-menu-item key="10">音乐设置</a-menu-item>
        <a-sub-menu key="sub3" title="个人空间">
          <a-menu-item key="11">
            个人信息
          </a-menu-item>
          <a-menu-item key="12">
            收信偏好
          </a-menu-item>
        </a-sub-menu>
      </a-sub-menu>
    </a-menu>
  </div>
</template>

<script>
import {
  MenuFoldOutlined,
  MenuUnfoldOutlined,
  PieChartOutlined,
  MailOutlined,
  DesktopOutlined,
  InboxOutlined,
  AppstoreOutlined,
} from '@ant-design/icons-vue';
export default {
  components: {
    MenuFoldOutlined,
    MenuUnfoldOutlined,
    PieChartOutlined,
    MailOutlined,
    DesktopOutlined,
    InboxOutlined,
    AppstoreOutlined,
  },
  data() {
    return {
      collapsed: false,
      selectedKeys: ['1'],
      openKeys: ['sub1'],
      preOpenKeys: ['sub1'],
    };
  },
  watch: {
    openKeys(val, oldVal) {
      this.preOpenKeys = oldVal;
    },
  },
  methods: {
    toggleCollapsed() {
      this.collapsed = !this.collapsed;
      this.openKeys = this.collapsed ? [] : this.preOpenKeys;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">

</style>