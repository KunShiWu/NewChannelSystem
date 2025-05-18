import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '@/views/HomeView'
import LoginView from '@/views/user/LoginView'
import RegisterView from '@/views/user/RegisterView'
import AmuseView from '@/views/NewContent/AmuseView'
import CultureView from '@/views/NewContent/CultureView'
import MilitaryView from '@/views/NewContent/MilitaryView'
import SportsView from '@/views/NewContent/SportsView'
import TechView from '@/views/NewContent/TechView'
import ShowView from '@/views/ShowView'
import NotFound from '@/views/NotFound'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path:"/login/",
    name:"login",
    component:LoginView
  },
  {
    path:"/register",
    name:"register",
    component:RegisterView
  },
  {
    path: '/amuse',
    name: 'amuse',
    component: AmuseView
  },
  {
    path: '/culture',
    name: 'culture',
    component: CultureView
  },
  {
    path: '/military',
    name: 'military',
    component: MilitaryView
  },
  {
    path: '/sports',
    name: 'sports',
    component: SportsView
  },
  {
    path: '/tech',
    name: 'tech',
    component: TechView
  },
  {
    path:"/show/",
    name:"show",
    component:ShowView
  },
  {
    path:'/404/',
    name:"404",
    component:NotFound,

  },
  {
    path:"/:catchAll(.*)",
    redirect:"/404/"
  }

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
