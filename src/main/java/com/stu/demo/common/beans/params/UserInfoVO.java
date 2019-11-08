package com.stu.demo.common.beans.params;


public class UserInfoVO {

    private Integer ID;
    private String userName;
    private String password;
    private String realName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return realName;
    }

    public void setNickName(String nickName) {
        this.realName = nickName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
