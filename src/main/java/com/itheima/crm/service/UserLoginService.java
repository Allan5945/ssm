package com.itheima.crm.service;

import com.itheima.crm.pojo.UserTable;

public interface UserLoginService {
    UserTable selectByPrimaryKey(Integer id);
}
