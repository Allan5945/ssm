package com.youmeek.ssm;

import com.itheima.crm.service.UserLoginService;
import com.itheima.crm.pojo.UserTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class SSMTest {


	@Resource
    private UserLoginService userLoginService;

	@Test
	public void test1() {
        HashMap<Object, Object> map = new HashMap<>();
        UserTable selectByPrimaryKey = userLoginService.selectByPrimaryKey(1);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        map.put("sis",selectByPrimaryKey);
        System.out.println(map);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
