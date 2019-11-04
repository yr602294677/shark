package com.yangrui.shark.mapper;

import com.yangrui.shark.data.BookDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookMapper {

  List<BookDO> listBooks();
}
