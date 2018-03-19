package com.wj.demo.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 测试实体
 * created 2018-03-12 14:40
 *
 * @author 吴健
 */

@Data
@ToString
@Document(indexName = "my_test", type = "Person")
public class Person implements Serializable {

    @Id
    private String id;

    private String name;

    private Integer age;

    private String desc;
}
