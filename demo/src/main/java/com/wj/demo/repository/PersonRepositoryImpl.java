package com.wj.demo.repository;

import com.wj.demo.domain.Person;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author 吴健
 * @create 2018-03-12 15:01
 */
public interface PersonRepositoryImpl extends ElasticsearchRepository<Person, String> {


    Iterable<Person> findPeopleByAgeIs(int age);

    List<Person> findAllByAgeIs(int age);

    List<Person> findByName(String name);

    List<Person> findAllByNameIn(List<String> name);

    List<Person> findAllByDescLike(String name);

    List<Person> findAllByDescContains(String name);

    int countByAge(int age);

    List<Person> queryAllByAge(int age, Pageable pageable);

    List<Person> queryAllByAge(int age);

    List<Person> findAllByAgeIsNot(int age, Pageable pageable);



    List<Person> findPeopleByAgeGreaterThanAndNameContains(int age, String name, @PageableDefault(size = Integer.MAX_VALUE) Pageable pageable);

    List<Person> findPeopleByAgeGreaterThan(int age, @SortDefault Sort sort);


    @Query("{\"bool\":{\"filter\":[{\"bool\":{\"must\":[{\"bool\":{\"should\":[{\"match\":{\"name\":" +
            "{\"query\":\"?0\"}}}],\"disable_coord\":false,\"adjust_pure_negative\":" +
            "true,\"boost\":1}}],\"disable_coord\":false,\"adjust_pure_negative\":true,\"boost\":1}}],\"" +
            "disable_coord\":false,\"adjust_pure_negative\":true,\"boost\":1}}")
    List<Person> getList(List<String> name, String des);

    @Query("select * from my_test/Person ")
    Stream<Person> findAllByCustomQueryAndStream(String name);

    @Query("select p form Person p")
    Stream<Person> streamAllPaged(PageRequest pageRequest);

    @Query("{\"bool\":{\"filter\":[{\"bool\":{\"must\":[{\"match_phrase\":{\"name\":" +
            "{\"query\":?0,\"slop\":0,\"boost\":1}}}],\"disable_coord\":false,\"" +
            "adjust_pure_negative\":true,\"boost\":1}}],\"disable_coord\":false,\"" +
            "adjust_pure_negative\":true,\"boost\":1}}")
    List<Person> findByAge(int age);
}
