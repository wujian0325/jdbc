package com.wj.demo.repository;

import com.wj.demo.domain.GetJiaoyiDetail;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * /DetailController/getJiaoYiDetail接口数据操作
 *
 * @author 吴健
 * @create 2018-03-13 16:04
 */
public interface GetJiaoyiDetailRepositoryImpl extends ElasticsearchRepository<GetJiaoyiDetail, String> {
}
