<template>
  <div class="layui-container fly-marginTop">
    <div class="fly-panel fly-panel-user" pad20>
      <div class="layui-tab layui-tab-brief" lay-filter="user">
        <loginAndReg/>
        <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
          <div class="layui-tab-item layui-show">
            <div class="layui-form layui-form-pane">
              <form method="post">
                <div class="layui-form-item">
                  <label for="L_user" class="layui-form-label">用户名</label>
                  <div class="layui-input-inline">
                    <input type="text" id="L_user" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <label for="L_pass" class="layui-form-label">密码</label>
                  <div class="layui-input-inline">
                    <input type="password" id="L_pass" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <span class="layui-btn" @click="userLogin()">立即登录</span>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import loginAndReg from './../assembly/loginAndReg'

  export default {
    name: 'login',
    components: {
      loginAndReg
    },
    data() {
      return {}
    },
    created: function () {
      this.$emit('navigation', false);
    },
    methods: {
      //用户登录
      userLogin() {
        var self = this
        if (!this.myUtils.hasValue($("#L_user").val())) {
          layer.msg('请输入用户名');
          return false
        }
        if (!this.myUtils.hasValue($("#L_pass").val())) {
          layer.msg('请输入密码');
          return false
        }
        const params = {}
        params.userName = $("#L_user").val()
        params.userPwd = $("#L_pass").val()
        $.ajax({
          url: self.$baseUrl+"user/login.do",
          type: "POST",
          dataType: "json",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.myUtils.setSessionStorage("token", data.responseBody.token)
              self.myUtils.setSessionStorage("userName", data.responseBody.userName)
              self.myUtils.setSessionStorage("userHeadpicurl", data.responseBody.userHeadpicurl)
              self.myUtils.setSessionStorage("userId", data.responseBody.userId)
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

