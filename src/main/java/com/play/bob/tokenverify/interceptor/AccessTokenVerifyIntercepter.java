package com.play.bob.tokenverify.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截器
 * 验证token是否有效
 *
 * @author baobo.peng
 */
@Component
public class AccessTokenVerifyIntercepter extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(AccessTokenVerifyIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("AccessToken checking ...");
        boolean result = false;
        String token = request.getParameter("token");
        if (!StringUtils.isEmpty(token)) {
            result = true;
            logger.info("AccessToken verify success");
        } else {
            response.getWriter().print("AccessToken Error");
            logger.info("AccessToken verify failed");
        }
        return result;
    }
}
