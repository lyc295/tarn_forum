<template>
  <div class="app-headers">
    <div class="fly-header layui-bg-black">
      <div class="layui-container">
        <a class="fly-logo" href="index.html">
          <img src="../../assets/logo.png" alt="layui" style="margin: -10px -20px;">
        </a>
        <ul class="layui-nav fly-nav-user" v-show="islogin_out">
          <!-- 未登入的状态 -->
          <li class="layui-nav-item">
            <a class="iconfont icon-touxiang layui-hide-xs" href="javascript:void(0)" @click="joinLogin()"></a>
          </li>
          <li class="layui-nav-item">
            <a href="javascript:void(0)" @click="joinLogin()">登入</a>
          </li>
          <li class="layui-nav-item">
            <a href="javascript:void(0)" @click="joinReg()">注册</a>
          </li>
        </ul>
        <ul class="layui-nav fly-nav-user" v-show="islogin_in">
          <!-- 登入后的状态 -->
          <li class="layui-nav-item">
            <a class="fly-nav-avatar" href="javascript:;">
              <span class="layui-hide-xs" @click="joinCentre(userId)">{{userName}}</span>
              <i class="iconfont icon-renzheng layui-hide-xs"></i>
              <img :src="userHeadpicurl"  @click="joinCentre(userId)">
            </a>
          </li>
          <li class="layui-nav-item">
            <a @click="joinLogout()">退出</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'headers',
    data() {
      return {
        islogin_in: '',
        islogin_out: '',
        userName: '',
        userId: '',
        userHeadpicurl: '',
      }
    },
    mounted() {
      this.getToken();
    },
    methods: {
      //判断是否用户是否登录
      getToken() {
        var self = this
        if (self.myUtils.hasValue(self.myUtils.getSessionStorage("token"))) {
          self.islogin_in = true
          self.userName = self.myUtils.getSessionStorage("userName")
          self.userId = self.myUtils.getSessionStorage("userId")
          self.userHeadpicurl = self.myUtils.getSessionStorage("userHeadpicurl")
        } else {
          self.islogin_out = true
        }
      },
      //跳转到登录页面
      joinLogin() {
        this.$router.push({name: 'login'})
      },
      //跳转到注册页面
      joinReg() {
        this.$router.push({name: 'reg'})
      },
      //跳转到个人中心
      joinCentre(userId) {
        this.$router.push({
          name: 'centre',
          params: {
            userId: userId
          }
        })
      },
      //登出
      joinLogout() {
        var self = this
        $.ajax({
          url: self.$baseUrl + "user/logout.do",
          type: "GET",
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.myUtils.clearSessionStorage("token");
              self.myUtils.clearSessionStorage("userName")
              self.myUtils.clearSessionStorage("userHeadpicurl")
              self.myUtils.clearSessionStorage("userId")
              window.location.href = "index.html";
            } else {

              layer.msg(data.msg);

            }
          }
        });
      }
    }
  }
</script>
