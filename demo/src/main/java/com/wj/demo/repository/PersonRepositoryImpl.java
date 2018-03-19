package com.wj.demo.repository;

import com.wj.demo.domain.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 吴健
 * @create 2018-03-12 15:01
 */
public interface PersonRepositoryImpl extends ElasticsearchRepository<Person, String> {
}
