package com.yangrui.shark.controller;

import com.yangrui.shark.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/system")
public class SystemController {
  @Autowired
  private BlogService blogService;

  //首页
  @RequestMapping("/showIndex")
  public String showBook(ModelMap map){
    return "thymeleaf/index";
  }
  //首页 介绍信息页面
  @RequestMapping("/showIndexDescription")
  public String showIndexDescription(ModelMap map){
    return "thymeleaf/system/description";
  }

  //首页 个人博客菜单页面
  @RequestMapping("/showBlogOfQiesuiyi")
  public String showBlogOfQiesuiyi(Model model){
    return "thymeleaf/blog/blog";
  }


}
