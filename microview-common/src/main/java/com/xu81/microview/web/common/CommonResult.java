package com.xu81.microview.web.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * HTTP请求返回JSON格式结果公共类
 *
 * @author xinyuan
 * @version 1.0
 * @email xinyuan@xinyuan.com
 */
public class CommonResult<T> implements Serializable {
  /**
   * 返回状态码
   *
   */
  private StatusCodeEnum code;
  /**
   * 操作结果信息，主要用来存储操作失败时对异常信息做出的提示信息
   */
  private String errorMsg;
  /**
   * 操作结果数据集，用来存储要返回给前端的数据，可以是对象、集合等等
   */
  private T data;

  public CommonResult() {
    code = StatusCodeEnum.UNKNOWERROR;
    errorMsg = StatusCodeEnum.UNKNOWERROR.getDesc();
  }

  public CommonResult(StatusCodeEnum code) {
    this.code = code;
  }

  public CommonResult(StatusCodeEnum code, T data) {
    this.code = code;
    this.data = data;
  }

  public CommonResult(StatusCodeEnum code, String errorMsg) {
    this.code = code;
    this.errorMsg = errorMsg;
  }

  public StatusCodeEnum getCode() {
    return code;
  }

  public void setCode(StatusCodeEnum code) {
    this.code = code;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void success(T data) {
    this.setErrorMsg(StatusCodeEnum.SUCCESS.getDesc());
    this.setCode(StatusCodeEnum.SUCCESS);
    this.setData(data);
  }

  public void success(String msg) {
    this.setErrorMsg(msg);
    this.setCode(StatusCodeEnum.SUCCESS);
  }

  public void success(T data, String msg) {
    this.setData(data);
    this.setErrorMsg(msg);
    this.setCode(StatusCodeEnum.SUCCESS);
  }

  public void fail(String msg) {
    this.setErrorMsg(msg);
    this.setCode(StatusCodeEnum.SUCCBUTFAIL);
  }

  public void exception() {
    this.setErrorMsg("服务异常，请稍后重试");
    this.setCode(StatusCodeEnum.HASEXCPTION);
  }

  public void exception(String msg) {
    this.setErrorMsg(msg);
    this.setCode(StatusCodeEnum.HASEXCPTION);
  }

  public void wrongParams(String msg) {
    this.setErrorMsg(msg);
    this.setCode(StatusCodeEnum.WRONGBASEPARAM);
  }

  @JSONField(serialize = false)
  public boolean isSucc() {
    return this.code == StatusCodeEnum.SUCCESS;
  }


  @Override
  public String toString() {
    return JSONObject.toJSONString(this);
  }
}
