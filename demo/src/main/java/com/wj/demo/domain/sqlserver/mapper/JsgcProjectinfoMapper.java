package com.wj.demo.domain.sqlserver.mapper;

import com.wj.demo.domain.sqlserver.JsgcProjectinfo;
import com.wj.demo.domain.sqlserver.JsgcProjectinfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;

public interface JsgcProjectinfoMapper {

    List<JsgcProjectinfo> selectByExample(JsgcProjectinfoExample example);

}
