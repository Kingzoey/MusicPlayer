import { createStore } from 'vuex'

export default createStore({
  state: {
    theme:"light",
    dark: false,
    menucollapsed:false,
    openKeys: [],
    preopenKeys:[]
  },
  mutations: {
    setTheme(state,theme){
      state.theme = theme
      if(theme=='dark')
        state.dark=true
      else
        state.dark=false
    },
    setMenu(state, menucollapsed){
      state.menucollapsed = menucollapsed
 
    },
    setpreMenu(state,openKeys,preopenKeys){
      state.openKeys=openKeys
      state.preopenKeys=preopenKeys
    }
  },
  actions: {
    setTheme (context,theme) {
      context.commit('setTheme',theme);
    },
    setMenu(context,menucollapsed){
      context.commit('setMenu',menucollapsed);
    },
    setpreMenu(context,openKeys,preopenKeys){
      context.commit('setpreMenu',openKeys,preopenKeys);
    }
  },
  modules: {
  }
})
