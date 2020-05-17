<template>
  <div class="app-headers">
    <div class="fly-header layui-bg-black">
      <div class="layui-container">
        <a class="fly-logo" href="index.html">
          <img alt="layui">
        </a>
        <ul class="layui-nav fly-nav-user" id="login_out">
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
        <ul class="layui-nav fly-nav-user" id="login_in">
          <!-- 登入后的状态 -->
          <li class="layui-nav-item">
            <a class="fly-nav-avatar" href="javascript:;">
              <span class="layui-hide-xs" id="userName"></span>
              <i class="iconfont icon-renzheng layui-hide-xs"></i>
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" id="imgUrl">
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
      return {}
    },
    mounted() {
      this.getToken();
    },
    methods: {
      //判断是否用户是否登录
      getToken() {
        if (this.myUtils.hasValue(this.myUtils.getSessionStorage("token"))) {
          $("#login_out").hide();
          $("#releaseArticle").show()
          $("#collectionArticle").show()
          $("#login_in").show();
          $("#userName").text(this.myUtils.getSessionStorage("userName"))
          if (this.myUtils.hasValue(this.myUtils.getSessionStorage("userName"))) {
            $("#imgUrl").text(this.myUtils.getSessionStorage("userName"))
          }
        } else {
          $("#login_out").show();
          $("#releaseArticle").hide()
          $("#collectionArticle").hide()
          $("#login_in").hide();
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
      joinLogout() {
        var self = this
        $.ajax({
          url: "apis/user/logout.do",
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
              layer.ready(function () {
                layer.msg(data.msg);
              });
            }
          }
        });
      }
    }
  }
</script>
