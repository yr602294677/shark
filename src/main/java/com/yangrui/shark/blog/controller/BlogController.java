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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qiesuiyi 博客功能
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

  private final BlogService blogService;

  public BlogController(BlogService blogService) {
    this.blogService = blogService;
  }

  //markdown格式编辑博客，新进入新增页面
  @RequestMapping("/addBlog")
  public String addBlog(Model model){ return "thymeleaf/blog/blog_add";}
  /**
   * 新增博客信息
   */
  @RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
  @ResponseBody
  public String saveBlog(HttpServletRequest request) {
    String blogContent = request.getParameter("blogContent");
    String blogTitle = request.getParameter("blog_title");
    String blogAuthor = request.getParameter("blog_author");
    Date date = new Date();
    String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    Map<String, String> paraMap = new HashMap(16);
    paraMap.put("id", getId());
    paraMap.put("blogContent", blogContent);
    paraMap.put("blogTitle", blogTitle);
    paraMap.put("blogAuthor", blogAuthor);
    paraMap.put("createTime", createTime);
    blogService.saveBlog(paraMap);
    return "";
  }

  private String getId() {
    Date testdate = new Date();
    return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(testdate);
  }

  public static void main(String[] args) {

    Map map=new HashMap();
    map.put("a","aaaa");
    if (null!=map.get("b")) {
      System.out.println("取数成功");
    }else{
      System.out.println("取数失败");
    }

  }

  /**
   * 展示博客列表
   *
   * @param model 用于展示页面
   * @return 列表展示页
   */
  @RequestMapping("/showBlogList")
  public String showBlogList(Model model) {
    List<Map<String, String>> blogList = blogService.getBlogList();
    model.addAttribute("blog_list", blogList);
    return "thymeleaf/blog/blog_list";
  }

  /**
   * 获取博客列表
   */
  @RequestMapping("/getBlogList")
  public String getBlogList(Model model) {
    List<Map<String, String>> blogList = blogService.getBlogList();
    model.addAttribute("blog_list", blogList);
    return "thymeleaf/blog/blog_list";
  }

  @RequestMapping("/priviewBlog")
  public String priviewBlog(@RequestParam("id") String id, Model model) {
    //修改博客热度值
    blogService.changeBlogHeatById(id);
    BlogVO blogVO = blogService.getBlogDetail(id);
    if (blogVO != null) {
      model.addAttribute("blogDetailVO", blogVO);
      blogVO.setBlog_content(MarkDownUtil.mdToHtml(blogVO.getBlog_content()));
    }
    return "thymeleaf/blog/theme/detail";
  }

  /**
   * 根据博客id删除单篇博客
   */
  @RequestMapping("/deleteBlogById")
  public String deleteBlogById(@RequestParam("id") String id, Model model) {
    blogService.deleteBlogById(id);
    List<Map<String, String>> blogList = blogService.getBlogList();
    model.addAttribute("blog_list", blogList);
    return "thymeleaf/blog/blog_list";
  }

  //用于测试postman
  @RequestMapping("/getNum")
  @ResponseBody
  public int getNum() {
    System.out.println("kaishi chuli");
    return 0;
  }

  //博客编辑页面
  @RequestMapping("/editBlog")
  public String editBlog(@RequestParam("id") String id, Model model) {
    model.addAttribute("blog_id",id);
    BlogVO blogVO = blogService.getBlogDetail(id);
    if (blogVO != null) {
      model.addAttribute("blogDetailVO", blogVO);
    }
    return "thymeleaf/blog/blog_edit";
  }
  /**
   * 修改博客信息
   */
  @RequestMapping(value = "/updateBlog", method = RequestMethod.POST)
  @ResponseBody
  public String updateBlog(HttpServletRequest request) {
    String blogContent = request.getParameter("blogContent");
    String blogTitle = request.getParameter("blog_title");
    String blogAuthor = request.getParameter("blog_author");
    String blogId = request.getParameter("blog_id");
    Map<String, String> paraMap = new HashMap(16);
    paraMap.put("id", blogId);
    paraMap.put("blogContent", blogContent);
    paraMap.put("blogTitle", blogTitle);
    paraMap.put("blogAuthor", blogAuthor);
    blogService.updateBlog(paraMap);
    return "";
  }
}
