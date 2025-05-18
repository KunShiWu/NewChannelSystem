
<template>
    <NavBar/>
    <router-view></router-view>
   


</template>

<script>

import "bootstrap/dist/js/bootstrap"
import "bootstrap/dist/css/bootstrap.css"
// import NavBar from '@/components/NavBar';

 import NavBar from "./components/NavBar.vue";
export default{
    components:{

       NavBar
    }
}
</script>

<style>


</style>
