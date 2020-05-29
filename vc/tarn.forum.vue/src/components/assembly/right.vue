<template>
  <div class="layui-col-md4">
    <dl class="fly-panel fly-list-one">
      <dt class="fly-panel-title">本周热议</dt>
      <dd v-for="item in queryHotDiscussList" style="margin: 8px" v-show="isHot">
        <span class="layui-badge layui-bg-red">{{item.postType == 0? '普通':'精贴'}}</span>
        <a href="javascript:void(0)" @click="joinDetail(item.postId)">{{item.postTitle}}</a>
        <span>({{item.postCreatetime}})</span>
        <span style="float: right;"><i class="iconfont" title="人气">&#xe60b;</i> {{item.postRead}}</span>
      </dd>
      <!-- 无数据时 -->
      <div class="fly-none" v-show="isNoHot">本周暂无热议数据</div>
    </dl>

    <div class="fly-panel">
      <div class="fly-panel-title">
        这里可作为广告区域
      </div>
      <div class="fly-panel-main">
        <a href="" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">虚席以待</a>
      </div>
    </div>

    <div class="fly-panel fly-link">
      <h3 class="fly-panel-title">友情链接</h3>
      <dl class="fly-panel-main">
        <dd><a href="http://www.layui.com/" target="_blank">layui</a>
        </dd>
        <dd><a href="http://layim.layui.com/" target="_blank">WebIM</a>
        </dd>
        <dd><a href="http://layer.layui.com/" target="_blank">layer</a>
        </dd>
        <dd><a href="http://www.layui.com/laydate/" target="_blank">layDate</a>
        </dd>
      </dl>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'right',
    data() {
      return {
        queryHotDiscussList: [],
        isNoHot: '',
        isHot: ''
      }
    },
    mounted() {
      this.queryHotDiscuss()
    },
    methods: {
      //进入帖子详情页面
      joinDetail(postId) {
        this.$router.push({
          name: 'detail',
          params: {
            postId: postId
          }
        })
      },
      queryHotDiscuss() {
        var self = this
        $.ajax({
          url: self.$baseUrl+"Posts/queryHotDiscuss.do",
          type: "GET",
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.queryHotDiscussList = data.responseBody
              if (data.responseBody.length > 0) {
                self.isNoHot = false;
                self.isHot = true
              } else {
                self.isNoHot = true;
                self.isHot = false
              }
            } else {
              layer.msg(data.msg);
            }
          }
        });
      }
    }
  }
</script>
