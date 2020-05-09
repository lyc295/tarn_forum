package com.tarn.tarn_forum.server.Impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tarn.tarn_forum.server.PostsSevice;
import com.tarn.tarn_forum.server_dbac.dao.UserInfoMapper;
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
    UserInfoMapper userInfoMapper;
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

}
