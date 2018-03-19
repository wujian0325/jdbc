package com.wj.demo.repository;

import com.wj.demo.ApplicationTests;
import com.wj.demo.domain.GetPingBiaoDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class GetPingBiaoDetailRepositoryImplTest extends ApplicationTests {

    @Autowired
    private GetPingBiaoDetailRepositoryImpl getPingBiaoDetailRepository;

    @Test
    public void test() {

        List<GetPingBiaoDetail> list = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            GetPingBiaoDetail detail = new GetPingBiaoDetail();
            detail.setBName("test");
            detail.setType(1);
            detail.setSIndex(2);
            detail.setJType("sjgdjh");
            detail.setDate(new Date());
            detail.setId(new Date().getTime() + i + "");
            list.add(detail);
        }
        getPingBiaoDetailRepository.saveAll(list);
    }

}