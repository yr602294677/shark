package com.yangrui.shark.security.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @program: WorkCode_Git
 * @description: 登陆验证类
 * @author: 且随意
 * @create: 2021-01-26 13:23
 **/
public class CustomAuthenticationProvider implements AuthenticationProvider {
  @Autowired
  private HttpServletRequest request;

  @Override
  public Authentication authenticate(Authentication authentication)
      throws AuthenticationException {
    CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();  // 如上面的介绍，这里通过authentication.getDetails()获取详细信息
    // System.out.println(details); details.getRemoteAddress(); details.getSessionId(); details.getDemo();
    // 下面是验证逻辑，验证通过则返回UsernamePasswordAuthenticationToken，
    // 否则，可直接抛出错误（AuthenticationException的子类，在登录验证不通过重定向至登录页时可通过session.SPRING_SECURITY_LAST_EXCEPTION.message获取具体错误提示信息）
    if(!request.getSession().getAttribute("text").toString().equalsIgnoreCase(details.getDemo()))//用户输入的和验证码不一致
    {
      System.out.println(request.getSession().getAttribute("text").toString()+"    "+details.getDemo());
      throw new BadCredentialsException("验证码不正确");
    }
    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }


}
