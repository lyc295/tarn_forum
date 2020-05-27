<template>
  <div class="layui-container">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md8">
        <div class="fly-panel" style="margin-bottom: 0;">
          <div class="fly-panel-title fly-filter">
            <a href="javascript:void(0)" class="layui-this" @click="getAll()">综合</a>
            <span class="fly-mid"></span>
            <a href="javascript:void(0)" @click="getIspay(0)">未结</a>
            <span class="fly-mid"></span>
            <a href="javascript:void(0)" @click="getIspay(1)">已结</a>
            <span class="fly-mid"></span>
            <a href="javascript:void(0)" @click="getType(1)">精华</a>
            <span class="fly-filter-right layui-hide-xs">
            <a href="javascript:void(0)" class="layui-this">按最新</a>
            <span class="fly-mid"></span>
            <a href="javascript:void(0)">按热议</a>
          </span>
          </div>
          <ul class="fly-list" v-show="isPostsList">
            <li v-for="item in postsList">
              <a href="javascript:void(0)" class="fly-avatar" @click="joinCentre(item.userId)">
                <img :src="item.userHeadpicurl">
              </a>
              <h2>
                <a class="layui-badge">动态</a>
                <a href="javascript:void(0)" @click="joinDetail(item.postId)">{{item.postTitle}}</a>
              </h2>
              <div class="fly-list-info">
                <a href="javascript:void(0)" link @click="joinCentre(item.userId)">
                  <cite>{{item.userName}}</cite>
                  <i class="iconfont icon-renzheng"></i>
                </a>
                <span>{{item.postCreatetime}}</span>
                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i>{{item.postReward}}</span>
                <span class="layui-badge fly-badge-accept layui-hide-xs">{{item.postIspay == 0? '未结':'已结'}}</span>
                <span class="fly-list-nums"><i class="iconfont" title="人气">&#xe60b;</i> {{item.postRead}}
              </span>
              </div>
              <div class="fly-list-badge">
                <span class="layui-badge layui-bg-red">{{item.postType == 0? '普通':'精贴'}}</span>
              </div>
            </li>
          </ul>
          <div class="fly-none" v-show="isNoPostsList">没有相关数据</div>
          <div style="text-align: center">
            <div id="pagePosts"></div>
          </div>
        </div>
      </div>
      <right/>
    </div>
  </div>
</template>
<script>
  import right from './../assembly/right'

  export default {
    name: 'mode',
    components: {
      right
    },
    data() {
      return {
        postsList: [],
        isNoPostsList: '',
        isPostsList: '',
        params: {},
      }
    },
    watch: {
      $route(next, prev) {
        if (next.name == prev.name) {
          this.jumpPage()
        }
      }
    },
    mounted() {
      this.jumpPage()
    },

    methods: {
      getAll() {
        var self = this
        self.jumpPage();
        self.params = {}
      },
      getIspay(Ispay) {
        var self = this
        self.params.postIspay = Ispay;
        self.jumpPage();
        self.params = {}
      },
      getType(type){
        var self = this
        self.params.postType = type;
        self.jumpPage();
        self.params = {}
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
      //进入帖子详情页面
      joinDetail(postId) {
        this.$router.push({
          name: 'detail',
          params: {
            postId: postId
          }
        })
      },
      //获取总页数
      queryAllPostsTotal(callback) {
        var self = this
        self.params.postBiboid = self.$route.params.modeValue
        $.ajax({
          url: "apis/Posts/queryAllPostsTotal.do",
          type: "GET",
          dataType: "json",
          data: self.params,
          async: false,
          success: function (data) {
            if (data.code == 10000) {
              callback(data.responseBody)
            } else {
            }
          }
        })
      },
      //获取分页后的数据
      jumpPage() {
        var count = ''
        this.queryAllPostsTotal((data) => {
          count = data
        })
        var self = this
        layui.use('laypage', function () {
          var laypage = layui.laypage;
          laypage.render({
            elem: 'pagePosts',
            limit: 10,
            count: count,
            jump: function (obj) {
              self.params.number = obj.curr
              self.params.size = obj.limit
              self.params.postBiboid = self.$route.params.modeValue
              $.ajax({
                url: "apis/Posts/queryAllPosts.do",
                type: "GET",
                dataType: "json",
                data: self.params,
                async: true,
                success: function (data) {
                  if (data.code == 10000) {
                    self.postsList = data.responseBody.list
                    if (data.responseBody.list.length > 0) {
                      self.isNoPostsList = false;
                      self.isPostsList = true;
                    } else {
                      self.isNoPostsList = true;
                      self.isPostsList = false;
                    }
                  }
                  else {
                    layer.msg(data.msg);
                  }
                }
              })
            }
          });
        })
      }
    }
  }
</script>

