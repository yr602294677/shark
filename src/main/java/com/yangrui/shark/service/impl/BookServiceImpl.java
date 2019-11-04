package com.yangrui.shark.service.impl;

import com.yangrui.shark.data.BookDO;
import com.yangrui.shark.mapper.BookMapper;
import com.yangrui.shark.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {

  @Autowired
  private BookMapper bookMapper;

  @Override
  public List<BookDO> listBooks() {
    List<BookDO> bookList= bookMapper.listBooks();
    return bookList;
  }
}
