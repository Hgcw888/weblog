package com.hgcw.weblog.shiro;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import cn.hutool.json.JSONUtil;
import com.hgcw.weblog.common.lang.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * @author hgcw
 * @date 2021/5/11 19:20
 * 定义jwt的过滤器JwtFilter。
 * 拿到jwt进行登录处理
 */
@Component
public class JwtFilter extends AuthenticatingFilter {
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * @return createToken：执行onAccessDenied（）实现登录，我们需要生成我们自定义支持的JwtToken
     * 生成token交给shrio校验
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServerRequest request = (HttpServerRequest) servletRequest;
        String jwt = request.getHeader("Authorization");
        if (StringUtils.isEmpty(jwt)) {
            return null;
        }
        //调用JwtToken工具类生成token
        return new JwtToken(jwt);
    }


    /**
     * onAccessDenied：拦截校验，当头部没有Authorization时候，
     * 我们直接通过，不需要自动登录；当带有的时候，
     * 首先我们校验jwt的有效性，没问题我们就直接执行executeLogin方法实现自动登录
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServerRequest request = (HttpServerRequest) servletRequest;
        String jwt = request.getHeader("Authorization");
        //判断是否有token
        if (StringUtils.isEmpty(jwt)) {
            return true;
        } else {
            //如果有token校验jwt
            Claims claimByToken = jwtUtils.getClaimByToken(jwt);
            if (claimByToken == null || jwtUtils.isTokenExpired(claimByToken.getExpiration())) {
                throw new ExpiredCredentialsException("token已经失效，请重新登录");
            }
            //登录
            return executeLogin(servletRequest, servletResponse);
        }
    }

    /**
     * 如果登录异常的话就将异常的数据返回给前端
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServerResponse httpServerResponse = (HttpServerResponse) response;
        Throwable throwable = e.getCause() == null ? e : e.getCause();
        Result result = Result.fail(throwable.getMessage());
        String json = JSONUtil.toJsonStr(result);

        try {
            httpServerResponse.getWriter().println(json);
        } catch (Exception exception) {

        }
        return false;
    }
}
