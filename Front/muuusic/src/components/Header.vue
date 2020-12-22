<template>
  <a-affix :offset-top=0>
  <a-page-header
    style="rgba(255, 255, 255, 1); background-color:#ffffff; border: 1px solid rgb(235, 237, 240)" 
    title="音乐"
    sub-title="音乐属于所有人"
    @back="() => null"
  v-if="headertheme!='dark'">
   <template #extra>
      <a-button key="3" @click="showDrawerSignin">
        登录
      </a-button>
      <a-button key="2" @click="showDrawerRegister">
        注册
      </a-button>
      <a-button key="1" type="primary" @click="showDrawerDonate">
        捐赠
      </a-button>
    </template>
  </a-page-header>
    <a-page-header
    style="color: rgba(255, 255, 255, 1);background-color:#000000; border: 1px solid rgb(25,25,112)" 
    title="音乐"
    sub-title="音乐属于所有人"
    @back="() => null"
  v-else >
   <template #extra>
      <a-button key="3" @click="showDrawerSignin" ghost>
        登录
      </a-button>
      <a-button key="2" @click="showDrawerRegister" ghost>
        注册
      </a-button>
      <a-button key="1" type="primary" @click="showDrawerDonate" ghost>
        捐赠
      </a-button>
    </template>
  </a-page-header>
  </a-affix>

 <a-drawer
    title="登录"
    :placement="placement"
    :closable="false"
    :visible="visibleSignin"
    @close="onSigninClose"
    v-if="headertheme!='dark'">
  <a-input placeholder=" 你的用户名" v-model:value="userName" ref="userNameInput">
      <template #prefix><user-outlined type="user" /></template>
      <template #suffix>
        <a-tooltip title="必要信息">
          <info-circle-outlined  />
        </a-tooltip>
      </template>
    </a-input>
    <br />
    <br />
    <a-input-password v-model:value="password" placeholder="你的密码"/>
    <br />
    <br />
    <a-button type="primary" :loading="iconLoading" @click="enterIconLoading" block>
    提交
    </a-button>
  </a-drawer>
 <a-drawer
    title="登录"
    :placement="placement"
    :closable="false"
    :visible="visibleSignin"
    @close="onSigninClose"
    :drawerStyle="{background: 'rgba(0,0,0,.7)'}"
    :headerStyle="{background: 'rgba(0,0,0,.5)'}"
    v-else>
  <a-input  placeholder=" 你的用户名" v-model:value="userName" ref="userNameInput" style="background-color:rgba(0,0,0,.25);">
      <template #prefix><user-outlined type="user" /></template>
      <template #suffix>
        <a-tooltip title="必要信息">
          <info-circle-outlined  />
        </a-tooltip>
      </template>
    </a-input>
    <br />
    <br />
    <a-input-password v-model:value="password" placeholder="你的密码" style="background-color:rgba(0,0,0,.25);" />
    <br />
    <br />
    <a-button type="primary" :loading="iconLoading" @click="enterIconLoading" block>
    提交
    </a-button>
  </a-drawer>

 <a-drawer
    title="注册"
    :placement="placement"
    :closable="false"
    :visible="visibleRegister"
    @close="onRegisterClose"
    v-if="headertheme!='dark'"
  >
  <a-input placeholder=" 你的用户名" v-model:value="userName" ref="userNameInput">
      <template #prefix><user-outlined type="user"/></template>
      <template #suffix>
        <a-tooltip title="必要信息">
          <info-circle-outlined style="color: rgba(0,0,0,.45)" />
        </a-tooltip>
      </template>
    </a-input>

    <br />
    <br />
    <a-input-password v-model:value="password" placeholder=" 你的密码"/>
    <br />
    <br />
    <a-input-password v-model:value="passwordcheck" placeholder=" 再次确认密码"/>
    <br />
    <br />
    <a-button type="primary" :loading="iconLoading" @click="enterIconLoading" block>
    提交
    </a-button>
  </a-drawer>
   <a-drawer
    title="注册"
    :placement="placement"
    :closable="false"
    :visible="visibleRegister"
    @close="onRegisterClose"
    v-else
    :drawerStyle="{background: 'rgba(0,0,0,.7)'}"
    :headerStyle="{background: 'rgba(0,0,0,.5)'}"
  >
  <a-input placeholder=" 你的用户名" v-model:value="userName" ref="userNameInput" style="background-color:rgba(0,0,0,.25);">
      <template #prefix><user-outlined type="user"/></template>
      <template #suffix>
        <a-tooltip title="必要信息">
          <info-circle-outlined style="color: rgba(0,0,0,.45)" />
        </a-tooltip>
      </template>
    </a-input>

    <br />
    <br />
    <a-input-password v-model:value="password" placeholder=" 你的密码" style="background-color:rgba(0,0,0,.25);" />
    <br />
    <br />
    <a-input-password v-model:value="passwordcheck" placeholder=" 再次确认密码" style="background-color:rgba(0,0,0,.25);" />
    <br />
    <br />
    <a-button type="primary" :loading="iconLoading" @click="enterIconLoading" block>
    提交
    </a-button>
  </a-drawer>
  
   <a-drawer
    title="捐赠"
    :placement="placement"
    :closable="false"
    :visible="visibleDonate"
    @close="onDonateClose"
    v-if="headertheme!='dark'"
  >
  <img alt="Donate" src="../assets/money.png" height="230" width="200" >
  </a-drawer>
  <a-drawer
    title="捐赠"
    :placement="placement"
    :closable="false"
    :visible="visibleDonate"
    @close="onDonateClose"
    v-else
    :drawerStyle="{background: 'rgba(0,0,0,.7)'}"
    :headerStyle="{background: 'rgba(0,0,0,.5)'}"
  >
  <img alt="Donate" src="../assets/money.png" height="230" width="200" >
  </a-drawer>
</template>

<script>
import { ref, reactive } from 'vue'
  import {
    UserOutlined,
    InfoCircleOutlined,
    LoadingOutlined
  } from '@ant-design/icons-vue';
export default {
    components: {
    UserOutlined,
    InfoCircleOutlined,
    LoadingOutlined
  },
  data() {
    return {
      visibleSignin: false,
      visibleRegister: false,
      visibleDonate: false,
      placement: 'right',
      userName: '',
      password: '',
      passwordcheck: '',
      iconLoading: false,
      headertheme:'',
    }
  },
  created(){
    this.headertheme=this.$store.state.theme;
  },
  computed: {
    isFollow () {
      return this.$store.state.theme;　　//需要监听的数据
    }
  },
  watch: {
    isFollow(newVal,oldVal){
      this.headertheme=this.$store.state.theme;
    },
  },
  methods: {
    showDrawerSignin() {
      this.visibleSignin = true;
    },
    onSigninClose() {
      this.visibleSignin = false;
    },
    showDrawerRegister() {
      this.visibleRegister = true;
    },
    onRegisterClose() {
      this.visibleRegister = false;
    },
    showDrawerDonate() {
      this.visibleDonate = true;
    },
    onDonateClose() {
      this.visibleDonate = false;
    },
    emitEmpty() {
      this.$refs.userNameInput.focus();
      this.userName = '';
    },
    enterIconLoading() {
      this.iconLoading = { delay: 1000 };
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

/deep/.ant-input {
  background-color: rgba(0,0,0,0.01);
}

</style>