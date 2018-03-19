package com.wj.demo.repository;

import com.wj.demo.ApplicationTests;
import com.wj.demo.domain.JsgcProjectinfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class JsgcProjectinfoRepositoryImplTest extends ApplicationTests {

    @Autowired
    private JsgcProjectinfoRepositoryImpl repository;

    @Test
    public void test() {
        JsgcProjectinfo model = new JsgcProjectinfo();
        model.setTitle("test");
        model.setBeiAnBuMen("test");
        model.setPrice(78237823.0);
        model.setLiXiangGuid("test");
        model.setLiXiangDate(new Date());
        model.setBeiAnWenHao("test");
        model.setId(UUID.randomUUID().toString());
        repository.save(model);
    }

}