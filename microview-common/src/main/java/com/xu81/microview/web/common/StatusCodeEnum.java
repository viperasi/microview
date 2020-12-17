package com.xu81.microview.web.common;

/**
 * @author viperasi@gmail.com
 * Created by xumin on 2018/5/10.
 */
public enum StatusCodeEnum {
    SUCCESS(100200, "执行成功"),
    SUCCBUTFAIL(101200, "执行成功但结果失败"),
    NOTSERVICE(100100, "暂无服务"),
    HASEXCPTION(100500, "接口执行异常"),
    NOTFOUND(100404, "未知接口"),
    FORBIDDEN(100403, "无权限访问"),
    WRONGBASEPARAM(100400, "基础参数错误"),
    TIMEERROR(100408, "时间不匹配"),
    WRONGBASEAUTH(100401, "身份验证失败"),
    //    WRONGAPIAUTH("10004", "接口权限错误"),
//    WRONGPARAM("10005", "参数错误"),
    UNKNOWERROR(100520, "未知错误"),
    //新增公众号关注判断
    // 微信 /usr/info 接口返回 subscribe=0时 则用户未关注公众号
    NOTSUBSCRIBE(100413, "未关注公众号");

    private int index;
    private String desc;

    StatusCodeEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
