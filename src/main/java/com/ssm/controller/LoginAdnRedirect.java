package com.ssm.controller;

import com.ssm.mapper.RecordMapper;
import com.ssm.mapper.UsersesMapper;
import com.ssm.pojo.Record;
import com.ssm.pojo.Userses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class LoginAdnRedirect {
    @Autowired
    private UsersesMapper usersesMapper;
    @Autowired
    private RecordMapper recordMapper;

    /**
     * get请求未找到从定向到主页
     * */
    @RequestMapping(value = "err",method = RequestMethod.GET)
    public static void index(HttpServletRequest request,HttpServletResponse response){
//        try {
//            response.sendRedirect("/");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    };

    /**
     * 重定向到主页
     * */
    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String reindex(){
        return "index";
    };
    /**
     * 登录
     * */

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 跨域头部代码
//        response.setHeader("Access-Control-Allow-Origin","*");
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        Userses userses = new Userses();
        HttpSession session = request.getSession();
        userses.setUserName(userName);
        userses.setPwd(pwd);
        List<Userses> userList = usersesMapper.selectList(userses);
        HashMap<String , Map> map = new HashMap<>();
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        if(userList.size() != 0){
            session.setAttribute("userMes",userList.get(0));
            objectObjectHashMap.put("type",true);
        }else{
            objectObjectHashMap.put("type",false);
        }
        map.put("mes",objectObjectHashMap);
        return map;
    };

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request){
        final HttpSession session = request.getSession();
        if(session.getAttribute("userMes") != null){
            return "index";
        }else{
            return "login";
        }
    }

    @RequestMapping(value = "/progress",method = RequestMethod.GET)
    public String initProgress(){
        return "progress";
    }
}
