package com.example.girl.exception;

import com.example.girl.emums.ResultEnum;

public class GirlException extends RuntimeException {
    private Integer code;
    private ResultEnum resultEnum;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
        this.resultEnum = resultEnum;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }
}
