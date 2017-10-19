package com.testgo.springboot.shop.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianqiao on 17/10/19.
 */
public class MySqlUtil {
    
    public static List<Map<String,Object>> executeSql(String sql)
    {
        try {
            List<Map<String,Object>> result= new ArrayList<Map<String,Object>>();
            //数据库信息  
            String userName = "root";
            //密码   
            String userPasswd = "Bxj123456";
            //数据库名   
            String dbName = "testgo";
            
            //将数据库信息字符串连接成为一个完整的url（也可以直接写成url，分开写是明了可维护性强）   
            String url = "jdbc:mysql://localhost:3306/" + dbName + "?user=" + userName + "&password=" + userPasswd;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while(rs.next()){
                Map rowData = new HashMap();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                result.add(rowData);
            }
            rs.close();
            stmt.close();
            conn.close();
            return result;
        }catch (Exception e){
            return null;
        }
    }
}
