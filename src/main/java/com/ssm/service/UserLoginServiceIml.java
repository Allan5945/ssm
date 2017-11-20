package com.ssm.service;

import com.ssm.mapper.UsersesMapper;
import com.ssm.pojo.UserTableExample;
import com.ssm.pojo.Userses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.UserTableMapper;
import com.ssm.pojo.UserTable;

import java.util.List;


@Service
public class UserLoginServiceIml implements UserLoginService {

	@Autowired
	private UserTableMapper userTableMapper;
	private UsersesMapper usersesMapper;

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

    @Override
    public List<Userses> selectList(Userses userses) {
        return usersesMapper.selectList(userses);
    }
}
