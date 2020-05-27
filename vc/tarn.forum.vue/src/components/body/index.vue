<template>
  <div class="layui-container">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md8">
        <div class="layui-carousel" id="rotationImg">
          <div carousel-item>
            <div><img src="../../assets/41364f652ae1abd8b72fe870391d500a.jpg"></div>
            <div><img src="../../assets/b17c40eae545ef76b5e3deacf7b5907b.jpg"></div>
            <div><img src="../../assets/ff1c3cc02b59b653e221a4ea4b97af8f.jpg"></div>
            <div><img src="../../assets/41364f652ae1abd8b72fe870391d500a.jpg"></div>
            <div><img src="../../assets/b17c40eae545ef76b5e3deacf7b5907b.jpg"></div>
            <div><img src="../../assets/ff1c3cc02b59b653e221a4ea4b97af8f.jpg"></div>
          </div>
        </div>
        <div class="fly-panel">
          <div class="fly-panel-title fly-filter">
            <a>所有帖子</a>
            <a class="layui-hide-sm layui-show-xs-block fly-right" @click="userSignin()">签到</a>
          </div>
          <ul class="fly-list" v-for="item in allPostsList">
            <li>
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
          <div style="text-align: center">
            <div class="laypage-main" @click="joinMode()">
              <a href="javascript:void(0)" class="laypage-next">更多求解</a>
            </div>
          </div>
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
          <div class="fly-panel-title">签到
            <span class="fly-signin-days">已连续签到<cite>{{signinDetails.continuitySigninDay== null ? 0 : signinDetails.continuitySigninDay}}</cite>天</span>
          </div>
          <div class="fly-panel-main fly-signin-main">
            <div v-show="isSignIn">
              <button class="layui-btn layui-btn-danger" @click="userSignin()">今日签到</button>
              <span>可获得<cite>5</cite>飞吻</span>
            </div>
            <div v-show="isNoSignIn">
              <button class="layui-btn layui-btn-disabled">今日已签到</button>
            </div>

          </div>
        </div>
        <div class="fly-panel fly-rank fly-rank-reply" id="LAY_replyRank">
          <h3 class="fly-panel-title">活跃榜</h3>
          <dl v-show="isHotList">
            <dd v-for="item in signinHotList">
              <a href="javascript:void(0)" @click="joinCentre(item.userId)">
                <img
                  src="item.userHeadpicurl"><cite>{{item.userName}}</cite><i>已签到{{item.continuitySigninDay == null ? 0 :
                item.continuitySigninDay}}天</i>
              </a>
            </dd>
          </dl>
          <div class="fly-none" style="min-height:200px" v-show="isNoHotList">没有相关数据</div>
        </div>
        <div class="fly-panel">
          <div class="fly-panel-title">
            广告位招租
          </div>
          <div class="fly-panel-main">
            <a target="_blank" class="fly-zanzhu" style="background-color: #5FB878;">广告位招租</a>
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
        allPostsList: [],
        signinDetails: '',
        signinHotList: [],
        isHotList: '',
        isNoHotList: '',
        isSignIn: '',
        isNoSignIn: '',
      }
    },
    mounted() {
      layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
          elem: '#rotationImg',
          width: '100%', //设置容器宽度
          arrow: 'always', //始终显示箭头
          height: '250px',
        });
      });
      this.queryPostsOrderBy()
      this.getSigninHotUser()
      if (this.myUtils.hasValue(this.myUtils.getSessionStorage("userId"))) {
        this.getSigninDetails()
      }
    },
    methods: {
      //跳转到个人中心
      joinCentre(userId) {
        this.$router.push({
          name: 'centre',
          params: {
            userId: userId
          }
        })
      },
      joinMode() {
        this.$router.push({
          name: 'mode',
          params: {
            modeValue: 1
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
      //签到
      userSignin() {
        var self = this
        const params = {}
        params.userId = self.myUtils.getSessionStorage("userId")
        $.ajax({
          url: "apis/user/userSignin.do",
          type: "GET",
          async: false,
          data: params,
          success: function (data) {
            if (data.code == 10000) {
              self.getSigninDetails()
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //查询签到详情
      getSigninDetails() {
        var self = this
        const params = {}
        params.userId = self.myUtils.getSessionStorage("userId")
        $.ajax({
          url: "apis/user/getSigninDetails.do",
          type: "GET",
          async: true,
          data: params,
          success: function (data) {
            if (data.code == 10000) {
              self.signinDetails = data.responseBody;
              if (data.responseBody.signInFlag == true) {
                self.isSignIn = true
                self.isNoSignIn = false
              } else {
                self.isSignIn = false
                self.isNoSignIn = true
              }
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //查看签到活跃榜
      getSigninHotUser() {
        var self = this
        $.ajax({
          url: "apis/user/getSigninHotUser.do",
          type: "GET",
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.signinHotList = data.responseBody;
              if (data.responseBody.length > 0) {
                self.isHotList = true
                self.isNoHotList = false
              } else {
                self.isHotList = false
                self.isNoHotList = true
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

