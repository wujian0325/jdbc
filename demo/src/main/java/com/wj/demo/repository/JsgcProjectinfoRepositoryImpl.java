package com.wj.demo.repository;

import com.wj.demo.domain.JsgcProjectinfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

/**
 * JsgcProjectinfo实体操作
 * created 2018-03-19 15:50
 *
 * @author 吴健
 */
public interface JsgcProjectinfoRepositoryImpl extends ElasticsearchRepository<JsgcProjectinfo, String> {

//    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"id\" : \"?0\"}} }}")
    @Query("{\"bool\" : {\"must\" : {\"match\" : {\"id.keyword\" : \"?0\"}} }}")
    Optional<JsgcProjectinfo> getModel(String id);

    @Query("{\"bool\" : {\"must\" : {\"range\" : {\"touZiGuSuan\" : { \"gte\" : ?0 }}}}}")
    List<JsgcProjectinfo> getList(int touZiGuSuan, Pageable pageable);

    @Query(value = "{\"bool\" : {\"must\" : {\"bool\" : {\"should\" : {\"match\" : {\"id.keyword\" : ?0}}}}}}")
    List<JsgcProjectinfo> getList(List<String> ids);
}
