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


}
