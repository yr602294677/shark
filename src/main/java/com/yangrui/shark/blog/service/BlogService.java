package com.yangrui.shark.blog.service;

import java.util.List;
import java.util.Map;

public interface BlogService {

  void saveBlog(Map<String, String> paraMap);

  List<Map<String, String>> getBlogList();
}
