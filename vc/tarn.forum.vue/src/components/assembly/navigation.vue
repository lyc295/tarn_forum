<template>
  <div class="app-navigation">
    <div class="fly-panel fly-column">
      <div class="layui-container">
        <ul class="layui-clear">
          <li class="layui-hide-xs layui-this model" @click="joinIndex()"><a href="javascript:void(0)" value="">首页</a></li>
          <li class="model"><a href="javascript:void(0)" @click="joinMode(1)">知识问答</a></li>
          <li class="model"><a href="javascript:void(0)" @click="joinMode(2)">游戏天地</a></li>
          <li class="model"><a href="javascript:void(0)" @click="joinMode(3)">新闻要事</a></li>
          <li class="model"><a href="javascript:void(0)" @click="joinMode(4)">其他模块</a></li>
          <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><span class="fly-mid"></span></li>
          <!-- 用户登入后显示 -->
          <li v-show="releaseArticle" class="model"><a href="javascript:void(0)" @click="joinCentre()">我发表的贴</a></li>
          <li v-show="collectionArticle" class="model"><a href="javascript:void(0)" @click="joinCentre()">我收藏的贴</a></li>
        </ul>
        <div class="fly-column-right layui-hide-xs">
          <span class="fly-search"><i class="layui-icon"></i></span>
          <a href="javascript:void(0)" class="layui-btn" @click="joinAdd()">发表新帖</a>
        </div>
        <div class="layui-hide-sm layui-show-xs-block"
             style="margin-top: -10px; padding-bottom: 10px; text-align: center;">
          <a href="javascript:void(0)" class="layui-btn" @click="joinAdd()">发表新帖</a>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'navigation',
    data() {
      return {
        releaseArticle: '',
        collectionArticle: '',
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
          self.releaseArticle = true
          self.collectionArticle = true
        }
      },
      joinAdd() {
        if (this.myUtils.hasValue(this.myUtils.getSessionStorage("token"))) {
          this.$router.push({name: 'add'})
        } else {
          this.$router.push({name: 'login'})
        }
      },
      //跳转到个人中心
      joinCentre() {
        this.$router.push({
          name: 'centre',
          params: {
            userId: this.myUtils.getSessionStorage("userId")
          }
        })
      },
      //跳转到首页
      joinIndex() {
        this.$router.push({
          name: 'index'
        })
      },
      //跳转到不同模块
      joinMode(modeValue) {
        this.$router.push({
          name: 'mode',
          params: {
            modeValue: modeValue
          }
        })
      }
    }
  }
</script>
