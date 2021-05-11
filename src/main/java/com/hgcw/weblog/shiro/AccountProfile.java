package com.hgcw.weblog.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hgcw
 * @date 2021/5/11 22:33
 */
@Data
public class AccountProfile implements Serializable {
    private Long id;
    private String username;
    private String avatar;
    private String email;
}
