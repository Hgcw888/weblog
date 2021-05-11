package com.hgcw.weblog.shiro;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author hgcw
 * @date 2021/5/11 21:27
 * jwt生成token
 *jwt中使用
 */
@Data
public class JwtToken  implements AuthenticationToken {
    private  String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
