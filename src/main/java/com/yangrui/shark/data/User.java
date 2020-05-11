package com.yangrui.shark.data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "user")
public class User {
  @Column(name = "id")
  private String id;   //主键
  @Column(name = "user_uuid")
  private String userUuid;   //用户UUID
  @Column(name = "username")
  private String username;    //用户名
  @Column(name = "password")
  private String password;    //用户密码
  @Column(name = "email")
  private String email;       //用户邮箱
  @Column(name = "telephone")
  private String telephone;   //电话号码
  @Column(name = "role")
  private String role;        //用户角色
  @Column(name = "image")
  private String image;       //用户头像
  @Column(name = "last_ip")
  private String lastIp;     //上次登录IP
  @Column(name = "last_time")
  private String lastTime;   //上次登录时间


  public String getId() {
    return id;
  }


  public String getUserUuid() {
    return userUuid;
  }

  public void setUserUuid(String userUuid) {
    this.userUuid = userUuid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getLastIp() {
    return lastIp;
  }

  public void setLastIp(String lastIp) {
    this.lastIp = lastIp;
  }

  public String getLastTime() {
    return lastTime;
  }

  public void setLastTime(String lastTime) {
    this.lastTime = lastTime;
  }
  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", userUuid='" + userUuid + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        ", telephone='" + telephone + '\'' +
        ", role='" + role + '\'' +
        ", image='" + image + '\'' +
        ", lastIp='" + lastIp + '\'' +
        ", lastTime='" + lastTime + '\'' +
        '}';
  }
}
