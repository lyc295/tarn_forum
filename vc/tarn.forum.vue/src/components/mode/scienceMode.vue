<template>
  <div class="layui-container">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md8">
        <div class="fly-panel" style="margin-bottom: 0;">
          <type/>
          <ul class="fly-list">
            <li v-for="item in postsList">
              <a href="user/home.html" class="fly-avatar">
                <img :src="item.userHeadpicurl">
              </a>
              <h2>
                <a class="layui-badge">动态</a>
                <a href="detail.html">{{item.postTitle}}</a>
              </h2>
              <div class="fly-list-info">
                <a href="user/home.html" link>
                  <cite>{{item.userName}}</cite>
                  <i class="iconfont icon-renzheng"></i>
                </a>
                <span>{{item.postCreatetime}}</span>
                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i>{{item.postReward}}</span>
                <span class="layui-badge fly-badge-accept layui-hide-xs">{{item.postIspay}}</span>
                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
              </div>
              <div class="fly-list-badge">
                <span class="layui-badge layui-bg-red">{{item.postType}}</span>
              </div>
            </li>
          </ul>
          <div class="fly-none">没有相关数据</div>
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
  import type from './../assembly/type'
  import right from './../assembly/right'

  export default {
    name: 'scienceMode',
    components: {
      type,
      right
    },
    data() {
      return {
        paramsTotal: {},
        postsList : [{

        }]
      }
    },
    mounted() {
      this.jumpPage(this.paramsTotal)
    },

    methods: {
      //获取总页数
      queryAllPostsTotal(paramsTotal, callback) {
        $.ajax({
          url: "apis/Posts/queryAllPostsTotal.do",
          type: "GET",
          dataType: "json",
          data: paramsTotal,
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
      jumpPage(paramsTotal) {
        var count = ''
        const params = {}
        this.queryAllPostsTotal(paramsTotal, (data) => {
          count = data
        })
        var self = this
        layui.use('laypage', function () {
          var laypage = layui.laypage;
          laypage.render({
            elem: 'pagePosts',
            limit: 2,
            count: count,
            jump: function (obj) {
              params.number = obj.curr
              params.size = obj.limit
              $.ajax({
                url: "apis/Posts/queryAllPosts.do",
                type: "GET",
                dataType: "json",
                data: params,
                async: true,
                success: function (data) {
                  if (data.code == 10000) {
                    self.postsList = data.responseBody.list
                  }
                  else {
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

