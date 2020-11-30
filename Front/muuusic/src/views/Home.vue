<template>
  <div class="home">
    <Header msg="Home"/>
    <Menu msg="Home"/>
    <Player msg="Player"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'

export default {
  name: 'Home',
  components: {
    Header,
    Menu,
    Player
  }
}
</script>
