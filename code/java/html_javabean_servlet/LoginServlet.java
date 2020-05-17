package com.isleslie.mvc.html_javabean_servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isleslie.mvc.jsp_javabean_servlet.version2.User;
import com.isleslie.mvc.jsp_javabean_servlet.version2.UserDao;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String,Object> res = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        //参数认证
        if(StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)){
            //response.sendRedirect("jsp-javabean-servlet/error.jsp?msg=" + URLEncoder.encode("帐号或者密码不能为空","utf-8"));
            res.put("code",1);
            res.put("message","帐号或者密码不能为空");
            mapper.writeValue(response.getWriter(),res);
            return;
        }
        //封装
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //调用dao model
        if(!new UserDao().login(user)){
            //response.sendRedirect("jsp-javabean-servlet/error.jsp?msg=" + URLEncoder.encode("帐号或者密码错误","utf-8"));
            res.put("code",1);
            res.put("message","帐号或者密码错误");
        }else{
            //response.sendRedirect("jsp-javabean-servlet/success.jsp");
            res.put("code",0);
            res.put("message","登录成功！");
        }
        //响应
        mapper.writeValue(response.getWriter(),res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
