package com.ssm.service;

import com.ssm.pojo.UserTable;
import com.ssm.pojo.UserTableExample;
import com.ssm.pojo.Userses;

import java.util.List;

public interface UserLoginService {
    UserTable selectByPrimaryKey(Integer id);
    int countByExample(UserTableExample example);
    List<UserTable> selectByExample(UserTableExample example);

    List<Userses> selectList(Userses userses);
}
