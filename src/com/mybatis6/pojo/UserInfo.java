package com.mybatis6.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname UserInfo
 * @Description TODO 用户实体类
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-08-01 14:56
 * @Version 1.0
 **/
public class UserInfo {

    private Integer id;
    private String userCode;
    private String userName;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date regDate;

    public String userInfo() {
        return "该用户的用户编码: " + userCode + ", " +
                "用户名: " + userName + ", " +
                "姓名: " + name + ", " +
                "邮箱地址: " + email + ", " +
                "联系电话: " + phone + ", " +
                "联系地址: " + address + ", " +
                "注册时间: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(regDate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
