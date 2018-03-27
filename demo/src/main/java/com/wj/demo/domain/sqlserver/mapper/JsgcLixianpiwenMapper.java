package com.wj.demo.domain.sqlserver.mapper;

import com.wj.demo.domain.sqlserver.JsgcLixianpiwen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JsgcLixianpiwenMapper {

    @Select(
    "select * from (select  ROW_NUMBER() OVER (order By LiXiangGuid ) as roenum, * from JSGC_LiXianPiWen " +
            "where LiXianDate between '2017-1-1 00:00:00' and '2019-01-01 00:00:00') a " +
            " where a.roenum > #{start} and a.roenum <= #{end}")
    List<JsgcLixianpiwen> select(@Param("start") int start, @Param("end") int end);

}
