package com.ssm.pojo;

public class UserTable {
    private Integer id;

    private String userName;

    private String pas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas == null ? null : pas.trim();
    }
}