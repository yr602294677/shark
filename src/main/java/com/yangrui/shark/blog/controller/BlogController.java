package com.yangrui.shark.blog.controller;

import com.yangrui.shark.blog.data.BlogVO;
import com.yangrui.shark.blog.service.BlogService;
import com.yangrui.shark.utils.MarkDownUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/blog")
public class BlogController {

  @Autowired
  private BlogService blogService;

  /**
   * 新增博客信息
   */
  @RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
  @ResponseBody
  public String saveBlog(HttpServletRequest request) {
    String blogContent = request.getParameter("blogContent");
    String blog_title = request.getParameter("blog_title");
    String blog_author = request.getParameter("blog_author");

    Map<String,String> paraMap=new HashMap();
    paraMap.put("id",getId());
    paraMap.put("blogContent",blogContent);
    paraMap.put("blog_title",blog_title);
    paraMap.put("blog_author",blog_author);

    blogService.saveBlog(paraMap);
    return "";
  }

  private  String getId() {
    Date testdate= new Date();;
    String id= new SimpleDateFormat("yyyyMMddHHmmssSSS").format(testdate);
    return id;
  }

  //展示博客列表
  @RequestMapping("/showBlogList")
  public String showBlogList(Model model){
    List<Map<String,String>> blogList= blogService.getBlogList();
    model.addAttribute("blog_list",blogList);
    return "thymeleaf/blog/blog_list";
  }

  /**
   * 获取博客列表
   */
  @RequestMapping("/getBlogList")
  public String getBlogList( Model model){
    List<Map<String,String>> blogList= blogService.getBlogList();
    model.addAttribute("blog_list",blogList);
    return  "thymeleaf/blog/blog_list";
  }

//  @RequestMapping("/priviewBlog")
//  public String priviewBlog(@RequestParam("id") String id, HttpServletRequest request){
//    BlogVO blogVO = blogService.getBlogDetail(id);
//    if (blogVO != null) {
//      request.setAttribute("blogDetailVO", blogVO);
//      //request.setAttribute("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
//    }
//    request.setAttribute("pageName", "详情");
//    //request.setAttribute("configurations", configService.getAllConfigs());
//    return "thymeleaf/blog/theme/detail";
//  }
  @RequestMapping("/priviewBlog")
  public String priviewBlog(@RequestParam("id") String id, Model model){
    BlogVO blogVO = blogService.getBlogDetail(id);
    if (blogVO != null) {
      model.addAttribute("blogDetailVO", blogVO);
      blogVO.setBlog_content(MarkDownUtil.mdToHtml(blogVO.getBlog_content()));
      //request.setAttribute("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
    }

    //request.setAttribute("configurations", configService.getAllConfigs());
    return "thymeleaf/blog/theme/detail";
  }
  /**
   * 获取单篇博客信息
   */
//  @RequestMapping({"/blog/{blogId}"})
//  public String detail(HttpServletRequest request, @PathVariable("blogId") Long blogId, @RequestParam(value = "commentPage", required = false, defaultValue = "1") Integer commentPage) {
//    BlogVO blogVO = blogService.getBlogDetail(blogId);
//    if (blogVO != null) {
//      request.setAttribute("blogDetailVO", blogVO);
//      //request.setAttribute("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
//    }
//    request.setAttribute("pageName", "详情");
//    //request.setAttribute("configurations", configService.getAllConfigs());
//    return "blog/theme/detail";
//  }
}
