<template>
     <div class="card container " style="width: 45%;margin-top: 50px;">
        <div class="card-body">
            <form @submit.prevent="Login">
                <div class="mb-3 Style container" >
                    <input type="text" v-model="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="请输入账号">
                </div>
                <div class="mb-3 Style container">
                    <input  type="password" v-model="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码">
                </div>

                <div class="mb-3 Style container" style="color: red;">
                  {{ error_message }}
                </div>
            
                <div class="mb-3 Style container">
                    <button  type="submit" class="btn btn-primary " style="width: 45%;">登录</button>
                    <button  @click="Register" class="btn btn-outline-secondary " style="width: 45%;margin-left: 10%;">注册</button>
                </div>
             
            </form>

        </div>
    </div>
</template>

<script>
import router from '@/router';
import { useStore } from 'vuex';
import { ref } from 'vue';
export default {
  name: 'LoginView',
  setup(){
    const Register =()=>{
        router.push({name:"register"})
    }

    const store=useStore();
    let username=ref('');
    let password=ref('');
    let error_message=ref('');

    const Login=()=>{
        error_message.value='';
        store.dispatch("Login",{
            username:username.value,
            password:password.value,
            success()
            {
                store.dispatch("getInfo",{
                    success()
                    {
                        router.push({name:"home"})
                        console.log(store.state.user);
                    },
                    error(){
                        error_message.value="用户名或者密码错误"
                    }
                })
          
            },
            error(){
                error_message.value="用户名或者密码错误"
            }
        })
    }

    return{
        Register,
        username,
        password,
        error_message,
        Login
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