package com.yangrui.shark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/blog")
public class BlogController {

  @RequestMapping("/showBlog")
  public String showEverything(Model model){

    return "thymeleaf/blog/blog";
  }

}
