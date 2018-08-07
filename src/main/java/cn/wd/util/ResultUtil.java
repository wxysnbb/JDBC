package cn.wd.util;

/**
 * 这是所有返回值的工具类
 * 01.正确  或者  错误
 * 02.错误信息
 * 03.正确的时候  有可能有数据
 */
public class ResultUtil {

    private int status;//状态   1是成功  0是失败
    private String message;//错误信息
    private Object date;//返回数据

    //成功的方法
    public ResultUtil resultSuccess(Object data){
        this.date=data;
        this.status=1;
        return this;
    }

    //失败的方法
    public ResultUtil resultFail(String message){
        this.message=message;
        this.status=0;
        return this;
    }

    public ResultUtil(int status, String message, Object data) {
        this.message=message;
        this.status=0;
        this.date=data;
    }

    //无参构造
    public ResultUtil() {}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }









}
