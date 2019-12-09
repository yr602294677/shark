package com.yangrui.shark.blog.mapper;

import com.yangrui.shark.blog.data.BlogVO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BlogMapper {

  void saveBlog(Map<String, String> paraMap);

  List<Map<String, String>> getBlogList();

  BlogVO getBlogDetail(String blogId);
}
