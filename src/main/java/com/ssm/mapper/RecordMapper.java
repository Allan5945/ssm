package com.ssm.mapper;

import com.ssm.pojo.Record;

import java.util.List;

public interface RecordMapper {
    List<Record> selectList(int id);
}
