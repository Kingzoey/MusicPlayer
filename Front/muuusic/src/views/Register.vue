<template>
  <div class="about">
    <a-affix :offset-top=0>
    <Header msg="Home"/>
    </a-affix>
    <Menu msg="About"/>
    <a-affix :offset-bottom=0>
    <Player msg="Player"/>
    </a-affix>
  </div>
</template>

<script>

import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'

export default {
  name: 'About',
  components: {
    Header,
    Menu,
    Player
  }
}
</script>