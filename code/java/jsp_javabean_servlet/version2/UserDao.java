package com.isleslie.mvc.jsp_javabean_servlet.version2;

public class UserDao {
    public boolean login(User user){
        System.out.println(user);
        boolean flag = false;
        if("admin".equals(user.getUsername()) && "admin".equals(user.getUsername())){
            flag = true;
        }
        return flag;
    }
}
