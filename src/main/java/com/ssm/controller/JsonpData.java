package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class JsonpData {
    /**
     * 返回jsonp数据
     * */
    @RequestMapping(value = "authCode")
    @ResponseBody
    public String getMobileAuthCode(HttpServletRequest request, HttpServletResponse response, String callback)
            throws Exception {
        System.out.println(callback);


        String result =  "";
        //加上返回参数
        result=callback+"("+result+")";
        return result;
    };
}
