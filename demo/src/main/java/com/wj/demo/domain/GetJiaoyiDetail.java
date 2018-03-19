package com.wj.demo.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * created 2018-03-13 15:57
 *
 * @author 吴健
 */

@Data
@ToString
@Document(indexName = "detailcontroller", type = "GetJiaoyiDetail")
public class GetJiaoyiDetail implements Serializable {
    @Id
    private String id;

    private String wenHao;

    private String title;

    private String bumen;

    private String date;

    private Double price;

    private Integer type;

    private String jType;
}
