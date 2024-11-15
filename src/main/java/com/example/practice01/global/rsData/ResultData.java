package com.example.practice01.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultData<T> {
    private ResultCode resultCode;
    private String msg;
    private T data;
    private boolean isSuccess;

    public static <T> ResultData<T> of(ResultCode resultCode, String msg, T data) {
        return new ResultData<>(resultCode, msg, data, resultCode.getCode().startsWith("S-"));
    }
    public static <T> ResultData<T> of(ResultCode resultCode, String msg) {
        return new ResultData<>(resultCode, msg, null, resultCode.getCode().startsWith("S-"));
    }

}
