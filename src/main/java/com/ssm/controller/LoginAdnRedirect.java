package com.ssm.controller;

import com.ssm.mapper.UsersesMapper;
import com.ssm.pojo.UserTable;
import com.ssm.pojo.UserTableExample;
import com.ssm.pojo.Userses;
import com.ssm.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class LoginAdnRedirect {

    /**
     * get请求未找到从定向到主页
     * */
    @Autowired
    private UsersesMapper usersesMapper;
    @RequestMapping(value = "err",method = RequestMethod.GET)
    public static void index(HttpServletRequest request,HttpServletResponse response){


        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    /**
     * 重定向到主页
     * */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String reindex(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        List<Userses> list = usersesMapper.selectList();
        System.out.println(list);
        for(Userses attribute : list) {
            System.out.println(attribute.getUserName());
            System.out.println(attribute.getId());
            System.out.println(attribute.getPwd());
        }
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
