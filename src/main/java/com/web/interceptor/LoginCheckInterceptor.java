package com.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.web.pojo.Result;
import com.web.utils.JwtUtils;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override //目标资源方法运行前运行, 返回true: 放行, 放回false, 不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        // 1. 处理 CORS 预检请求
        log.info("请求的url: {}",url);
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        if(url.contains("login")){
            log.info("登录操作, 放行...");
            return true;
        }
        // 3.获取请求头中的Authorization字段。
        String authorizationHeader = request.getHeader("Authorization");
        // 4.判断Authorization头是否存在，且格式是否正确。
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            log.info("请求头token为空,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        // 5.提取JWT令牌
        String jwt = authorizationHeader.substring(7); // 去掉"Bearer "前缀

        //6.解析token，如果解析失败，返回错误结果（未登录）。
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//jwt解析失败
            log.info("解析令牌失败, 返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        //6.放行。
        return true;
    }

    @Override //目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
    }

    @Override //视图渲染完毕后运行, 最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
