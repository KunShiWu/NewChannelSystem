export default ({
  state: {
    id:'',
    photo:'',
    content:"",
   
  },
  getters: {
  },
  mutations: {
    UpdateInfo(state,data){
        state.id=data.id;
        state.photo=data.photo;
        state.content=data.content;
    },
  
  },
  actions: {
  },
  modules: {

  }
})
