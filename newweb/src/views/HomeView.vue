<template>
    <CardBase class=" d-flex justify-content-center">
      <div  class="photo " @click="Show"     >
 
        <div class="add" v-if="flag" >
        <form @submit.prevent="AddNews">
                <div class="mb-3">
                    <label for="exampleInputEmail1" style="color:rgb(16, 120, 225);" class="form-label">请输入要添加的新闻的类型</label>
                    <input v-model="style" type="text" placeholder="amuse/culture/military/sport/tech"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" style="color:rgb(16, 120, 225);" class="form-label">请输入新闻图片链接</label>
                    <input v-model="photo" type="text" placeholder="https://tse2-mm.cn.bing.net/th/id/OIP-C.99AztIWH9HLlMXAm8SRFlgHaGE?pid=ImgDet&rs=1"  class="form-control" id="exampleInputPassword1">
                </div>
             
                <div class="mb-3">
                    <label for="exampleInputPassword1" style="color:rgb(16, 120, 225);" class="form-label">请输入新闻内容</label>
                    <input v-model="content" type="text" class="form-control" id="exampleInputPassword1">
                </div>

                <div class="mb-3 Style container" style="color: red;">
                  {{ error_message }}
                </div>
                <button type="submit" style="width:50%;" class="btn btn-primary float-end ">提交新闻</button>
        </form>
        </div>
      </div>
      
      </CardBase>
</template>

<script>

import CardBase from '@/components/CardBase.vue';
import { useStore } from 'vuex';
import { ref } from 'vue';
import $ from 'jquery'
// import $ from 'jquery'
export default {
  name: 'HomeView',
  components:{
    CardBase,
  },

  setup(){
    const store=useStore();
    let author=ref();
    let style=ref();
    let photo=ref();
    let content=ref();
    let error_message=ref();
    let flag=ref(false)
    const Show =()=>{
      flag.value=true;
    }


    const AddNews =()=>{
      error_message.value='';
      if(style.value!==null&&photo.value!==null&&content.value!=null)
      {

        author.value=store.state.user.username;
        $.ajax({
                url:"http://127.0.0.1:9988/news/addnews/",
                type:"POST",
                headers:{
                Authorization:"Bearer "+ store.state.user.token
            },
                data:{
                    style:style.value,
                    photo:photo.value,
                    content:content.value,
                    author:author.value
                },
                success(resp){
                  flag.value=false;
                  style.value='';
                  photo.value='';
                  content.value='';
                  author.value=store.state.user.username;
                  console.log(resp);
                }
            })
      }
      else {
        error_message.value="输入的内容不能有一个为空";
      }
 

    }

    return{
      Show,
      flag,
      style,
      photo,
      AddNews,
      content,
      error_message
    }
  }
  // setup(){
  //   let msg=ref();

  //   $.ajax({
  //     url:"http://127.0.0.1:9988/user/account/token/",
  //     type:"post",
  //     data:{
  //         username:'wsk',
  //         password:'p1'
  //     },
  //     success(resp){
  //       console.log(resp);
  //       msg.value=resp;
  //     }
  //   })

  //   $.ajax({
  //     url:"http://127.0.0.1:9988/user/account/info/",
  //     type:"get",
  //     headers:{
  //       Authorization:"Bearer "+"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4NjVhNWYwMTY3MDI0MzFmODU2MDk0NTAyNTljMzVhMyIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY4NjYxODgxOCwiZXhwIjoxNjg3ODI4NDE4fQ.V-SKUwMc87b_d4C59UeenPALcE3ovPUArSxLue4vgas"
  //     },
  //     success(resp){
  //       console.log(resp);
    
  //     }
  //   })
  //   // $.ajax({
  //   //   url:"http://127.0.0.1:9988/user/account/register/",
  //   //   type:"post",
  //   //   data:{
  //   //       username:'a',
  //   //       password:'p1',
  //   //       confirmPassword:'p1'
  //   //   },
  //   //   success(resp){
  //   //     console.log(resp);
  //   //   }
  //   // })



  // }
}
</script>


<style scoped>
  .photo{
    width: 45vw;
    height: 100vh;
    background-size: cover;
    background-image: url("@/assets/R-C.png");
    background-repeat: no-repeat;
    cursor: pointer;
  }
  .add{
    width: 500px;
    height: 500px;
    background-color: rgba(221, 247, 241,0.5);
    margin: 0px auto   ;
   
}
</style>
 