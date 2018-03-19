package com.wj.demo.repository;

import com.wj.demo.domain.JsgcProjectinfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * JsgcProjectinfo实体操作
 * created 2018-03-19 15:50
 *
 * @author 吴健
 */
public interface JsgcProjectinfoRepositoryImpl extends ElasticsearchRepository<JsgcProjectinfo, String> {
}
