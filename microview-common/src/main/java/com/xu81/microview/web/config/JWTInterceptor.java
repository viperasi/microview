package com.xu81.microview.web.config;

import com.alibaba.fastjson.JSONObject;
import com.xu81.microview.web.common.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author viperasi@gmail.com
 */
public class JWTInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(JWTInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String origin = httpServletRequest.getHeader("origin");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Authorization, Token, Content-Type, Accept");
        // 可选，是否允许Cookie
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "1728000");
        if (RequestMethod.OPTIONS.name().equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
//        String requestURI = httpServletRequest.getRequestURI();
//        String tokenStr = httpServletRequest.getParameter("token");
//        CommonResult result = new CommonResult();
//        if (!StringUtils.contains(requestURI, "/doLoginJSON")) {
//            String token = httpServletRequest.getHeader("token");
//            if (StringUtils.isBlank(token) && StringUtils.isBlank(tokenStr)) {
//                result.setCode(StatusCodeEnum.WRONGBASEAUTH);
//                //TODO:字符串统一处理
//                result.setErrorMsg("用户需要重新登陆.");
//                dealErrorReturn(httpServletRequest, httpServletResponse, result);
//                return false;
//            }
//            if (tokenStr != null) {
//                token = tokenStr;
//            }
//            //从请求头中获取token
//            Map<String, Object> resultMap = JWTUtil.validToken(token);
//            TokenStateEnum state = TokenStateEnum.getTokenState((String) resultMap.get("state"));
//            boolean isValid = false;
//            switch (state) {
//                case VALID:
//                    isValid = true;
//                    httpServletRequest.setAttribute("sir", ((Map<String, Object>) resultMap.get("data")).get("user"));
//                    httpServletResponse.setHeader("Access-Control-Expose-Headers", "token");
//                    httpServletResponse.setHeader("token", JWTUtil.createToken((Map<String, Object>) resultMap.get("data")));
//                    break;
//                case EXPIRED:
//                case INVALID:
//                    //token过期或者无效，则输出错误信息返回给ajax
//                    result.setCode(StatusCodeEnum.WRONGBASEAUTH);
//                    //TODO:字符串统一处理
//                    result.setErrorMsg("用户需要重新登陆.");
//                    dealErrorReturn(httpServletRequest, httpServletResponse, result);
//                    isValid = false;
//                    break;
//                default:
//                    break;
//            }
//            return isValid;
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

    /**
     * 检测到没有token，直接返回不验证
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param obj
     */
    public void dealErrorReturn(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, CommonResult obj) {
        String json = JSONObject.toJSONString(obj);
        PrintWriter writer = null;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        try {
            writer = httpServletResponse.getWriter();
            writer.print(json);
        } catch (IOException ex) {
            logger.error("response error", ex);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}