package com.wj.demo.domain.sqlserver.mapper;

import com.wj.demo.domain.sqlserver.JsgcProjectinfo;
import com.wj.demo.domain.sqlserver.JsgcProjectinfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;


public interface JsgcProjectinfoMapper {

    List<JsgcProjectinfo> selectByExample(JsgcProjectinfoExample example);

    @Select("select * from (select  ROW_NUMBER() OVER (order By rowguid) as roenum, * from JSGC_ProjectInfo) a " +
            " where a.roenum > #{start} and a.roenum <= #{end}" )
    List<JsgcProjectinfo> selectByCount(@Param("start") int start, @Param("end") int end);

    List<JsgcProjectinfo> selectByid(@Param("ids") List<String> ids);



}
