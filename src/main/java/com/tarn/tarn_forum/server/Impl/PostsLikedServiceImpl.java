package com.tarn.tarn_forum.server.Impl;

import com.alibaba.fastjson.JSONObject;
import com.tarn.tarn_forum.server.PostsLikedService;
import com.tarn.tarn_forum.server_dbac.dao.PostsLikedMapper;
import com.tarn.tarn_forum.server_dbac.model.PostsLiked;
import com.tarn.tarn_forum.server_dbac.model.PostsLikedCriteria;
import com.tarn.tarn_forum.utils.ResponseData.ResponseCode;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PostsLikedServiceImpl implements PostsLikedService {

    @Autowired
    PostsLikedMapper postsLikedMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public ResponseData postsLikedServiceImpl(String methodDesc, PostsLiked postsLiked) {
        String hashKey = String.valueOf(postsLiked.getUserId()) + "," + String.valueOf(postsLiked.getPostId());
        postsLiked.setLikedTime(new Date());
        if (postsLiked.getLikedStatus() == 1) {
            //取消点赞
            //先查询Redis中是否有点赞记录
            postsLiked.setLikedStatus((byte) 1);
            Object getLikesRedis = redisTemplate.opsForHash().get("postsLiked", hashKey);
            if (getLikesRedis == null) {
                //查询数据库是否有点赞记录
                PostsLikedCriteria ex =new PostsLikedCriteria();
                ex.createCriteria()
                        .andUserIdEqualTo(postsLiked.getUserId())
                        .andPostIdEqualTo(postsLiked.getPostId());
                postsLikedMapper.updateByExampleSelective(postsLiked,ex);
            } else {
                redisTemplate.opsForHash().put("postsLiked", hashKey, JSONObject.toJSONString(postsLiked));
            }
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), "取消" + methodDesc + "成功", "false");
        } else if (postsLiked.getLikedStatus() == 0) {
            //点赞
            postsLiked.setLikedStatus((byte) 0);
            redisTemplate.opsForHash().put("postsLiked", hashKey, JSONObject.toJSONString(postsLiked));
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功", "true");
        }
        return null;
    }

    //定时任务（点赞记录回更到数据库中）
    @Scheduled(cron = "${postsliked.cron}")
    public void retrogressionPostsLiked() {
        Map<Object, Object> hashMap = redisTemplate.opsForHash().entries("postsLiked");
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
                PostsLiked postsLiked = JSONObject.parseObject(String.valueOf(entry.getValue()), PostsLiked.class);
                postsLikedMapper.insertSelective(postsLiked);
                redisTemplate.opsForHash().delete("postsLiked", String.valueOf(entry.getKey()));
            }
        }
    }
}
