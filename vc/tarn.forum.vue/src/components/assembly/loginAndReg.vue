<template>
  <ul class="layui-tab-title">
    <li @click="joinLogin()">登入</li>
    <li><a href="javascript:void(0)" @click="joinReg()">注册</a></li>
  </ul>
</template>
<script>
  export default {
    name: 'loginAndReg',
    data() {
      return {}
    },
    methods: {
      joinLogin() {
        this.$router.push({name: 'login'})
      },
      //跳转到注册页面
      joinReg() {
        this.$router.push({name: 'reg'})
      },
    }

  }
</script>
