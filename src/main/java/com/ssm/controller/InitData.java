package com.ssm.controller;

import com.ssm.mapper.RecordMapper;
import com.ssm.mapper.UsersesMapper;
import com.ssm.pojo.Record;
import com.ssm.pojo.Userses;
import com.ssm.service.UserLoginService;
import com.ssm.wocket.WebSocketTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InitData {
    @Autowired
    private RecordMapper recordMapper;


    // 加载登录进来的所有数据
    @RequestMapping(value = "initDatas",method = RequestMethod.POST)
    @ResponseBody
    public Map initDatas(HttpServletRequest request){
        final HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Userses userMes = (Userses) request.getSession().getAttribute("userMes");
        final List<Record> unfinished = recordMapper.unfinished(userMes.getId());
        boolean unfinishedType = false;
        if(unfinished.size() != 0){
            unfinishedType = true;
        };
        objectObjectHashMap.put("type",true);
        objectObjectHashMap.put("data",userMes);
        objectObjectHashMap.put("unfinishedType",unfinishedType);
        return objectObjectHashMap;
    }


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

    // 获取进度数据
    @RequestMapping(value = "/initProgress",method = RequestMethod.POST)
    @ResponseBody
    public Map initProgress(HttpServletRequest request,HttpServletResponse response){
        final Map<String, Object> objectObjectHashMap = new HashMap<>();
        Userses userMes = (Userses) request.getSession().getAttribute("userMes");
        final List<Record> unfinished = recordMapper.unfinished(userMes.getId());
        if(unfinished.size() != 0){
            objectObjectHashMap.put("type",true);
            objectObjectHashMap.put("unfinishedData",unfinished.get(0));
        }else{
            objectObjectHashMap.put("type",false);
        }
        return objectObjectHashMap;
    };


    // 开始打卡
    @RequestMapping(value = "/clockInStart",method = RequestMethod.POST)
    @ResponseBody
    public Map clockInStart(Record record,HttpServletRequest request,HttpServletResponse response) throws IOException {
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        // 获取传入数据
        // 获取session信息
        Userses session = (Userses)request.getSession().getAttribute("userMes");
        final List<Record> unfinished = recordMapper.unfinished(session.getId());
        if(unfinished.size() != 0){
            objectObjectHashMap.put("type",false);
            objectObjectHashMap.put("mes","开始打卡失败！，请完成上一次的打卡");
            return  objectObjectHashMap;
        };
        // 获取当前时间
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String bz = request.getParameter("bz");
        record.setBz(bz);
        record.setId(session.getId());
        String format = date.format(new Date());
        record.setSdata(format);
        Boolean aBoolean = recordMapper.insertList(record);
        if(aBoolean){
            // 插入成功发提示消息
            WebSocketTest webSocketTest = new WebSocketTest();
            webSocketTest.sendIOneMsg(session.getAssociated(),"你好啊我是"+Integer.toString(session.getId()));
        }
        objectObjectHashMap.put("type",true);
        objectObjectHashMap.put("mes","打卡成功！");

        Map<String, String> objectObjectHashMap1 = new HashMap<>();
        objectObjectHashMap1.put("time",format);
        objectObjectHashMap1.put("bz",bz);
        objectObjectHashMap.put("data",objectObjectHashMap1);
        return objectObjectHashMap;
    };

   // 结束打卡插入数据
    @RequestMapping(value = "/addItemData",method = RequestMethod.POST)
    @ResponseBody
    public Boolean addItemData(Record record,HttpServletRequest request){
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Userses userMes = (Userses) request.getSession().getAttribute("userMes");
        final Record unfinished = recordMapper.unfinished(userMes.getId()).get(0);
        String edata = request.getParameter("edata");
        edata = (edata == null ? simpleFormat.format(new Date()) : edata);

        if(edata != null){
            try {
                Date date = simpleFormat.parse(edata);
                String toDate = simpleFormat.format(date.getTime());
                String fromDate  = unfinished.getSdata();
                long from = simpleFormat.parse(fromDate).getTime();
                long to = simpleFormat.parse(toDate).getTime();
                int minutes = (int) ((to - from)/(1000 * 60));
                unfinished.setEdata(toDate);
                unfinished.setState(minutes);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Boolean i = recordMapper.endInsertList(unfinished);
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

    // 解密微信小程序id

}
