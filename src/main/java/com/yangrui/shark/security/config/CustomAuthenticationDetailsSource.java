package com.yangrui.shark.security.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * @program: WorkCode_Git
 * @description: 登录信息
 * @author: 且随意
 * @create: 2021-01-26 13:21
 **/

@Component
public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

  @Override
  public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
    return new CustomWebAuthenticationDetails(context);
  }

}
