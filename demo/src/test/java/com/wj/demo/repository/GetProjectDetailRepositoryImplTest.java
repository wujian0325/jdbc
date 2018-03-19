package com.wj.demo.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wj.demo.ApplicationTests;
import com.wj.demo.domain.GetProjectDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.Assert.*;


@Slf4j
public class GetProjectDetailRepositoryImplTest extends ApplicationTests {


    @Autowired
    private GetProjectDetailRepositoryImpl repository;

    @Test
    public void test() throws Exception {

        List<GetProjectDetail> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            GetProjectDetail detail = new GetProjectDetail();
            detail.setId( i + "");
            detail.setType(i);
            detail.setSIndex(i);
            detail.setQName("sdja");
            detail.setPrice(798798279.0);
            detail.setPNo("ds");
            detail.setPName("sds");
            detail.setJType(i + "");
            detail.setDate(new Date());
            detail.setBNo("dsda");
            detail.setBName("ds");
            detail.setBId(detail.getId());
            list.add(detail);
        }
        ObjectMapper objectMapper = new ObjectMapper();

        log.info(objectMapper.writeValueAsString(list));
        repository.saveAll(list);
    }

    @Test
    public void get() {
        Iterable<GetProjectDetail> list = repository.findAll();
        List<GetProjectDetail> res = new ArrayList<>();
        list.forEach( x -> {
            res.add(x);
        });
        log.info(res.size() + "");
    }

}