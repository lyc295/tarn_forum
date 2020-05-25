<template>
  <div class="layui-container">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md8">
        <div class="layui-carousel" id="test1">
          <div carousel-item>
            <div><img src=""></div>
            <div><img src=""></div>
            <div><img src=""></div>
            <div><img src=""></div>
            <div><img src=""></div>
            <div><img src=""></div>
            <div><img src=""></div>
          </div>
        </div>
        <div class="fly-panel">
          <div class="fly-panel-title fly-filter">
            <a>所有帖子</a>
            <a href="#signin" class="layui-hide-sm layui-show-xs-block fly-right" id="LAY_goSignin" style="color: #FF5722;">去签到</a>
          </div>
          <ul class="fly-list" v-for="item in allPostsList">
            <li>
              <a href="user/home.html" class="fly-avatar">
                <img :src="item.userHeadpicurl">
              </a>
              <h2>
                <a class="layui-badge">动态</a>
                <a @click="joinDetail(item.postId)">{{item.postTitle}}</a>
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
        </div>
      </div>
      <div class="layui-col-md4">
        <div class="fly-panel">
          <h3 class="fly-panel-title">温馨通道</h3>
          <ul class="fly-panel-main fly-list-static">
            <li>
              <a href="http://fly.layui.com/jie/4281/" target="_blank">layui 的 GitHub 及 Gitee (码云)
                仓库，欢迎Star</a>
            </li>
            <li>
              <a href="http://fly.layui.com/jie/5366/" target="_blank">
                layui 常见问题的处理和实用干货集锦
              </a>
            </li>
            <li>
              <a href="http://fly.layui.com/jie/4281/" target="_blank">layui 的 GitHub 及 Gitee (码云)
                仓库，欢迎Star</a>
            </li>
            <li>
              <a href="http://fly.layui.com/jie/5366/" target="_blank">
                layui 常见问题的处理和实用干货集锦
              </a>
            </li>
            <li>
              <a href="http://fly.layui.com/jie/4281/" target="_blank">layui 的 GitHub 及 Gitee (码云)
                仓库，欢迎Star</a>
            </li>
          </ul>
        </div>
        <div class="fly-panel fly-signin">
          <div class="fly-panel-title">
            签到
            <i class="fly-mid"></i>
            <a href="javascript:;" class="fly-link" id="LAY_signinHelp">说明</a>
            <i class="fly-mid"></i>
            <a href="javascript:;" class="fly-link" id="LAY_signinTop">活跃榜<span class="layui-badge-dot"></span></a>
            <span class="fly-signin-days">已连续签到<cite>16</cite>天</span>
          </div>
          <div class="fly-panel-main fly-signin-main">
            <button class="layui-btn layui-btn-danger" id="LAY_signin">今日签到</button>
            <span>可获得<cite>5</cite>飞吻</span>
            <!-- 已签到状态 -->
            <!--<button class="layui-btn layui-btn-disabled">今日已签到</button>-->
            <!--<span>获得了<cite>20</cite>飞吻</span>-->
          </div>
        </div>
        <div class="fly-panel fly-rank fly-rank-reply" id="LAY_replyRank">
          <h3 class="fly-panel-title">回贴周榜</h3>
          <dl>
            <!--<i class="layui-icon fly-loading">&#xe63d;</i>-->
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            F
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
            <dd>
              <a href="user/home.html">
                <img
                  src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"><cite>贤心</cite><i>106次回答</i>
              </a>
            </dd>
          </dl>
        </div>
        <div class="fly-panel">
          <div class="fly-panel-title">
            这里可作为广告区域
          </div>
          <div class="fly-panel-main">
            <a href="http://layim.layui.com/?from=fly" target="_blank" class="fly-zanzhu"
               time-limit="2017.09.25-2099.01.01" style="background-color: #5FB878;">LayIM 3.0 - layui 旗舰之作</a>
          </div>
        </div>

        <div class="fly-panel fly-link">
          <h3 class="fly-panel-title">友情链接</h3>
          <dl class="fly-panel-main">
            <dd><a href="http://www.layui.com/" target="_blank">layui</a></dd>
            <dd><a href="http://layim.layui.com/" target="_blank">WebIM</a></dd>
            <dd><a href="http://layer.layui.com/" target="_blank">layer</a></dd>
            <dd><a href="http://www.layui.com/laydate/" target="_blank">layDate</a></dd>
          </dl>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'index',
    data() {
      return {
        allPostsList:[]
      }
    },
    created: function () {
      this.$emit('navigation', true);
      layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
          elem: '#test1',
          width: '100%', //设置容器宽度
          arrow: 'always', //始终显示箭头
          height: '250px',
        });
      });
    },
    mounted() {
      this.queryPostsOrderBy()
    },
    methods: {
      joinMode() {
        this.$router.push({name: 'scienceMode'})
      },
      //进入帖子详情页面
      joinDetail(postId){
        this.$router.push({
          name: 'detail',
          params: {
            postId:postId
          }})
      },
      queryPostsOrderBy() {
        var self = this
        $.ajax({
          url: "apis/Posts/queryPostsOrderBy.do",
          type: "GET",
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.allPostsList = data.responseBody;
            } else {
                layer.msg(data.msg);
            }
          }
        });
      },


    }
  }
</script>

