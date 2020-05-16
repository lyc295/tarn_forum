<template>
  <div class="fly-header layui-bg-black">
    <div class="layui-container">
      <a class="fly-logo" href="index.html">
        <img alt="layui">
      </a>
      <ul class="layui-nav fly-nav-user" id="login_out">
        <!-- 未登入的状态 -->
        <li class="layui-nav-item">
          <a class="iconfont icon-touxiang layui-hide-xs signIn" href="javascript:void(0)"></a>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:void(0)" class="signIn">登入</a>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:void(0)" id="regIn">注册</a>
        </li>
      </ul>
      <ul class="layui-nav fly-nav-user" id="login_in">
        <!-- 登入后的状态 -->
        <li class="layui-nav-item">
          <a class="fly-nav-avatar" href="javascript:;">
            <!--<spen class="layui-hide-xs" id="userName"></spen>-->
            <i class="iconfont icon-renzheng layui-hide-xs"></i>
            <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" id="imgUrl">
          </a>
        </li>
        <li class="layui-nav-item" id="logout">
          <a>退出</a>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {}
    },
    mounted() {
      this.getToken();
    },


    methods: {
      //判断是否用户是否登录
      getToken() {
        if (this.myUtils.hasValue(sessionStorage.getItem("token"))) {
          $("#login_out").hide();
          $("#releaseArticle").show()
          $("#collectionArticle").show()
          $("#login_in").show();
          $("#userName").text(getSessionStorage("userName"))
          if (hasValue(getSessionStorage("userName"))) {
            $("#imgUrl").text(getSessionStorage("userName"))
          }
        } else {
          $("#login_out").show();
          $("#releaseArticle").hide()
          $("#collectionArticle").hide()
          $("#login_in").hide();
        }
      },


      query() {
        var self = this;
        self.$ajax({
          method: "GET",
          url: "apis/Posts/queryAllPostsTotal.do",
        }).then(function (x) {
          console.log(x)
        }).catch(function (error) {

        });
      },
    }
  }


</script>
