<template>
  <div class="layui-container fly-marginTop">
    <div class="fly-panel" pad20 style="padding-top: 5px;">
      <div class="layui-form layui-form-pane">
        <div class="layui-tab layui-tab-brief" lay-filter="user">
          <ul class="layui-tab-title">
            <li class="layui-this" v-show="false">发表新帖</li>
            <li class="layui-this" v-show="isShow">编辑帖子</li>
          </ul>
          <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
            <div class="layui-tab-item layui-show">
              <form action="" method="post">
                <div class="layui-row layui-col-space15 layui-form-item">
                  <div class="layui-col-md3">
                    <label class="layui-form-label">所在专栏</label>
                    <div class="layui-input-block">
                      <select lay-verify="required" name="class" lay-filter="column" ref="getModel">
                        <option></option>
                        <option value="1">知识问答</option>
                        <option value="2">游戏模块</option>
                        <option value="3">新闻模块</option>
                        <option value="4">新闻模块</option>
                      </select>
                    </div>
                  </div>
                  <div class="layui-col-md9">
                    <label class="layui-form-label">标题</label>
                    <div class="layui-input-block">
                      <input type="text" ref="getTitle" name="title" class="layui-input">
                    </div>
                  </div>
                </div>
                <div class="layui-form-item layui-form-text">
                  <div class="layui-input-block">
                    <textarea id="L_content" name="content"  placeholder="详细描述" class="layui-textarea fly-editor" style="height: 260px;" ref="getContent"></textarea>
                  </div>
                </div>
                <div class="layui-form-item">
                  <div class="layui-inline">
                    <label class="layui-form-label">悬赏飞吻</label>
                    <div class="layui-input-inline" style="width: 190px;">
                      <select name="experience" ref="getReward">
                        <option value="0">0</option>
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="30">30</option>
                        <option value="40">40</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="layui-form-item">
                  <span class="layui-btn" @click="addPosts()">立即发布</span>
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
  export default {
    name: 'add',
    data() {
      return {
        isShow: ''
      }
    },
    created: function () {
      layui.use('form', function () {
        var form = layui.form;
      });
      this.isShow = true
      this.$emit('navigation', false);

    },
    methods: {
      addPosts() {
        var self = this
        const params = {}
        params.postTitle = self.$refs.getTitle.value
        params.postBiboid = self.$refs.getModel.value
        params.postUserid = self.myUtils.getSessionStorage("userId")
        params.postContent = self.$refs.getContent.value
        params.postReward = self.$refs.getReward.value
        if(params.postReward==0){
          params.postIspay = 1
        }
        console.log(this.$refs.getTitle.value)
        $.ajax({
          url: "apis/Posts/addPosts.do",
          type: "GET",
          dataType: "json",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.$router.push({name: 'index'})
            } else {

                layer.msg(data.msg);

            }
          }
        });
      }
    }
  }
</script>

