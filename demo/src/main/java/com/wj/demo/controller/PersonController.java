package com.wj.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wj.demo.domain.Person;
import com.wj.demo.repository.PersonRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * created 2018-03-28 9:22
 *
 * @author 吴健
 */

@RestController
@Slf4j
public class PersonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private PersonRepositoryImpl repository;

    public void save() {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Person demo = new Person();
            demo.setId(UUID.randomUUID().toString());
            demo.setName("wujian" + new Random().nextInt(100));
            demo.setAge(new Random().nextInt(50));
            demo.setDesc("fdahdhadaldlskjdlaksdaklsdwujiansahdjagdjasd");
            list.add(demo);
        }
        repository.saveAll(list);
    }

    public void query1() throws Exception {
        logList(repository.findAllByAgeIsNot(25 , PageRequest.of(0, 100)));
        log.info("" + repository.count());
    }

    private void logList(List<Person> list) {
        if (list != null && list.size() > 0) {
            log.info("长度:" + list.size());
            list.forEach(x -> {
                try {
                    log.info(objectMapper.writeValueAsString(x));
                } catch (Exception e) {
                    log.debug("出错");
                }
            });
        }
    }
}
