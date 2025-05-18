<template>
    <CardBase>
        <img class="photo  " :src="$store.state.news.photo" alt="">
        <p class="content">{{ $store.state.news.content }}</p>
        <form @submit.prevent="AddComment">
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label" style=" font-size: 15px; font-weight: 500; color:rgb(17, 221, 61) ;">网友评论</label>
                <input v-model="content" type="text" class="form-control" id="exampleInputPassword1">
            </div>
            <button type="submit"  class="btn btn-primary  " style="float: right;" >提交</button>
        </form> 
        <br>
        <br>


        <div class="card" v-for="(list, index) in lists" :key="index" style="margin-top: 5px;">  
            <div class="card-body">
                <div class="row">
                    <div class="col-2" >
                        <img class="User_photo" :src="list.photo" alt="">
                        <div class="Font">     {{ list.username }}</div>
                    </div>
       
                    <div class="col-8   ">
                        {{ list.content }}
                    </div>
                </div>
            </div>
        </div>
        
      </CardBase>
</template>

<script>
import { useStore } from 'vuex';
import { ref } from 'vue';
import $ from 'jquery'
import CardBase from '@/components/CardBase.vue';
import { onMounted } from 'vue';

export default {
    
  name: 'ShowView',
  components:{
    CardBase
  },
  setup(){
    const store=useStore();
    let content=ref('');
    let newsid;
    let photo;
    let username;
    let lists=ref();
    const GetComments=()=>{
        $.ajax({
                url:"http://127.0.0.1:9988/comments/get/",
                type:"GET",
                headers:{
                Authorization:"Bearer "+ store.state.user.token
            },
                data:{
                    newsid
                },
                success(resp){
                    console.log(resp);
                    lists.value=resp;
                    console.log("lists",lists.value);
                }
            })
    }
    if(store.state.news.id!==''){
         newsid=store.state.news.id;
         photo=store.state.user.photo;
         username=store.state.user.username;


         onMounted(()=>{
            GetComments();
         })


    }

   

    const AddComment =()=>{
     
        $.ajax({
            url:"http://127.0.0.1:9988/comments/add/",
            type:"POST",
            headers:{
                Authorization:"Bearer "+ store.state.user.token
            },
            data:{
                newsid,
                photo,
                username,
                content:content.value
            },
            success(resp){
                content.value='';
                console.log(resp);
            }
        })
    }


        setInterval(()=>{
            GetComments();
        },1000);



    return {
        AddComment,
        content,
        lists,
        GetComments,
    
    }
  }

}
</script>
<style scoped>

.photo{
    width: 500px;
}
.content{
    overflow-y: scroll
}
.User_photo{
    width: 50px;
    height: 50px;
    border-radius: 50%;
}

.Font{
    color: aquamarine;  
    font-size: 20px;
    margin-left: 8px;
 
}
</style>