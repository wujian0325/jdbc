package com.wj.demo.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wj.demo.ApplicationTests;
import com.wj.demo.domain.JsgcProjectinfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.*;

@Slf4j
public class JsgcProjectinfoRepositoryImplTest extends ApplicationTests {

    @Autowired
    private JsgcProjectinfoRepositoryImpl repository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test() {

        int i = 10;
        while(i-- > 0) {
            JsgcProjectinfo model = new JsgcProjectinfo();
            model.setLiXiangDate(new Date());
            model.setBeiAnWenHao("test");
            model.setId(UUID.randomUUID().toString());
            repository.save(model);
        }
    }

    @Test
    public void test1() throws Exception {
        Optional<JsgcProjectinfo> model = repository.getModel("06a18279-aca5-428d-aed1-cbcd0e697622");
        if (model.isPresent()) {
            log.info(objectMapper.writeValueAsString(model.get()));
        } else {
            log.debug("false");
        }
    }

    @Test
    public void test2() throws Exception {
        List<JsgcProjectinfo> model = repository.getList(55, PageRequest.of(0,100, Sort.by("touZiGuSuan", "id").ascending()));
        if (model != null || model.size() > 0) {
            model.forEach( x -> {
                try {
                    log.info(objectMapper.writeValueAsString(x.getTouZiGuSuan()));
                } catch (Exception e) {}
            });

            log.info(model.size() + "");
        } else {
            log.debug("false");
        }
    }

    @Test
    public void test3() {
        List<String> ids = new ArrayList<>();
        ids.add("06a18279-aca5-428d-aed1-cbcd0e697622");
        ids.add("06b4868e-26d8-4c71-8a5c-e07dce86463b");
        ids.add("06d9e6b2-b086-45aa-a992-b1d6fc4a6133");
        List<JsgcProjectinfo> model = repository.getList(ids);
        if (model != null || model.size() > 0) {
            model.forEach( x -> {
                try {
                    log.info(objectMapper.writeValueAsString(x.getTouZiGuSuan()));
                } catch (Exception e) {}
            });

            log.info(model.size() + "");
        } else {
            log.debug("false");
        }
    }

}