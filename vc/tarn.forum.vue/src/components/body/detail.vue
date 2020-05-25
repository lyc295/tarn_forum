<template>
  <div class="layui-container">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md8 content detail">
        <div class="fly-panel detail-box">
          <h1>{{postsDetail.postTitle}}</h1>
          <div class="fly-detail-info">
            <span class="layui-badge layui-bg-green fly-detail-column">动态</span>
            <span class="layui-badge layui-bg-red">精帖</span>
            <span class="layui-badge" style="background-color: #999;" v-show="noIsPay">未结</span>
            <span class="layui-badge" style="background-color: #5FB878;" v-show="isPay">已结</span>
            <div class="fly-admin-box">
              <span class="layui-btn layui-btn-xs jie-admin" type="del" v-show="isDel"
                    @click="deletePosts(postsDetail.postId)">删除</span>
            </div>
            <span class="fly-list-nums">
            <a href="#comment"><i class="iconfont" title="回答">&#xe60c;</i>{{commentNumber}}</a>
            <i class="iconfont" title="人气">&#xe60b;</i> {{postsDetail.postRead}}
          </span>
          </div>
          <div class="detail-about">
            <a class="fly-avatar" href="javascript:void(0)" @click="joinCentre(postsDetail.userId)">
              <img :src="postsDetail.userHeadpicurl">
            </a>
            <div class="fly-detail-user">
              <a href="javascript:void(0)" class="fly-link" @click="joinCentre(postsDetail.userId)">
                <cite>{{postsDetail.userName}}</cite>
                <i class="iconfont icon-renzheng"></i>
              </a>
              <span v-show="isCreatetime">{{postsDetail.postCreatetime}}</span>
              <span v-show="isUpdatetime">{{postsDetail.postUpdatetime}}</span>
            </div>
            <div class="detail-hits" id="LAY_jieAdmin" data-id="123">
              <span style="padding-right: 10px; color: #FF7200">悬赏：{{postsDetail.postReward}}飞吻</span>
              <span class="layui-btn layui-btn-xs jie-admin" type="edit" v-show="isEdit"><a
                @click="joinEdit(postsDetail.postId)">编辑此贴</a></span>
              <div class="fly-column-right">
                <span class="layui-btn layui-btn-xs jie-admin" v-show="isCollect"
                      @click="collectPosts(postsDetail.postId)"><a>收藏</a></span>
                <span class="layui-btn layui-btn-xs jie-admin" v-show="isRemove"
                      @click="removeCollect(postsDetail.postId)"><a>取消收藏</a></span>
              </div>

            </div>
          </div>
          <div class="detail-body photos">
            <p>
              {{postsDetail.postContent}}
            </p>
          </div>
          <div class="jieda-reply">
             <span :class="{ 'jieda-zan zanok': isZan, 'jieda-zan': isNoZan}" type="zan">
               <i class="iconfont icon-zan" @click="postsLiked(postsDetail.postId)"></i>
               <em>{{likedNumber}}</em>
             </span>
          </div>
        </div>
        <div class="fly-panel detail-box" id="flyReply">
          <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
            <legend>评论区</legend>
          </fieldset>
          <ul class="jieda" id="jieda" v-for="item in commentList">
            <li data-id="111" class="jieda-daan">
              <div class="detail-about detail-about-reply">
                <a class="fly-avatar" href="javascript:void(0)" @click="joinCentre(item.userId)">
                  <img src="item.userHeadpicurl" alt=" ">
                </a>
                <div class="fly-detail-user">
                  <a href="javascript:void(0)" class="fly-link" @click="joinCentre(item.userId)">
                    <cite>{{item.userName}}</cite>
                    <i class="iconfont icon-renzheng"></i>
                  </a>
                  <span v-show="">(楼主)</span>
                </div>
                <div class="detail-hits">
                  <span>{{item.collectTime}}</span>
                </div>
              </div>
              <div class="detail-body jieda-body photos">
                <p>{{item.collectContent}}</p>
              </div>
              <div class="jieda-reply">
                <span type="reply" @click="replyComment(null,item)"><i class="iconfont icon-svgmoban53"></i>回复</span>
                <div class="jieda-admin">
                  <span type="del" v-show="item.userId == sessionUserId" @click="deleteComment(item.commentId)">删除</span>
                </div>
                <ul class="jieda" v-for="items in item.postsCommentExtList" style="width: 85%; margin-left: 15%">
                  <li class="jieda-daan">
                    <div class="detail-about detail-about-reply">
                      <a class="fly-avatar" href="javascript:void(0)" @click="joinCentre(items.userId)">
                        <img src="item.userHeadpicurl" alt=" ">
                      </a>
                      <div class="fly-detail-user">
                        <a href="javascript:void(0)" class="fly-link" @click="joinCentre(items.userId)">
                          <cite>{{items.userName}}</cite>
                          <i class="iconfont icon-renzheng"></i>
                        </a>
                        <a href="javascript:void(0)" class="fly-link" @click="joinCentre(items.replyUserId)">
                          <span>回复：</span>
                          <cite>{{items.replyUserName}}</cite>
                          <i class="iconfont icon-renzheng"></i>
                        </a>
                      </div>
                      <div class="detail-hits">
                        <span>{{items.collectTime}}</span>
                      </div>
                    </div>
                    <div class="detail-body jieda-body photos">
                      <p>{{items.collectContent}}</p>
                    </div>
                    <div class="jieda-reply">
                      <span type="reply" @click="replyComment(items,item)"><i
                        class="iconfont icon-svgmoban53"></i>回复</span>
                      <div class="jieda-admin">
                        <span type="del" v-show="items.userId == sessionUserId" @click="deleteComment(items.commentId)">删除</span>
                      </div>
                    </div>
                  </li>
                </ul>
              </div>
            </li>
            <li class="fly-none" v-show="">暂无评论</li>
          </ul>
          <div class="layui-form layui-form-pane">
            <form action="/jie/reply/" method="post">
              <div class="layui-form-item layui-form-text">
                <a name="comment"></a>
                <div class="layui-input-block">
                  <span style="display: none" v-bind:id="userIds" v-bind:fatherId="fatherId"></span>
                  <textarea placeholder="请输入内容" ref="getContent" class="layui-textarea fly-editor"
                            tyle="height: 150px;"></textarea>
                </div>
              </div>
              <div class="layui-form-item">
                <input type="hidden" name="jid">
                <span class="layui-btn" @click="addUserComment(postsDetail.postId)">提交回复</span>
              </div>
            </form>
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
    name: 'detail',
    components: {
      right
    },
    data() {
      return {
        isZan: false,
        isNoZan: true,
        isEdit: true,  //编辑按钮
        isDel: true,    //删除按钮
        isCollect: true, //收藏按钮
        isRemove: false,  //取消收藏按钮
        postsDetail: {}, //详情对象
        likedNumber: '0',//帖子点赞数
        commentList: [], //评论详情
        commentNumber: '0',//评论数目
        noIsPay: false,
        isPay: true,
        sessionUserId: '',
        userIds: '',
        fatherId: '',
        isCreatetime:'',
        isUpdatetime:'',
      }
    },

    mounted() {
      this.queryPostsDetail()
      this.getPostsLikedNumber(this.postsDetail.postId)
      this.getUserComment(this.postsDetail.postId)
      this.getCommentNumber(this.postsDetail.postId)
      this.readPosts(this.postsDetail.postId);
      if (this.myUtils.hasValue(this.myUtils.getSessionStorage("userId"))) {
        this.getUserLikedPosts(this.postsDetail.postId)
        this.getUserCollectPosts(this.postsDetail.postId)
      }
    },
    methods: {
      joinCentre(userId) {
        this.$router.push({
          name: 'centre',
          params: {
            userId: userId
          }
        })
      },
      //查询帖子详情
      queryPostsDetail() {
        let postId = this.$route.params.postId;
        var self = this;
        self.sessionUserId = self.myUtils.getSessionStorage("userId");
        $.ajax({
          url: "apis/Posts/queryPostsDetail.do",
          type: "GET",
          data: {postId: postId},
          async: false,
          success: function (data) {
            if (data.code == 10000) {
              self.postsDetail = data.responseBody
              if(data.responseBody.postUpdatetime == null){
                self.isCreatetime = true
                self.isUpdatetime = false
              }else{
                self.isCreatetime = false
                self.isUpdatetime = true
              }
              if (data.responseBody.postIspay == 1) {
                self.noIsPay = true
                self.isPay = false
              } else {
                self.noIsPay = true
                self.isPay = false
              }
              if (data.responseBody.userId == self.myUtils.getSessionStorage("userId")) {
                //发帖者有编辑 删除权限
                self.isEdit = true;
                self.isDel = true;
              } else {
                //非发帖者无编辑 删除权限
                self.isEdit = false;
                self.isDel = false;
              }
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //删除帖子
      deletePosts(postId) {
        var self = this
        $.ajax({
          url: "apis/Posts/deletePosts.do",
          type: "GET",
          data: {postId: postId},
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.$router.push({name: 'index'})
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //收藏帖子
      collectPosts(postId) {
        var self = this
        const params = {}
        params.postId = postId
        params.userId = self.myUtils.getSessionStorage("userId")
        $.ajax({
          url: "apis/Posts/collectPosts.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.isCollect = false
              self.isRemove = true
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //取消收藏
      removeCollect(postId) {
        var self = this
        const params = {}
        params.postId = postId
        params.userId = self.myUtils.getSessionStorage("userId")
        $.ajax({
          url: "apis/Posts/removeCollect.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.isCollect = true
              self.isRemove = false
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //查看评论详情
      getUserComment(postId) {
        var self = this
        const params = {}
        params.postId = postId
        $.ajax({
          url: "apis/comment/getUserComment.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.commentList = data.responseBody;
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //点赞功能
      postsLiked(postId) {
        var self = this
        const params = {}
        params.userId = self.myUtils.getSessionStorage("userId")
        params.postId = postId
        if (self.isZan == true) {
          //取消点赞
          params.likedStatus = 1
        } else if (self.isNoZan == true) {
          //点赞
          params.likedStatus = 0
        }
        $.ajax({
          url: "apis/liked/postsLiked.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              if (data.responseBody == "true") {
                self.isZan = true
                self.isNoZan = false
                self.likedNumber = self.likedNumber + 1
              } else if (data.responseBody == "false") {
                self.isZan = false
                self.isNoZan = true
                self.likedNumber = self.likedNumber - 1
              }
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //查询点赞数
      getPostsLikedNumber(postId) {
        var self = this
        const params = {}
        params.postId = postId
        $.ajax({
          url: "apis/Posts/getPostsLikedNumber.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.likedNumber = data.responseBody;
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //查询当前用户是否点赞该帖子
      getUserLikedPosts(postId) {
        var self = this
        const params = {}
        params.postId = postId
        params.userId = self.myUtils.getSessionStorage("userId")
        $.ajax({
          url: "apis/Posts/getUserLikedPosts.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              if (data.responseBody.length > 0) {
                self.isZan = true
                self.isNoZan = false
              } else {
                self.isZan = false
                self.isNoZan = true
              }
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //查询当前用户是否收藏该帖子
      getUserCollectPosts(postId) {
        var self = this
        const params = {}
        params.postId = postId
        params.userId = self.myUtils.getSessionStorage("userId")
        $.ajax({
          url: "apis/Posts/getUserCollectPosts.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              if (data.responseBody.length > 0) {
                self.isCollect = false
                self.isRemove = true
              } else {
                self.isCollect = true
                self.isRemove = false
              }
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //查看评论数目
      getCommentNumber(postId) {
        var self = this
        const params = {}
        params.postId = postId
        $.ajax({
          url: "apis/comment/getCommentNumber.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.commentNumber = data.responseBody
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //删除评论
      deleteComment(commentId) {
        var self = this
        const params = {}
        params.commentId = commentId
        $.ajax({
          url: "apis/comment/deleteComment.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.getUserComment(self.postsDetail.postId)
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //点击回复
      replyComment(val1, val2) {
        var self = this
        self.fatherId = val2.commentId;
        if (val1 == null) {
          self.userIds = val2.userId
          self.$refs.getContent.value = "@" + val2.userName + "："
        } else {
          self.userIds = val1.userId
          self.$refs.getContent.value = "@" + val1.userName + "："
        }
        self.$refs.getContent.focus()
      },
      //发布评论
      addUserComment(postId) {
        var self = this
        const params = {}
        params.postId = postId
        params.replyUserId = self.userIds
        params.commentFatherId = self.fatherId
        params.userId = self.myUtils.getSessionStorage("userId")
        params.collectContent = self.$refs.getContent.value
        $.ajax({
          url: "apis/comment/addUserComment.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
              self.getCommentNumber(postId)
              self.getUserComment(postId);
              self.userIds = ""
              self.fatherId = ""
              self.$refs.getContent.value = ""
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //阅读帖子
      readPosts(postId) {
        var self = this
        const params = {}
        params.postsId = postId
        $.ajax({
          url: "apis/Posts/readPosts.do",
          type: "GET",
          data: params,
          async: true,
          success: function (data) {
            if (data.code == 10000) {
            } else {
              layer.msg(data.msg);
            }
          }
        });
      },
      //跳转到编辑页面
      joinEdit(postId) {
        this.$router.push({
          name: 'edit',
          params: {
            postId: postId
          }
        })
      }
    },
  }
</script>

