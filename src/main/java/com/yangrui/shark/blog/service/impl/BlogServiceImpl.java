package com.yangrui.shark.blog.service.impl;

import com.yangrui.shark.blog.data.BlogVO;
import com.yangrui.shark.blog.mapper.BlogMapper;
import com.yangrui.shark.blog.service.BlogService;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * @author qiesuiyi
 * 博客功能
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

  private final BlogMapper blogMapper;

  public BlogServiceImpl(BlogMapper blogMapper) {
    this.blogMapper = blogMapper;
  }

  @Override
  public void saveBlog(Map<String, String> paraMap) {
    blogMapper.saveBlog(paraMap);
  }

  @Override
  public List<Map<String, String>> getBlogList() {

    return blogMapper.getBlogList();
  }

  @Override
  public BlogVO getBlogDetail(String id) {
    return blogMapper.getBlogDetail(id);
  }

  @Override
  public void deleteBlogById(String id) {
    blogMapper.deleteBlogById(id);
  }
}
