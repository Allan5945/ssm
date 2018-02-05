package com.ssm.service;

import com.ssm.pojo.Record;
import com.ssm.pojo.Userses;

import java.util.List;

public interface UserLoginService {
    List<Userses> selectList(Userses userses);
    List<Record> selectList(int id);
    Boolean insertList(Record record);
    Boolean updateList(Record r);
    Boolean deleteItem(int r);
    List<Record> unfinished(int r);

}
