package com.ssm.controller;

import com.ssm.mapper.RecordMapper;
import com.ssm.pojo.Record;
import com.ssm.pojo.Userses;
import com.ssm.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InitData {
    @Autowired
    private RecordMapper recordMapper;

    // 初次加载获取全部数据的接口
    @RequestMapping(value = "/initData",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, List<Record>> isLogin(HttpServletRequest request,HttpServletResponse response){
        Userses userList = (Userses)request.getSession().getAttribute("userMes");
        List<Record> records = recordMapper.selectList(1);
        HashMap<String, List<Record>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("mes",records);
        return stringListHashMap;
    };

    // 插入数据
    @RequestMapping(value = "/addItemData",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> addItemData(Record record,HttpServletRequest request,HttpServletResponse response){
        HashMap<String, String> objectObjectHashMap = new HashMap<String, String>();
        record.setZk(Integer.parseInt(request.getParameter("zk")));
        record.setEdata(request.getParameter("edata"));
        record.setSdata(request.getParameter("sdata"));
        record.setBz(request.getParameter("bz"));
        Userses userses = (Userses)request.getSession().getAttribute("userMes");
        record.setId(userses.getId());

        recordMapper.insertList(record);

        return objectObjectHashMap;
    };
}
