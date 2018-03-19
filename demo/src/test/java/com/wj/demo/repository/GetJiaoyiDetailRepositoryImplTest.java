package com.wj.demo.repository;

import com.wj.demo.ApplicationTests;
import com.wj.demo.domain.GetJiaoyiDetail;
import com.wj.demo.domain.sqlserver.JsgcProjectinfoExample;
import com.wj.demo.domain.sqlserver.mapper.JsgcProjectinfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@Slf4j
public class GetJiaoyiDetailRepositoryImplTest extends ApplicationTests{

    @Autowired
    private GetJiaoyiDetailRepositoryImpl getJiaoyiDetailRepository;


    @Test
    public void test() {
        GetJiaoyiDetail detail = new GetJiaoyiDetail();
        detail.setDate("2018-03-12 00:00:00");
        detail.setBumen("开发");
        detail.setWenHao("123");
        detail.setTitle("12345");
        detail.setPrice(1234567.25);
        detail.setType(1);
        detail.setJType("dgaj");
        getJiaoyiDetailRepository.save(detail);
    }

}