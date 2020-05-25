package com.tarn.tarn_forum.server.Impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tarn.tarn_forum.server.PostsSevice;
import com.tarn.tarn_forum.server_dbac.dao.PostsCollectMapper;
import com.tarn.tarn_forum.server_dbac.dao.PostsLikedMapper;
import com.tarn.tarn_forum.server_dbac.dao.UserPostsMapper;
import com.tarn.tarn_forum.server_dbac.model.*;
import com.tarn.tarn_forum.server_dbml.dao.PostsCollectMapperExt;
import com.tarn.tarn_forum.server_dbml.dao.PostsLikedMapperExt;
import com.tarn.tarn_forum.server_dbml.dao.UserPostsMapperExt;
import com.tarn.tarn_forum.server_dbml.model.UserInfoExt;
import com.tarn.tarn_forum.server_dbml.model.UserPostsExt;
import com.tarn.tarn_forum.utils.Enum.PostsEnum;
import com.tarn.tarn_forum.utils.ResponseData.ResponseCode;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostsServiceImpl implements PostsSevice {
    @Autowired
    UserPostsMapper userPostsMapper;
    @Autowired
    PostsCollectMapper postsCollectMapper;
    @Autowired
    PostsLikedMapper postsLikedMapper;
    @Autowired
    PostsLikedMapperExt postsLikedMapperExt;
    @Autowired
    UserPostsMapperExt userPostsMapperExt;
    @Autowired
    PostsCollectMapperExt postsCollectMapperExt;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    /**
     * 模块类型展示
     *
     * @param methodDesc
     * @return
     */
    @Override
    public ResponseData getPostsEnum(String methodDesc) {
        JSONObject json = new JSONObject();
        for (PostsEnum c : PostsEnum.values()) {
            json.put(String.valueOf(c.getIndex()),c.getName());
        }
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",json);
    }

    @Override
    public ResponseData queryAllPosts(String methodDesc,UserPostsExt userPostsExt) {
        PageHelper.startPage(userPostsExt.getNumber(),userPostsExt.getSize());
        List<UserPostsExt> userPostsExts = userPostsMapperExt.queryAllPosts(userPostsExt);
        PageInfo<UserPostsExt> pageInfo = new PageInfo<>(userPostsExts);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",pageInfo);
    }

    @Override
    public ResponseData queryAllPostsTotal(String methodDesc,UserPostsExt userPostsExt) {
        int total = userPostsMapperExt.queryAllPostsTotal(userPostsExt);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",total);
    }


    @Override
    public ResponseData queryPostsOrderBy(String methodDesc) {
        List<UserPostsExt> userPostsExts = userPostsMapperExt.queryAllOrderby();
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",userPostsExts);
    }

    @Override
    public ResponseData queryPostsDetail(String methodDesc,String postId) {
        UserPostsExt mode = userPostsMapperExt.queryPostsDetail(postId);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",mode);
    }

    @Override
    public ResponseData addPosts(String methodDesc, UserPosts userPosts) {
        int i = userPostsMapper.insertSelective(userPosts);
        if(i == 1){
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
        }else{
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }
    }

    @Override
    public ResponseData deletePosts(String methodDesc, UserPosts userPosts) {
        userPosts.setPostFlag((byte) 1);
        int i = userPostsMapper.updateByPrimaryKeySelective(userPosts);
        if(i == 1){
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
        }else{
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }
    }


    @Override
    public ResponseData editPosts(String methodDesc, UserPosts userPosts) {
        int i = userPostsMapper.updateByPrimaryKeySelective(userPosts);
        if(i == 1){
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
        }else{
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }
    }

    @Override
    public ResponseData collectPosts(String methodDesc, PostsCollect postsCollect) {
        int i = postsCollectMapper.insertSelective(postsCollect);
        if(i == 1){
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
        }else{
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }
    }

    @Override
    public ResponseData removeCollect(String methodDesc, PostsCollect postsCollect) {
        int i = postsCollectMapperExt.removeCollect(postsCollect);
        if(i == 1){
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
        }else{
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }

    }

    @Override
    public ResponseData getUserPosts(String methodDesc, Integer userId) {
        List<UserInfoExt> userPosts = postsCollectMapperExt.getUserPosts(userId);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",userPosts);
    }

    @Override
    public ResponseData getUserReleasePosts(String methodDesc, Integer userId) {
        List<UserInfoExt> userPosts = postsCollectMapperExt.getUserReleasePosts(userId);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",userPosts);
    }

    @Override
    public ResponseData getUserCollectPosts(String methodDesc, PostsCollect postsCollect) {
        PostsCollectCriteria ex = new PostsCollectCriteria();
        ex.createCriteria()
                .andUserIdEqualTo(postsCollect.getUserId())
                .andPostIdEqualTo(postsCollect.getPostId())
                .andCollectFlagEqualTo((byte)0);
        List<PostsCollect> postsCollects = postsCollectMapper.selectByExample(ex);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",postsCollects);
    }

    @Override
    public ResponseData getUserLikedPosts(String methodDesc, PostsLiked postsLiked) {
        PostsLikedCriteria ex =new PostsLikedCriteria();
        ex.createCriteria()
                .andUserIdEqualTo(postsLiked.getUserId())
                .andPostIdEqualTo(postsLiked.getPostId())
                .andLikedStatusEqualTo((byte)0);
        List<PostsLiked> postsLikeds = postsLikedMapper.selectByExample(ex);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",postsLikeds);
    }

    @Override
    public ResponseData getPostsLikedNumber(String methodDesc, PostsLiked postsLiked) {
        HashMap postsLikedMap = new HashMap();
        //数据库中的点赞数
        List<Map<String,Object>> postsLikedMysql = postsLikedMapperExt.getPostsLikedNumber(postsLiked);
        for (Map<String, Object> entry : postsLikedMysql) {
            String user_id = String.valueOf(entry.get("USER_ID"));
            String post_id = String.valueOf(entry.get("POST_ID"));
            String key = user_id + "," + post_id;
            postsLikedMap.put(key,user_id);
        }
        //Redis中的点赞数
        Map<Object, Object> hashMap = redisTemplate.opsForHash().entries("postsLiked");
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
                PostsLiked postsRedis = JSONObject.parseObject(String.valueOf(entry.getValue()), PostsLiked.class);
                if(postsRedis !=null){
                    if(postsRedis.getLikedStatus() == 0 ) {
                        postsLikedMap.put(entry.getKey(),entry.getValue());
                    }
                }
            }
        }
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",postsLikedMap.size());
    }
}
