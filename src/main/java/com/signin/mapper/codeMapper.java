package com.signin.mapper;

import com.signin.model.code;
import com.signin.model.codeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface codeMapper {
    int countByExample(codeExample example);

    int deleteByExample(codeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(code record);

    int insertSelective(code record);

    List<code> selectByExample(codeExample example);

    code selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") code record, @Param("example") codeExample example);

    int updateByExample(@Param("record") code record, @Param("example") codeExample example);

    int updateByPrimaryKeySelective(code record);

    int updateByPrimaryKey(code record);
}