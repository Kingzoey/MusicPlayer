<template>

<Header msg="Home"/>

<div class="functions">
  <div class="menu">
    <Menu msg="Home"/>
  </div>


<div class="content">

<div class="progressrow">
  <div class="circle">
  <a-space direction="vertical" size="middle">

  <a-card hoverable style="width: 450px">
    <template #cover>
      <img
        alt="example"
        src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607936710507&di=2a6380f39efaab5147c0c27e277b41b1&imgtype=0&src=http%3A%2F%2Fseopic.699pic.com%2Fphoto%2F50095%2F3246.jpg_wh1200.jpg"
        height="70"
      />
    </template>
    <template class="ant-card-actions" #actions>
      <setting-outlined key="setting" />
      <edit-outlined key="edit" />
      <ellipsis-outlined key="ellipsis" />
    </template>
    <a-card-meta title="Name" description="This is the description">
      <template #avatar>
        <a-avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
      </template>
    </a-card-meta>
  </a-card>


  <a-space size="large">
    <a-progress type="circle" :percent="30" :width="200" :format="percent => `${percent} 曲`"/>
    <a-progress type="circle" :percent="70" :width="200" status="exception" />
  </a-space>
    <a-progress type="circle" :percent="100" :width="200" />
  </a-space>  
  </div>

  <div class="progress">
    <a-progress :percent="30" />
    <a-progress :percent="50" status="active" />
    <a-progress :percent="70" status="exception" />
    <a-progress :percent="100" />
    <a-progress :percent="50" :show-info="false" />
    <br/>
    <br/>
    <a-descriptions title="User Info" layout="vertical" size="small" bordered>
    <a-descriptions-item label="Product">
      Cloud Database
    </a-descriptions-item>
    <a-descriptions-item label="Billing Mode">
      Prepaid
    </a-descriptions-item>
    <a-descriptions-item label="Automatic Renewal">
      YES
    </a-descriptions-item>
    <a-descriptions-item label="Order time">
      2018-04-24 18:00:00
    </a-descriptions-item>
    <a-descriptions-item label="Usage Time" :span="2">
      2019-04-24 18:00:00
    </a-descriptions-item>
    <a-descriptions-item label="Status" :span="3">
      <a-badge status="processing" text="Running" />
    </a-descriptions-item>
    <a-descriptions-item label="Negotiated Amount">
      $80.00
    </a-descriptions-item>
    <a-descriptions-item label="Discount">
      $20.00
    </a-descriptions-item>
    <a-descriptions-item label="Official Receipts">
      $60.00
    </a-descriptions-item>
    <a-descriptions-item label="Config Info">
      Data disk type: MongoDB
      <br />
      Database version: 3.4
      <br />
      Package: dds.mongo.mid
      <br />
      Storage space: 10 GB
      <br />
      Replication factor: 3
      <br />
      Region: East China 1<br />
    </a-descriptions-item>
  </a-descriptions>
  </div>
</div>
</div>

</div>

 <Player/>
</template>

<script>
// @ is an alias to /src
import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'
import { SettingOutlined, EditOutlined, EllipsisOutlined} from '@ant-design/icons-vue';
export default {
  name: 'Home',
  components: {
    Header,
    Menu,
    Player,
    SettingOutlined,
    EditOutlined,
    EllipsisOutlined,
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