package com.wj.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wj.demo.ApplicationTests;
import com.wj.demo.domain.Person;
import com.wj.demo.repository.PersonRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class PersonControllerTest extends ApplicationTests {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private PersonController personController;

    @Autowired
    private PersonRepositoryImpl repository;

    @Test
    public void test() {
        repository.deleteAll();
        personController.save();
    }

    @Test
    public void query1() throws Exception {
        personController.query1();
    }

    @Test
    public void query2() {
//        Page<Person> page = repository.findAll(PageRequest.of(1, 20));

        logList(repository.findPeopleByAgeGreaterThanAndNameContains(23,"8", PageRequest.of(0, 20, Sort.by("age").descending())));
    }

    @Test
    public void count() {
        log.info("" + repository.countByAge(23));
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

    private void logList(Iterable<Person> list) {
        if (list != null && list.iterator().hasNext()) {
            list.forEach(x -> {
                try {
                    log.info(objectMapper.writeValueAsString(x));
                } catch (Exception e) {
                    log.debug("出错");
                }
            });
        }

    }

    private void logList(Page<Person> list) {
        if (list != null && list.iterator().hasNext()) {
            list.forEach(x -> {
                try {
                    log.info(objectMapper.writeValueAsString(x));
                } catch (Exception e) {
                    log.debug("出错");
                }
            });
        }
    }



    @Test
    public void isNull() {
        List<Person> list = repository.findAllByAgeIs(100);
        log.info(list == null? "null" : "长度" + list.size());

    }


    @Test
    public void test3() throws Exception {
        List<String> name = new ArrayList<>();
        name.add("apple");
        name.add("海洋公司");
        List<Person> list = repository.getList(name, "a");
        log.info(list.size()+ "");
        list.forEach(x -> {
            try {
                log.info(objectMapper.writeValueAsString(x));
            } catch (Exception e) {}
        });
    }

    @Test
    public void test4() throws Exception {
        Stream<Person> list = repository.findAllByCustomQueryAndStream("apple");
        try {
            log.info(objectMapper.writeValueAsString(list));
        } catch (Exception e) {}
    }

    @Test
    public void test5 () {
        String s = "%%";
        log.info(s.substring(1, s.length() - 1));
    }
}