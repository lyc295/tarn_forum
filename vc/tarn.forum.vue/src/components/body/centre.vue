<template>
  <div>
    <div class="fly-home fly-panel">
      <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
      <i class="iconfont icon-renzheng" title="Fly社区认证"></i>
      <h1>
        贤心
        <i class="iconfont icon-nan"></i>
        <!-- <i class="iconfont icon-nv"></i>  -->
        <i class="layui-badge fly-badge-vip">VIP3</i>
      </h1>
      {{userInfo}}
      <p style="padding: 10px 0; color: #5FB878;">认证信息：layui 作者</p>

      <p class="fly-home-info">
        <i class="iconfont icon-kiss" title="飞吻"></i><span style="color: #FF7200;">66666 飞吻</span>
        <i class="iconfont icon-shijian"></i><span>2015-6-17 加入</span>
        <i class="iconfont icon-chengshi"></i><span>来自杭州</span>
      </p>

      <p class="fly-home-sign">（人生仿若一场修行）</p>
      <div class="fly-sns" data-user="">
        <a href="javascript:void(0)" class="layui-btn layui-btn-primary fly-imActive" data-type="addFriend">加为好友</a>
        <a href="javascript:void(0)" class="layui-btn layui-btn-normal fly-imActive" data-type="chat">发起会话</a>
      </div>
    </div>
    <div class="layui-container">
      <div class="layui-row layui-col-space15">
        <div class="layui-col-md6 fly-home-jie">
          <div class="fly-panel">
            <h3 class="fly-panel-title">{{userInfo.userName}} 的收藏</h3>
            <ul class="jie-row">
              <li v-show="isComment" v-for="item in postList">
                <span class="fly-jing">精</span>
                <a href="javascript:void(0)" class="jie-title" @click="joinDetail(item.postId)"> {{item}}</a>
                <i>刚刚</i>
                <em class="layui-hide-xs">1136阅/27答</em>
              </li>
              <div v-show="isRemove" class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><i
                style="font-size:14px;">这个人很懒，暂无收藏</i>
              </div>
            </ul>
          </div>
        </div>
        <div class="layui-col-md6 fly-home-jie">
          <div class="fly-panel">
            <h3 class="fly-panel-title">{{userInfo.userName}} 的发布</h3>
            <ul class="jie-row">
              <li v-show="isCommentRelease" v-for="item in releasePostsList">
                <span class="fly-jing">精</span>
                <a href="javascript:void(0)" class="jie-title" @click="joinDetail(item.postId)"> {{item}}</a>
                <i>刚刚</i>
                <em class="layui-hide-xs">1136阅/27答</em>
              </li>
              <div v-show="isRemoveRelease" class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><i
                style="font-size:14px;">这个人很懒，暂无收藏</i>
              </div>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'centre',
    data() {
      return {
        userInfo: '',
        postList: [{}],
        releasePostsList: [{}],
        isComment: '', //有收藏帖子
        isRemove: '', // 无收藏帖子queryPostsDetail
        isCommentRelease:'',
        isRemoveRelease:'',
      }
    },
    created: function () {
      this.$emit('navigation', false);
    },
    mounted() {
      this.getUserCenter()
      this.getUserPosts()
      this.getUserReleasePosts()
    },
    methods: {
      //用户详情查询
      getUserCenter() {
        var self = this;
        let userId = self.$route.params.userId
        $.ajax({
          url: "apis/user/userCenter.do",
          type: "GET",
          dataType: "json",
          data: {userId: userId},
          async: false,
          success: function (data) {
            if (data.code == 10000) {
              self.userInfo = data.responseBody
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //查询用户收藏的帖子
      getUserPosts() {
        var self = this;
        $.ajax({
          url: "apis/Posts/getUserPosts.do",
          type: "GET",
          dataType: "json",
          data: {userId: self.userInfo.userId},
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              if (self.myUtils.hasValue(data.responseBody.length) && data.responseBody.length > 0) {
                //有收藏的帖子
                self.postList = data.responseBody;
                self.isComment = true;
              } else {
                //无收藏的帖子
                self.isRemove = true;
              }
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //查询用户发布的帖子
      getUserReleasePosts() {
        var self = this;
        $.ajax({
          url: "apis/Posts/getUserReleasePosts.do",
          type: "GET",
          dataType: "json",
          data: {userId: self.userInfo.userId},
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              if (self.myUtils.hasValue(data.responseBody.length) && data.responseBody.length > 0) {
                //有发布的帖子
                self.releasePostsList = data.responseBody;
                self.isCommentRelease = true;
              } else {
                //无发布的帖子
                self.isRemoveRelease = true;
              }
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //进入帖子详情页面
      joinDetail(postId) {
        this.$router.push({
          name: 'detail',
          params: {
            postId: postId
          }
        })
      },

      addUserComment(){

      }

    }
  }
</script>
