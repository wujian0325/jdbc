package com.wj.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * detailconreoller/getJiaoYiDetail接口数据简化实体
 * created 2018-03-19 15:42
 *
 * @author 吴健
 */

@Data
@Document(indexName = "edataapp", type = "JsgcProjectinfo")
public class JsgcProjectinfo {

    @Id
    private String id;

    private String beiAnWenHao;

    private String title;

    private String beiAnBuMen;

    private Date liXiangDate;

    private Double price;

    private String liXiangGuid;
}
