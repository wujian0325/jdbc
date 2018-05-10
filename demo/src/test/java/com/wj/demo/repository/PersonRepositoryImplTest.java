package com.wj.demo.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wj.demo.ApplicationTests;
import com.wj.demo.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class PersonRepositoryImplTest extends ApplicationTests {

    @Autowired
    private PersonRepositoryImpl personRepository;

    @Autowired
    private ElasticsearchTemplate template;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test() {
        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setName("吴健");
        person.setAge(25);
        person.setDesc("帅气");
        person.setPrice(new BigDecimal(10000000000L));
        person.setCount( new BigInteger("1000000000000000"));
        personRepository.save(person);
    }

    @Test
    public void test1 () throws Exception {
        Iterable<Person> list = personRepository.findAll();
        list.forEach(x -> {
            try {
                log.info(objectMapper.writeValueAsString(x));
            } catch (Exception e ) {}
        });
    }

    @Test
    public void update() {
        Person person = new Person();
        person.setId("sdjagdj");
        person.setDesc("123");
        person.setName("123");
        personRepository.save(person);
    }

    @Test
    public void test2 () throws Exception {
        List<String> name = new ArrayList<>();
        name.add("apple");
        log.info(objectMapper.writeValueAsString(personRepository.findAllByNameIn(null)));
    }

    @Test
    public void test3 () throws Exception {
        log.info(objectMapper.writeValueAsString(personRepository.findByAge(123)));
    }


}