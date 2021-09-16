package com.yangrui.shark.blog.controller;

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

import com.yangrui.shark.blog.data.BlogVO;
import com.yangrui.shark.blog.service.BlogService;
import com.yangrui.shark.utils.MarkDownUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author qiesuiyi 博客功能
 */
@Api("博客管理api")
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

	private final BlogService blogService;

	public BlogController(BlogService blogService) {
		this.blogService = blogService;
	}

	// markdown格式编辑博客，新进入新增页面
	@ApiOperation("新增博客")
	// @RequestMapping("/addBlog")
	@RequestMapping(value = "/addBlog", method = RequestMethod.GET)
	public String addBlog(Model model) {
		return "thymeleaf/blog/blog_add";
	}

	/**
	 * 新增博客信息
	 */
	@RequestMapping(value = "/saveBlog", method = RequestMethod.GET)
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

	/**
	 * 展示博客列表
	 *
	 * @param model
	 *            用于展示页面
	 * @return 列表展示页
	 */
	@RequestMapping(value = "/showBlogList", method = RequestMethod.GET)
	public String showBlogList(Model model) {
		List<Map<String, String>> blogList = blogService.getBlogList();
		model.addAttribute("blog_list", blogList);
		return "thymeleaf/blog/blog_list";
	}

	/**
	 * 获取博客列表
	 */
	@RequestMapping(value = "/getBlogList", method = RequestMethod.GET)
	public String getBlogList(Model model) {
		List<Map<String, String>> blogList = blogService.getBlogList();
		model.addAttribute("blog_list", blogList);
		return "thymeleaf/blog/blog_list";
	}

	@RequestMapping(value = "/priviewBlog", method = RequestMethod.GET)
	@ApiImplicitParam(name = "id", value = "博客ID", required = true, dataType = "String")
	public String priviewBlog(@RequestParam("id") String id, Model model) {
		// 修改博客热度值
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
	@RequestMapping(value = "/deleteBlogById", method = RequestMethod.GET)
	public String deleteBlogById(@RequestParam("id") String id, Model model) {
		blogService.deleteBlogById(id);
		List<Map<String, String>> blogList = blogService.getBlogList();
		model.addAttribute("blog_list", blogList);
		return "thymeleaf/blog/blog_list";
	}

	// 博客编辑页面
	@RequestMapping(value = "/editBlog", method = RequestMethod.GET)
	public String editBlog(@RequestParam("id") String id, Model model) {
		model.addAttribute("blog_id", id);
		BlogVO blogVO = blogService.getBlogDetail(id);
		if (blogVO != null) {
			model.addAttribute("blogDetailVO", blogVO);
		}
		return "thymeleaf/blog/blog_edit";
	}

	/**
	 * 修改博客信息
	 */
	@RequestMapping(value = "/updateBlog", method = RequestMethod.GET)
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
