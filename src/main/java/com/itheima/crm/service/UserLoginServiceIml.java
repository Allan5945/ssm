package com.itheima.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.UserTableMapper;
import com.itheima.crm.pojo.UserTable;

@Service
public class UserLoginServiceIml implements UserLoginService {

	@Autowired
	private UserTableMapper userTableMapper;
	public UserTable selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userTableMapper.selectByPrimaryKey(id);
	}

}
