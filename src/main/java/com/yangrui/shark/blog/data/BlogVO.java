package com.yangrui.shark.blog.data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "blog")
public class BlogVO {

  @Column(name = "blog_id")
  private String id;

  @Column(name = "blog_title")
  private String blog_title;

  @Column(name = "blog_content")
  private String blog_content;

  @Column(name = "blog_author")
  private String blog_author;

  @Column(name = "create_time")
  private String create_time;

  //热度，即点击次数
  @Column(name = "blog_heat")
  private Integer blog_heat;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBlog_title() {
    return blog_title;
  }

  public void setBlog_title(String blog_title) {
    this.blog_title = blog_title;
  }

  public String getBlog_content() {
    return blog_content;
  }

  public void setBlog_content(String blog_content) {
    this.blog_content = blog_content;
  }

  public String getBlog_author() {
    return blog_author;
  }

  public void setBlog_author(String blog_author) {
    this.blog_author = blog_author;
  }

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
    this.create_time = create_time;
  }

  public Integer getBlog_heat() {
    return blog_heat;
  }

  public void setBlog_heat(Integer blog_heat) {
    this.blog_heat = blog_heat;
  }
}
