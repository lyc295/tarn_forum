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
                  <label for="L_username" class="layui-form-label">用户名</label>
                  <div class="layui-input-inline">
                    <input type="text" id="L_username" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <label for="L_email" class="layui-form-label">邮箱</label>
                  <div class="layui-input-inline">
                    <input type="text" id="L_email" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <label for="L_pass" class="layui-form-label">密码</label>
                  <div class="layui-input-inline">
                    <input type="password" id="L_pass" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <label for="L_repass" class="layui-form-label">确认密码</label>
                  <div class="layui-input-inline">
                    <input type="password" id="L_repass" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <span class="layui-btn" @click="userReg()">立即注册</span>
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
    name: 'reg',
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
      //注册接口
      userReg() {
        var self = this;
        if (!self.myUtils.hasValue($("#L_username").val())) {
          layer.msg('请输入用户名');
          return false
        }
        if (!self.myUtils.hasValue($("#L_email").val())) {
          layer.msg('请输入邮箱');
          return false
        }
        if (!self.myUtils.hasValue($("#L_pass").val())) {
          layer.msg('请输入密码');
          return false
        }
        if (!self.myUtils.hasValue($("#L_repass").val())) {
          layer.msg('请确认密码');
          return false
        }
        if ($("#L_pass").val() != $("#L_repass").val()) {
          self.layer.ready(function () {
            self.layer.msg('两次输入密码不同，请检查后重新输入');
          });
          return false
        }
        const params = {}
        params.userName = $("#L_username").val()
        params.userPwd = $("#L_pass").val()
        params.userEmail = $("#L_email").val()
        $.ajax({
          url: self.$baseUrl + "user/register.do",
          type: "POST",
          dataType: "json",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.$router.push({name: 'login'})
            } else {
              layer.msg(data.msg);
            }
          }
        })
      }
    }
  }
</script>
