package com.tarn.tarn_forum.server.Impl;

import com.tarn.tarn_forum.server.CommentService;
import com.tarn.tarn_forum.server_dbac.dao.PostsCommentMapper;
import com.tarn.tarn_forum.server_dbac.model.PostsComment;
import com.tarn.tarn_forum.server_dbac.model.PostsCommentCriteria;
import com.tarn.tarn_forum.server_dbml.dao.PostsCommentMapperExt;
import com.tarn.tarn_forum.server_dbml.model.PostsCommentExt;
import com.tarn.tarn_forum.utils.ResponseData.ResponseCode;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentServicelmpl implements CommentService {

    @Autowired
    PostsCommentMapper postsCommentMapper;

    @Autowired
    PostsCommentMapperExt postsCommentMapperExt;

    @Override
    public ResponseData addUserComment(String methodDesc, PostsComment postsComment) {
        postsComment.setCollectTime(new Date());
        int i = postsCommentMapper.insertSelective(postsComment);
        if (i == 1) {
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
        } else {
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }
    }


    @Override
    public ResponseData getUserComment(String methodDesc, PostsComment postsComment) {
        List<PostsCommentExt> postsCommentFather = postsCommentMapperExt.getUserComment(postsComment);
        // 最后的结果
        List<PostsCommentExt> commentList = new ArrayList<PostsCommentExt>();
        // 先找到所有的一级菜单
        for (int i = 0; i < postsCommentFather.size(); i++) {
            // 一级菜单没有parentId
            if (postsCommentFather.get(i).getCommentFatherId() == null) {
                commentList.add(postsCommentFather.get(i));
            }
        }
        // 为一级菜单设置子菜单，getCommentId是递归调用的
        for (PostsCommentExt menu : commentList) {
            menu.setPostsCommentExtList(getChild(menu.getCommentId().toString(), postsCommentFather));
        }
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功", commentList);
    }

    @Override
    public ResponseData getCommentNumber(String methodDesc, PostsComment postsComment) {
        int commentNumber = postsCommentMapperExt.getCommentNumber(postsComment);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功", commentNumber);
    }

    @Override
    public ResponseData deleteComment(String methodDesc, PostsComment postsComment) {
        postsComment.setCollectFlag((byte) 1);
        PostsCommentCriteria ex = new PostsCommentCriteria();
        ex.createCriteria()
                .andCollectFlagEqualTo((byte) 0)
                .andCommentIdEqualTo(postsComment.getCommentId());
        int i = postsCommentMapper.updateByExampleSelective(postsComment, ex);
        if (i > 0) {
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
        } else {
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }
    }


    private List<PostsCommentExt> getChild(String id, List<PostsCommentExt> postsCommentFather) {
        // 子菜单
        List<PostsCommentExt> childList = new ArrayList<>();
        for (PostsCommentExt postsCommentSon : postsCommentFather) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (postsCommentSon.getCommentFatherId() != null) {
                if (StringUtils.equals(postsCommentSon.getCommentFatherId().toString(), id)) {
                    childList.add(postsCommentSon);
                }
            }
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
