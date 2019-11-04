package com.yangrui.shark.controller;

import com.yangrui.shark.data.BookDO;
import com.yangrui.shark.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/book")
public class BookController  {
  @Autowired
  private BookService bookService;


  @RequestMapping("/showBookInfo")
  public String index(ModelMap map){
    map.addAttribute("name","haozz");
    return "thymeleaf/index";
  }

  @RequestMapping("/showBook")
  public String showBook(ModelMap map){
    List<BookDO> bookList=bookService.listBooks();
    map.put("bookList",bookList);
    return "thymeleaf/index";
  }
  @RequestMapping("/addBook")
  public String addBook(ModelMap map){

    return "thymeleaf/book/addbook";
  }
}
