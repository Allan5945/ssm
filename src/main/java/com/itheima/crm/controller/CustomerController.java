package com.itheima.crm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.itheima.crm.pojo.UserTableExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.service.UserLoginService;
import com.itheima.crm.pojo.UserTable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


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
//            System.out.println(key.getId());
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return map;
	};
	@RequestMapping(value = "error_404")
	public String ind6(){
//		System.out.println(55);
		return "index";
	};

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void upload(HttpServletRequest request,
                       HttpServletResponse response, ModelMap model) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 得到上传的文件
        MultipartFile mFile = multipartRequest.getFile("file");
        // 得到上传服务器的路径
        String path = request.getSession().getServletContext()
                .getRealPath("/WEB-INF/upload/");
//        // 得到上传的文件的文件名
        String filename = mFile.getOriginalFilename();
        byte[] b = mFile.getBytes();
        path += "\\" + filename;
//        // 文件流写到服务器端
        FileOutputStream outputStream = new FileOutputStream(path);
        outputStream.write(b);
        outputStream.close();
    }
}
