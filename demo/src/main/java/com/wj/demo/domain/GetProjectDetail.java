package com.wj.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * DetailController/getProjectDetail接口数据实体类
 * DetailController/getZhongFuGuanZhuDetaill接口数据实体类
 * created 2018-03-14 11:09
 *
 * @author 吴健
 */

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "detailcontroller", type = "GetProjectDetail")
public class GetProjectDetail extends GetZhengFuGuanZhuDetail implements Serializable{

    private Integer sIndex;
}
