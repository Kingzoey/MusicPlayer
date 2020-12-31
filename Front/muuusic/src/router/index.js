import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/musiclibrary',
    name: 'Musiclibrary',
    component: () => import('../views/MusicLibrary.vue')
  },
  {
    path: '/musiclibraryhome',
    name: 'Musiclibraryhome',
    component: () => import('../views/MusicLibraryHome.vue')
  },
  {
    path: '/musiclibrarysearchthird',
    name: 'Musiclibrarysearchthird',
    component: () => import('../views/MusicLibrarySearchThird.vue')
  },
  {
    path: '/musiclibraryuser',
    name: 'Musiclibraryuser',
    component: () => import('../views/MusicLibraryUser.vue')
  },
  {
    path: '/chatroom',
    name: 'Chatroom',
    component: () => import('../views/ChatRoom.vue')
  },
  {
    path: '/announcement',
    name: 'Announcement',
    component: () => import('../views/Announcement.vue')
  },
  {
    path: '/themeconfig',
    name: 'Themeconfig',
    component: () => import('../views/ThemeConfig.vue')
  },
  {
    path: '/musicconfig',
    name: 'Musicconfig',
    component: () => import('../views/MusicConfig.vue')
  },

  {
    path: '/personalconfig',
    name: 'Personalconfig',
    component: () => import('../views/PersonalConfig.vue')
  },
  {
    path: '/chatconfig',
    name: 'Chatconfig',
    component: () => import('../views/ChatConfig.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
