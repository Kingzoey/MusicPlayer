import { createStore } from 'vuex'

export default createStore({
  state: {
    theme:"light",
    dark: false
  },
  mutations: {
    setTheme(state,theme){
      state.theme = theme
      if(theme=='dark')
        state.dark=true
      else
        state.dark=false
  }
  },
  actions: {
    setTheme (context,theme) {
      context.commit('setTheme',theme);
    }
  },
  modules: {
  }
})
