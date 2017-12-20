package com.example.girl.emums;

public enum ResultEnum {
    UNKONM_ERROR(-1, "未知错误！"),
    UNEXIST_ERROR(-2, "对象不存在！你已删除"),
    SUCCESS(0, "成功!"),
    ERROR(1, "失败！"),
    PRIMARY_SCHOOL(100, "你还在上小学吧！"),
    MIDDLE_SCHOOL(101, "你在上初中吧！"),
    LARGER_SCHOOL(102, "大学啦！"),
    LIFE(103,"社会啦")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
