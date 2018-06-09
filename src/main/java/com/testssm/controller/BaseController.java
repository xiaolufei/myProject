package com.testssm.controller;


import com.testssm.enums.ErrorCodeEnum;
import com.testssm.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 超级父类
 * </p>
 *
 * @author hubin
 * @Date 2017-02-12
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    /**
     * <p>
     * RestResult 成功结果
     * </p>
     *
     * @param data 返回对象
     * @return
     */
    protected <T> RestResult<T> success(T data) {
        return restResult(data, ErrorCodeEnum.SUCCESS);
    }

    /**
     * <p>
     * RestResult 失败结果
     * </p>
     *
     * @param data 返回对象
     * @return
     */
    protected <T> RestResult<T> failed(T data) {
        return restResult(data, ErrorCodeEnum.FAILED);
    }

    /**
     * <p>
     * RestResult 返回结果
     * </p>
     *
     * @param data          返回对象
     * @param errorCodeEnum 返回错误码
     * @return
     */
    protected <T> RestResult<T> restResult(T data, ErrorCodeEnum errorCodeEnum) {
        RestResult<T> result = new RestResult<T>();
        result.setCode(errorCodeEnum.getCode());
        result.setData(data);
        result.setMsg(errorCodeEnum.getMsg());
        return result;
    }

}
