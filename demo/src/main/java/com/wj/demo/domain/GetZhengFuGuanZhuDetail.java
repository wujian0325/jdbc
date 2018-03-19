package com.wj.demo.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * detailController/getZhengFuGuanZhuDetail
 * created 2018-03-15 16:37
 *
 * @author 吴健
 */
@Data
@ToString
@Document(indexName = "detailcontroller", type = "GetZhengFuGuanZhuDetail")
public class GetZhengFuGuanZhuDetail implements Serializable{
    @Id
    private String id;

    private String bId;

    private String bName;

    private String bNo;

    private Date date;

    private String pNo;

    private String pName;

    private Double price;

    private String qName;

    private Integer type;

    private String jType;
}
