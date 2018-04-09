package com.play.bob.base;

/**
 * 接口返回基类
 *
 * @author baobo.peng
 */
public class BaseResult<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示语
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
