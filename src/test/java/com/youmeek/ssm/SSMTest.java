package com.youmeek.ssm;

import com.ssm.mapper.UsersesMapper;
import com.ssm.service.UserLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class SSMTest {

	@Resource
    private UserLoginService userLoginService;
    private UsersesMapper usersesMapper;

	@Test
	public void test1() {
//        System.out.println(usersesMapper.selectList());
    }


}
