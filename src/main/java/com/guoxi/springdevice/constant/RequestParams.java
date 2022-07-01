package com.guoxi.springdevice.constant;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/7/1$
 */


public enum RequestParams {

    /**用户名*/
    USERNAME("username","用户名"),
    /**密码*/
    PASSWORD("password","密码"),
    /**认证*/
    AUTHENTICATION("Authentication","密码");

    private String code;

    private String msg;

    RequestParams(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
