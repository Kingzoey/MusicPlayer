import { createStore } from 'vuex'

export default createStore({
  state: {
    token:'',
    signin:false,
    theme:"light",
    dark: false,
    menucollapsed:false,
    openKeys: [],
    preopenKeys:[],
    songlist:[],
    audiotime:0,
    playing:false,
    audio : new Audio()
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
    },
    addSong(state,newsong){
      

      //console.log('总体结果：',state.songlist)
      state.songlist.push(newsong)
      //console.log('总体结果：',state.songlist)
    },
    deleteSong(state,num){ 

      for(var i=0;i<state.songlist.length;i++)
      {

        if(state.songlist[i]!=num)
           state.songlist.push(state.songlist.pop())
        else
          state.songlist.pop()
      }
    },
    popSong(state){
      state.songlist.pop()
    },
    shiftSong(state){
      state.songlist.shift()
    },
    clearSong(state){
      state.songlist=[]
    },
    resetTime(state,time){
      state.audiotime=time;
    },
    play(state,playing){
      state.playing = playing
    },
    signin(state,token,signin){
      state.token = token
      signin=true
    },
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
    },
    addSong(context,newsong){
      context.commit('addSong',newsong);
    },
    deleteSong(context,num){
      context.commit('deleteSong',num);
    },
    popSong(context)
    {
      context.commit('popSong');
    },
    shiftSong(context)
    {
      context.commit('shiftSong');
    },
    clearSong(context){
      context.commit('popSong');
    },
    resetTime(context,time){
      context.commit('resetTime',time);
    },
    play (context,playing) {
      context.commit('play',playing);
    },
    signin(context,token){
      context.commit('signin',token);
    },
    signin(context,token,signin){
      context.commit('signin',token,signin);
    },
  },
  modules: {
  }
})
