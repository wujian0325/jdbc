package com.wj.demo.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

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

    @NotNull
    @Field(fielddata = true)
    private String name;
    @NotNull
    @Field(fielddata = true)
    private Integer age;
    @NotNull
    @Field(fielddata = true)
    private String desc;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigInteger count;
}
