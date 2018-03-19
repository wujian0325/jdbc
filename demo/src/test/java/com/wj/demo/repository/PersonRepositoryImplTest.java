package com.wj.demo.repository;

import com.wj.demo.domain.sqlserver.mapper.JsgcProjectinfoMapper;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class PersonRepositoryImplTest {

//    @Autowired
//    private PersonRepositoryImpl personRepository;
//
//    @Test
//    public void test() {
//        Person person = new Person();
//        person.setId(UUID.randomUUID().toString());
//        person.setName("apple");
//        person.setAge(25);
//        person.setDesc("sdas");
//        personRepository.save(person);
//    }
@Autowired
private JsgcProjectinfoMapper mapper;


}