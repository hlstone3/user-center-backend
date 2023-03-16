package com.yupi.usercenter.common;

import com.yupi.usercenter.exception.BusinessException;

public class ResultUtils {
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode){
        return new BaseResponse<>(errorCode);
    }

    public static <T> BaseResponse<T> error(BusinessException businessException){
        return new BaseResponse<>(businessException);
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode,String message){
        return new BaseResponse<>(errorCode,message);
    }

}
