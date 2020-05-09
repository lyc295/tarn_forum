package com.tarn.tarn_forum.utils.Jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tarn.tarn_forum.server_dbac.model.UserInfo;

public class TokenUtil {

    //生成token
    public static String getToken(UserInfo userInfo) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(userInfo.getUserId()))
                .sign(Algorithm.HMAC256(userInfo.getUserPwd()));
        return token;
    }
}
