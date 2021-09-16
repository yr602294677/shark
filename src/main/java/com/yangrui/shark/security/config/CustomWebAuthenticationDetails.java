package com.yangrui.shark.security.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * @program: WorkCode_Git
 * @description: 获取登陆时的额外校验码
 * @author: 且随意
 * @create: 2021-01-26 13:20
 **/
public class CustomWebAuthenticationDetails  extends WebAuthenticationDetails {
  private static final long serialVersionUID = 6975601077710753878L;
  private final String demo;
  private final String demo_session;

  public CustomWebAuthenticationDetails(HttpServletRequest request) {
    super(request);
    demo = request.getParameter("verifyCode");
     demo_session= (String) request.getSession().getAttribute("verifyCode");
  }

  public String getDemo() {
    return demo;
  }
  public String getDemoSession() {
    return demo_session;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString()).append("; verifyCode: ").append(this.getDemo());
    return sb.toString();
  }

}
