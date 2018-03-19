package com.wj.demo.repository;

import com.wj.demo.ApplicationTests;
import com.wj.demo.domain.GetZhengFuGuanZhuDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class GetZhengFuGuanZhuDetailRepositoryImplTest extends ApplicationTests {

    @Autowired
    private GetZhengFuGuanZhuDetailRepositoryImpl repository;

    @Test
    public void test() {
        GetZhengFuGuanZhuDetail detail = new GetZhengFuGuanZhuDetail();
        detail.setId(UUID.randomUUID().toString());
        detail.setType(1);
        detail.setQName("sdja");
        detail.setPrice(798798279.0);
        detail.setPNo("ds");
        detail.setPName("sds");
        detail.setJType("SDHGAJD");
        detail.setDate(new Date());
        detail.setBNo("dsda");
        detail.setBName("ds");
        detail.setBId(detail.getId());
        repository.save(detail);
    }

}