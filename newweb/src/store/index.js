import { createStore } from 'vuex'
import Moduleuser from './user';
import Modulenews from './news'
export default createStore({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user:Moduleuser,
    news:Modulenews
  }
})
