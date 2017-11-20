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
        return "index";
    };

    /**
     * 登录
     * */
    @Autowired
    private UsersesMapper usersesMapper;
    @RequestMapping(value = "login")
    @ResponseBody
    public Map login(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String pwd=request.getParameter("pwd");
        HashMap<Object, Object> map = new HashMap<>();
        Userses userses = new Userses();
        userses.setPwd(pwd);
        userses.setUserName(userName);
        List<Userses> list = usersesMapper.selectList(userses);
        map.put("mes",list);
        return map;
    };
}
