<template>
  <div class="about">
    <Header msg="Home"/>
    <Menu msg="About"/>
    <h1>This is an signin page</h1>
  </div>
</template>

<script>

import Header from '@/components/Header.vue'
import Menu from '@/components/Menu.vue'

export default {
  name: 'About',
  components: {
    Header,
    Menu
  }
}
</script>