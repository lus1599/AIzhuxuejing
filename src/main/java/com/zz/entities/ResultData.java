package com.zz.entities;

public class ResultData {

    private Integer code;//返回的状态码
    private String message;//返回页面信息
    private Object data;//返回具体数据
    private int page;//当前页面
    private int count;//总条数
    private int limit;//每页显示的条数

    /**
     * 分页，存放信息
     *
     * @param code
     * @param message
     * @param data
     * @param page
     * @param count
     * @param limit
     */
    public ResultData(Integer code, String message, Object data, int page, int count, int limit) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.page = page;
        this.count = count;
        this.limit = limit;
    }

    /**
     * 数据有错调用，自定义状态码返回
     *
     * @param code
     * @param message
     * @param data
     */
    public ResultData(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 只传返回信息，状态默认值为200
     *
     * @param message
     * @param data
     */
    public ResultData(String message, Object data) {
        this.code = 200;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功时候调用，默认200，返回信息成功，只填入返回的数据。
     *
     * @param
     */
    public static ResultData ok(Object data) {
        return new ResultData(200, "ok", data);
    }

    public ResultData() {

    }

    public static ResultData err(String msg) {
        return new ResultData(400, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", page=" + page +
                ", count=" + count +
                ", limit=" + limit +
                '}';
    }
}
