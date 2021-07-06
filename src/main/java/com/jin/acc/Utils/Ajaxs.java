package com.jin.acc.Utils;

public class Ajaxs {
    String code;
    String msg;

    public Ajaxs() {

    }
    public Ajaxs(String code,String msg) {
        this.code=code;this.msg = msg;
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
