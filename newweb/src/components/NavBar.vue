<template>
   <nav class="navbar navbar-expand-lg  navbar-dark bg-dark container "  style="margin-top: 10px;width: 50%;">
  <router-link class="navbar-brand" :to="{name:'home'}" > &nbsp;新浪新闻    </router-link>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
        <div class="row">
            <div class="col-2">
                <li class="nav-item active">
                    <router-link class="nav-link" :to="{name:'amuse'}" >娱乐</router-link>
                </li>
            </div>
            <div class="col-2">
                <li class="nav-item">
                  <router-link class="nav-link" :to="{name:'culture'}">文化</router-link>
                </li>
            </div>
            <div class="col-2">
                <li class="nav-item">
                  <router-link class="nav-link" :to="{name:'military'}">军事</router-link>
                </li>
            </div>
            <div class="col-2">
                <li class="nav-item">
                    <router-link class="nav-link" :to="{name:'sports'}" >体育</router-link>
                </li>
            </div>
            <div class="col-2">
                <li class="nav-item">
                    <router-link class="nav-link" :to="{name:'tech'}">教育</router-link>
                </li>
            </div>
            <div class="col-2">       
                <ul v-if="!$store.state.user.is_login" class="navbar-nav " style="margin-left: 50px;">
                <li class="nav-item dropdown">
                <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    未登录
                </button>
                <ul class="dropdown-menu dropdown-menu-dark">
                    <li><router-link class="dropdown-item" :to="{name:'login'}" >登录</router-link></li>
                    <li><router-link class="dropdown-item" :to="{name:'register'}" >注册</router-link></li>
  
            
                </ul>
                </li>
            </ul>

            <ul v-else class="navbar-nav " style="margin-left: 70px;">
                <li class="nav-item dropdown">
                <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    {{ $store.state.user.username}}
                </button>
                <ul class="dropdown-menu dropdown-menu-dark">
              
                    <li><a @click="Logout" class="dropdown-item" href="#">退出登录</a></li>
                  
                </ul>
                </li>
            </ul>
            </div>
        </div>
     
    
      
     

    </ul>
  </div>
</nav>




</template>


<script>
import { useStore } from 'vuex';
import router from '@/router';
export default{
    name:"NavBar",
    setup(){
        const store=useStore();

        const Logout=()=>{
            store.commit("Logout");
            router.push("login")
        }
        return{
            Logout
        }

    }
}
</script>

<style scoped>
</style>