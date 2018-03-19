package com.wj.demo.repository;

import com.wj.demo.domain.GetZhengFuGuanZhuDetail;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * detailController/getProjectDetai数据操作
 * @author 吴健
 * @create 2018-03-15 16:41
 */
public interface GetZhengFuGuanZhuDetailRepositoryImpl extends ElasticsearchRepository<GetZhengFuGuanZhuDetail, String> {
}
