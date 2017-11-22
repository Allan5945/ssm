package com.ssm.service;

import com.ssm.pojo.Record;
import com.ssm.pojo.Userses;

import java.util.List;

public interface UserLoginService {
    List<Userses> selectList(Userses userses);
    List<Record> selectList(int id);
}
