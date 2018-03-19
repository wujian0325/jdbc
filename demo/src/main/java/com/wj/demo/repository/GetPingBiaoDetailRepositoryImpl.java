package com.wj.demo.repository;

import com.wj.demo.domain.GetPingBiaoDetail;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * DetailController/getPingBiaoDetail接口数据操作
 *
 * @author 吴健
 * @create 2018-03-13 17:43
 */
public interface GetPingBiaoDetailRepositoryImpl extends ElasticsearchRepository<GetPingBiaoDetail, String> {
}
