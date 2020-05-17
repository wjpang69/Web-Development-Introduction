package com.isleslie.mvc.jsp_javabean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryBean implements Serializable {
    private Integer id;
    private String name;
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<QueryBean> query(){
        List<QueryBean> ret = new ArrayList<>();
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/homework","root","123456789");
            //预编译SQL
            String sql = "select * from goods";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //执行SQL
            ResultSet res = pstmt.executeQuery();
            QueryBean queryBean;
            while(res.next()){
                queryBean = new QueryBean();
                queryBean.setId(res.getInt(1));
                queryBean.setName(res.getString(2));
                queryBean.setMoney(res.getDouble(3));
                ret.add(queryBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
