package com.ssm.service;

import com.ssm.mapper.RecordMapper;
import com.ssm.mapper.UsersesMapper;
import com.ssm.pojo.Record;
import com.ssm.pojo.Userses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserLoginServiceIml implements UserLoginService {

	@Autowired
	private UsersesMapper usersesMapper;
	private RecordMapper recordMapper;

    @Override
    public List<Userses> selectList(Userses userses) {
        return usersesMapper.selectList(userses);
    }

    @Override
    public List<Record> selectList(int id) {
        return recordMapper.selectList(id);
    }
}
