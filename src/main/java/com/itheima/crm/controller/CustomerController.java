package com.itheima.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.itheima.crm.pojo.UserTableExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.service.UserLoginService;
import com.itheima.crm.pojo.UserTable;




/**
 * 客户管理
 * @author lx
 *
 */
@Controller
public class CustomerController {

	@RequestMapping(value = "")
	public String ind(){
		return "index";
	};
	
	@RequestMapping(value = "authCode")
	@ResponseBody
	public String getMobileAuthCode( HttpServletRequest request, String callback)
	        throws Exception {
	    String result =  "{'ret':'true'}";
	    //加上返回参数
	    result=callback+"("+result+")";
	   return result;
	};
	@Autowired
	private UserLoginService userLoginService;
	@RequestMapping(value = "login")
	@ResponseBody
	public Map ind5(){
		HashMap<Object, Object> map = new HashMap<>();
		UserTable selectByPrimaryKey = userLoginService.selectByPrimaryKey(1);
		map.put("sis",selectByPrimaryKey);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        UserTableExample userTableExample = new UserTableExample();
        userTableExample.createCriteria().andIdIsNotNull();
        int i = userLoginService.countByExample(userTableExample);
//        System.out.println(i);

        List<UserTable> userTables = userLoginService.selectByExample(userTableExample);
        for(UserTable key : userTables){
            System.out.println(key.getId());
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return map;
	};
	@RequestMapping(value = "error_404")
	public String ind6(){
		System.out.println(55);
		return "index";
	};
}
