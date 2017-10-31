package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class JsonpData {
    /**
     * 返回jsonp数据
     * */
    @RequestMapping(value = "authCode")
    @ResponseBody
    public String getMobileAuthCode(HttpServletRequest request, String callback)
            throws Exception {
        String result =  "{'ret':'true'}";
        //加上返回参数
        result=callback+"("+result+")";
        return result;
    };
}
