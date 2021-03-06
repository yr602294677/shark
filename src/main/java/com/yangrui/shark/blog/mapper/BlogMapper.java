
package com.yangrui.shark.blog.mapper;

import com.yangrui.shark.blog.data.BlogVO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * @author qiesuiyi
 * 博客功能
 */
@Mapper
@Repository
public interface BlogMapper {

  void saveBlog(Map<String, String> paraMap);

  List<Map<String, String>> getBlogList();

  BlogVO getBlogDetail(String blogId);
  
  void deleteBlogById(String id);

  void changeBlogHeatById(String id);

  void updateBlog(Map<String, String> paraMap);
}
