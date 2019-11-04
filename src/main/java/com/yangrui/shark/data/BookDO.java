package com.yangrui.shark.data;
import javax.persistence.Column;

public class BookDO {

  @Column(name="book_id")
  private String id;
  @Column(name="book_name")
  private String name;
  @Column(name="book_state")
  private String state;
  @Column(name="book_description")
  private String description;



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
