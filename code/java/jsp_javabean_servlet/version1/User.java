package com.isleslie.mvc.jsp_javabean_servlet.version1;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

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

    public boolean login(){
        boolean flag = false;
        if("admin".equals(username) && "admin".equals(password)){
            flag = true;
        }
        return flag;
    }
}
