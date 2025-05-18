<template>
  <div class="card container " style="width: 45%;margin-top: 50px;">
        <div class="card-body">
            <form @submit.prevent="Register" >
                <div class="mb-3 Style container" >
                    <input  v-model="username" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="请输入注册账号">
                </div>
                <div class="mb-3 Style container">
                
                    <input v-model="password"  type="password" class="form-control" id="exampleInputPassword1" placeholder="请设置密码">
                </div>
                <div class="mb-3 Style container">
                
                <input  v-model="confirmPassword" type="password" class="form-control" id="exampleInputPassword1" placeholder="请确认密码">
            </div>
            
            <div class="mb-3 Style container" style="color: red;">
                {{ error_message }}
                </div>
            
                <div class="mb-3 Style container">
              
                    <button  type="submit" class="btn btn-outline-secondary " style="width:100%;">注册</button>
                </div>
             
            </form>

        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
import $ from 'jquery'
import router from '@/router';
export default {
  name: 'RegisterView',
    setup()
    {
        let username=ref();
        let password=ref();
        let confirmPassword=ref();
        let error_message=ref();


        const Register=()=>{
             $.ajax({
                url:"http://127.0.0.1:9988/user/account/register/",
                type:"post",
                data:{
                    username:username.value,
                    password:password.value,
                    confirmPassword:confirmPassword.value
                },
                success(resp){
                    if(resp.error_message==='success')
                    {
                        router.push({name:'login'})
                    }
                    else {
                        error_message.value=resp.error_message;
                        username.value='';
                        password.value='';
                        confirmPassword.value='';
                    }
             
                },
                error(resp){
                    error_message.value=resp.error_message;
                }
                })
        }


        return{
            username,
            password,
            confirmPassword,
            error_message,
            Register
        }
    }
}
</script>


<style scoped>
.Style{
    width: 50%;
    display: flex;
    
}
</style>