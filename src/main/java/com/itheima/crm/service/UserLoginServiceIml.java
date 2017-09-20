package com.itheima.crm.service;

import com.itheima.crm.pojo.UserTableExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.UserTableMapper;
import com.itheima.crm.pojo.UserTable;

import java.util.List;

@Service
public class UserLoginServiceIml implements UserLoginService {

	@Autowired
	private UserTableMapper userTableMapper;
	public UserTable selectByPrimaryKey(Integer id) {
		return userTableMapper.selectByPrimaryKey(id);
	}

    public int countByExample(UserTableExample example) {
        return  userTableMapper.countByExample(example);
    }

    @Override
    public List<UserTable> selectByExample(UserTableExample example) {
        return userTableMapper.selectByExample(example);
    }
}
