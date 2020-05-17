package com.isleslie.mvc.jsp_javabean_servlet.version1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/requestServlet_v1")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("".equals(username) || "".equals(password)){
            response.sendRedirect("jsp-javabean-servlet/error.jsp?msg=" + URLEncoder.encode("帐号或者密码不能为空","utf-8"));
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(!user.login()){
            response.sendRedirect("jsp-javabean-servlet/error.jsp?msg=" + URLEncoder.encode("帐号或者密码错误","utf-8"));
        }else{
            response.sendRedirect("jsp-javabean-servlet/success.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
