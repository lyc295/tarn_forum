package com.tarn.tarn_forum.utils.Exception;

import com.tarn.tarn_forum.utils.ResponseData.ResponseCode;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.tarn.tarn_forum")
public class WebExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseData unknownException(Exception e) {
        logger.error("程序出现异常" , e.getMessage());
        return ResponseData.init(ResponseCode.FAIL.getValue(), "异常捕获:"+e.getMessage());
    }
}