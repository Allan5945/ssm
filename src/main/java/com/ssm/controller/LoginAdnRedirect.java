package com.ssm.controller;

import com.ssm.pojo.UserTable;
import com.ssm.pojo.UserTableExample;
import com.ssm.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class LoginAdnRedirect {
    /**
     * 重定向到主页
     * */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return "index";
    };

    /**
     * 登录
     * */
    @Autowired
    private UserLoginService userLoginService;
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Map login(){
        HashMap<Object, Object> map = new HashMap<>();
        UserTable selectByPrimaryKey = userLoginService.selectByPrimaryKey(1);
        map.put("sis",selectByPrimaryKey);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        UserTableExample userTableExample = new UserTableExample();
        userTableExample.createCriteria().andIdIsNotNull();
        int i = userLoginService.countByExample(userTableExample);

        List<UserTable> userTables = userLoginService.selectByExample(userTableExample);
        for(UserTable key : userTables){
//            System.out.println(key.getId());
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return map;
    };
}
