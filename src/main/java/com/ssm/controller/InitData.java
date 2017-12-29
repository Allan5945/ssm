package com.ssm.controller;

import com.ssm.mapper.RecordMapper;
import com.ssm.mapper.UsersesMapper;
import com.ssm.pojo.Record;
import com.ssm.pojo.Userses;
import com.ssm.service.UserLoginService;
import com.ssm.wocket.WebSocketTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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



    // 开始打卡
    @RequestMapping(value = "/clockInStart",method = RequestMethod.POST)
    @ResponseBody
    public Boolean clockInStart(Record record,HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 获取传入数据
        // 获取session信息
        Userses userMes = (Userses)request.getSession().getAttribute("userMes");
        // 获取当前时间
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        record.setBz((String) request.getAttribute("bz"));
        record.setId(userMes.getId());
        record.setSdata(date.format(new Date()));

        Boolean aBoolean = recordMapper.insertList(record);
        if(aBoolean){
            // 插入成功发提示消息
            WebSocketTest webSocketTest = new WebSocketTest();
            webSocketTest.sendIOneMsg(userMes.getAssociated(),"你好啊我是"+Integer.toString(userMes.getId()));
        }
        return aBoolean;
    };

   // 结束打卡插入数据
    @RequestMapping(value = "/addItemData",method = RequestMethod.POST)
    @ResponseBody
    public Boolean addItemData(Record record,HttpServletRequest request,HttpServletResponse response){
        record.setZk(Integer.parseInt(request.getParameter("zk")));
        record.setEdata(request.getParameter("edata"));
        record.setSdata(request.getParameter("sdata"));
        record.setBz(request.getParameter("bz"));
        Userses userses = (Userses)request.getSession().getAttribute("userMes");
        record.setId(userses.getId());
        Boolean i = recordMapper.insertList(record);
        return i;
    };

     // 删除数据
    @RequestMapping(value = "/deleteItemData",method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteItemData(HttpServletResponse response,HttpServletRequest request){
        int num = Integer.parseInt(request.getParameter("columId"));
        System.out.println(num);
        Boolean aBoolean = recordMapper.deleteItem(num);
        return  aBoolean;
    }
}
