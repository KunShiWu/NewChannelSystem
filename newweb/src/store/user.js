import $ from 'jquery'
export default ({
  state: {
    id:'',
    username:"",
    photo:'',
    token:'',
    is_login:false,
    is_valid:false
  },
  getters: {
  },
  mutations: {
    UpdateUser(state,user)
    {
        state.id=user.id;
        state.username=user.username;
        state.photo=user.photo;
        state.is_login=user.is_login;
    },
    UpdateToken(state,token)
    {
        state.token=token;
    },
    Logout(state){
        localStorage.removeItem("jwt_token");
        state.id='';
        state.username='';
        state.photo='';
        state.is_login=false;
        state.is_valid=false;
        state.token=''
      },
      is_jwtToken_valid(state,is_valid)
      {
          state.is_valid=is_valid;
      }
  },
  actions: {
    Login(context,data)
    {
        $.ajax({
            url:"http://127.0.0.1:9988/user/account/token/",
            type:"post",
            data:{
                username:data.username,
                password:data.password
            },
            success(resp){
                if(resp.error_message==='success')
              {
                localStorage.setItem("jwt_token",resp.token);
                context.commit("UpdateToken",resp.token);
                data.success(resp);
              }else {
                data.error(resp)
              }
            },
            error(resp){
                data.error(resp);
            }
          })
    },
    getInfo(context,data){
    $.ajax({
      url:"http://127.0.0.1:9988/user/account/info/",
      type:"get",
      headers:{
        Authorization:"Bearer "+ context.state.token,
      },
      success(resp){
        console.log(resp);
        if(resp.error_message==="success")
        {
            context.commit("UpdateUser",{
                ...resp,
                is_login:true
            })
            data.success(resp);
        }else{
            data.error(resp);
        }
      
    
      },
      error(resp){
        data.error(resp)
      }
    })
    },

    
    
  },
  
  modules: {
  }
})
