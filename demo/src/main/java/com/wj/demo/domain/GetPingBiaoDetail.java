package com.wj.demo.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * DetailController/getPingBiaoDetail接口数据实体
 * created 2018-03-13 17:38
 *
 * @author 吴健
 */
@Data
@ToString
@Document(indexName = "detailcontroller", type = "GetPingBiaoDetail")
public class GetPingBiaoDetail {

    @Id
    private String id;

    private String bName;

    private Integer sIndex;

    private Date date;

    private Integer type;

    private String jType;
}
