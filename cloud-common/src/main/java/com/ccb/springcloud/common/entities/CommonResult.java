package com.ccb.springcloud.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResult {

    public transient final static Integer SUCCESS_CODE = 0;

    public transient final static String SUCCESS_MSG = "ok";

    public transient final static Integer DEFAULT_FAIL_CODE = -1;

    public transient final static String DEFAULT_FAIL_MSG = "fail";


    private Integer code;

    private String msg;

    private Object data;

    public static CommonResult success() {
        return success(null);
    }

    public static CommonResult success(Object data) {
        return new CommonResult(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static CommonResult fail(Throwable throwable) {
        return fail(throwable.getMessage());
    }

    public static CommonResult fail(String msg) {
        return fail(DEFAULT_FAIL_CODE, msg);
    }

    public static CommonResult fail(int code, String msg) {
        return new CommonResult(code, msg, null);
    }
}
