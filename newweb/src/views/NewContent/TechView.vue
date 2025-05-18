<template>
    <CardBase>
           <div   class="card"   v-for="list in lists" :key="list.id" style="margin-top: 2px; " >

                 
          <form @submit.prevent="Modify(list.id)" v-if="flag&&$store.state.user.username===list.author" >
                <div class="mb-3">
                    <label for="exampleInputPassword1" style="color:rgb(16, 120, 225);" class="form-label">请修改新闻图片链接</label>
                    <input v-model="photo" type="text" :placeholder="list.photo"  class="form-control" id="exampleInputPassword1">
                </div>
             
                <div class="mb-3">
                    <label for="exampleInputPassword1" style="color:rgb(16, 120, 225);" class="form-label">请修改新闻内容</label>
                    <input v-model="content" type="text" class="form-control" id="exampleInputPassword1 " :placeholder="list.content" >
                </div>
                <button type="submit" style="width:50%;" class="btn btn-primary float-end ">修改新闻</button>
        </form>
               <div  class="card-body" style=" cursor: pointer;"  v-else   >
               
                <div class="row">
                    <div class="col-3">
                            <img  class="photo" :src=list.photo  alt="" @click="TurnToContent(list.id,list.photo,list.content)" >
                    </div>
                    <div class="col-1">
                      <button     class="btn btn-outline-primary " @click="ModifyNews"  v-if="$store.state.user.username===list.author"  style="margin-right: 5px;  --bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;" >Modify</button>
                    </div>
                    <div class="col-1">
                      <button type="button" @click="DeleteNews(list.id)" v-if="$store.state.user.username===list.author" class="btn btn-danger "  style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">Delete</button>
                    </div>
                    <div class="col-7">
                        <pre class=" text-wrap  content" @click="TurnToContent(list.id,list.photo,list.content)" >
                            {{ list.content }}
                        </pre>
                    </div>
                </div>
               </div>
           </div>
   
   
         </CardBase>
   </template>
   
   <script>
   import CardBase from '@/components/CardBase.vue';
   import { useStore } from 'vuex';
   import { ref } from 'vue';
   import $ from 'jquery'
   import router from '@/router';
   export default {
     name: 'CultureView',
     components:{
       CardBase
     },
     setup(){
       const store=useStore();
       let lists=ref('');
       $.ajax({
         url:"http://127.0.0.1:9988/news/tech/",
         type:"get",
         headers:{
           Authorization:"Bearer "+ store.state.user.token,
         },
         success(resp){
           lists.value=resp;
         },
   
       })
   
       const TurnToContent=(id,photo,content)=>{
   
           store.commit("UpdateInfo",{
               id,
               photo,
               content
           })
   
           router.push({name:'show'})
       }
   

       const DeleteNews=(id)=>{
      $.ajax({
      url:"http://127.0.0.1:9988/news/delete/",
      type:"POST",
      headers:{
        Authorization:"Bearer "+ store.state.user.token,
      },
      data:{
        id
      },
    })


    setInterval(()=>{
          $.ajax({
      url:"http://127.0.0.1:9988/news/getamusenews/",
      type:"get",
      headers:{
        Authorization:"Bearer "+ store.state.user.token,
      },
      success(resp){
        console.log(resp);
        lists.value=resp;
      },

    })
    },1000)


    }


    let photo=ref();
    let content=ref();
    let flag=ref(false)
    const ModifyNews=()=>{
        flag.value=true;
    }

    const  Modify=(id)=>{
      $.ajax({
      url:"http://127.0.0.1:9988/news/modify/",
      type:"POST",
      headers:{
        Authorization:"Bearer "+ store.state.user.token,
      },
      data:{
        photo:photo.value,
        content:content.value,
        id
      },
      success(resp)
      {
        flag.value=false;
        console.log(resp);
      }
    })
    }
    return{
        lists,
        TurnToContent,
        DeleteNews,
        ModifyNews,
        flag,
        Modify,
        photo,
        content
    }
     }
   }
   </script>
   
   
   <style scoped>
   
   .photo{
       width: 100px;
       height: 100px;
       background-color: bisque;
       cursor: pointer;
   }
   
   .content{
   display: block;
   height: 80px;
   overflow:hidden;
   cursor: pointer;
   user-select: none;
   
   }
   
   </style>