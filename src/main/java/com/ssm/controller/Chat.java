package com.ssm.controller;

import com.ssm.pojo.Userses;
import com.ssm.wocket.WebSocketTest;
import com.sun.deploy.net.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class Chat {
    @RequestMapping(value = "/sendMes",method = RequestMethod.POST)
    @ResponseBody
    public Boolean sendMes(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String df = request.getParameter("df");
        Userses userMes = (Userses)request.getSession().getAttribute("userMes");
        String name = Integer.toString(userMes.getId());
        WebSocketTest webSocketTest = new WebSocketTest();

        webSocketTest.sendIOneMsg(df,"你好啊我是"+name);
        return true;
    }
}
