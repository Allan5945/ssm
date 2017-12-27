package com.ssm.mapper;

import com.ssm.pojo.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordMapper {
    List<Record> selectList(int id);
    Boolean insertList(Record record);
    Boolean updateList(Record r);
    Boolean deleteItem(int r);
}
