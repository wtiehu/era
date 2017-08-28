package com.went.core.utils;

import java.io.Serializable;
import java.util.Map;

import static com.went.core.base.BaseConstants.STATUS_SUCCESS;

/**
 * Service 返回的结果
 *
 * Create By HCL at 2017/7/31
 */
public class ServiceResult<T> implements Serializable {

  private static final long serialVersionUID = 812376774103405857L;

  private int state = STATUS_SUCCESS;
  private String message = "";
  private T data;
  private Map extra;

  /**
   * 空的构造方法，供 json 转换时使用
   *
   * Create By HCL at 2017/8/7
   */
  public ServiceResult() {
  }

  /**
   * 全参数构造方法
   *
   * @param data 数据信息
   * @param state 状态
   * @param message 消息
   */
  public ServiceResult(T data, int state, String message) {
    this.state = state;
    this.message = message;
    this.data = data;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Map getExtra() {
    return extra;
  }

  public void setExtra(Map extra) {
    this.extra = extra;
  }

  public static ServiceResult Msg(int state,String message){
    return new ServiceResult(null, state,message);
  }
}