package com.yangrui.shark.blog.service;

import com.yangrui.shark.blog.data.BlogVO;
import java.util.List;
import java.util.Map;
/**
 * @author qiesuiyi
 * 博客功能
 */
public interface BlogService {

  void saveBlog(Map<String, String> paraMap);

  List<Map<String, String>> getBlogList();

  BlogVO getBlogDetail(String blogId);

  void deleteBlogById(String id);

  void changeBlogHeatById(String id);

  void updateBlog(Map<String, String> paraMap);
}
