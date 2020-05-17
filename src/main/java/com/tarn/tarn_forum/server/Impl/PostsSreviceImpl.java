package com.tarn.tarn_forum.server.Impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tarn.tarn_forum.server.PostsSevice;
import com.tarn.tarn_forum.server_dbac.dao.UserPostsMapper;
import com.tarn.tarn_forum.server_dbac.model.UserPosts;
import com.tarn.tarn_forum.server_dbml.dao.UserPostsMapperExt;
import com.tarn.tarn_forum.server_dbml.model.UserPostsExt;
import com.tarn.tarn_forum.utils.Enum.PostsEnum;
import com.tarn.tarn_forum.utils.ResponseData.ResponseCode;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsSreviceImpl implements PostsSevice {
    @Autowired
    UserPostsMapper userPostsMapper;
    @Autowired
    UserPostsMapperExt userPostsMapperExt;
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
}
