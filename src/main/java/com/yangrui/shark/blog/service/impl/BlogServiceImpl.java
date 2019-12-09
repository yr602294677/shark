package com.yangrui.shark.blog.service.impl;

import com.yangrui.shark.blog.mapper.BlogMapper;
import com.yangrui.shark.blog.service.BlogService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("blogService")
public class BlogServiceImpl implements BlogService {

  @Autowired
  private BlogMapper blogMapper;

  @Override
  public void saveBlog(Map<String, String> paraMap) {
    blogMapper.saveBlog(paraMap);
  }

  @Override
  public List<Map<String, String>> getBlogList() {
    return  blogMapper.getBlogList();
  }
}
