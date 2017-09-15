package com.itheima.crm.mapper;

import com.itheima.crm.pojo.UserTable;
import com.itheima.crm.pojo.UserTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTableMapper {
    int countByExample(UserTableExample example);

    int deleteByExample(UserTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    List<UserTable> selectByExample(UserTableExample example);

    UserTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserTable record, @Param("example") UserTableExample example);

    int updateByExample(@Param("record") UserTable record, @Param("example") UserTableExample example);

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKey(UserTable record);
}