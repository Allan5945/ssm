package com.itheima.crm.service;

import com.itheima.crm.pojo.UserTable;
import com.itheima.crm.pojo.UserTableExample;

import java.util.List;

public interface UserLoginService {
    UserTable selectByPrimaryKey(Integer id);
    int countByExample(UserTableExample example);
    List<UserTable> selectByExample(UserTableExample example);
}
