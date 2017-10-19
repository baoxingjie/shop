package com.testgo.springboot.shop.controller;

import com.testgo.springboot.shop.util.MySqlUtil;
import com.testgo.springboot.shop.util.QlUtils;
import com.testgo.springboot.shop.util.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * Created by tianqiao on 16/8/5.
 */
@Controller
public class UtilsController {

    @Autowired
    private QlUtils qlUtils;

    @RequestMapping("/ql")
    public String editor(@RequestParam(value = "statement", required = false) String statement, Model model){

        model.addAttribute("statement", statement);
        if(statement!=null && statement.trim().length()>0) {
            Object result = qlUtils.executeScript(statement);
            model.addAttribute("result", result);
        }
        return "ql";
    }
    
    
    @RequestMapping("/")
    public String hello(){
        return "hello";
    }
    
    @RequestMapping("/db")
    public String db(Model model){
        List<Map<String, Object>> result = MySqlUtil.executeSql("select * from user");
        model.addAttribute("result", result);
        model.addAttribute("systemUtils", new SystemUtils());
        return "db";
    }
    
    
}
