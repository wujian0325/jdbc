package com.wj.demo.repository;

import com.wj.demo.domain.GetProjectDetail;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * detailController/getProjectDetai数据操作
 * created 2018-03-14 15:09
 *
 * @author 吴健
 */
public interface GetProjectDetailRepositoryImpl extends ElasticsearchRepository<GetProjectDetail, String> {
}
