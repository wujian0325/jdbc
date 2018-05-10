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

    private String liXiangProjectGuid;

    private Double touZiGuSuan;

    private String projectNo;

    private String jianSheDanWei;

    private String jianSheDiDian;

    private String xingZhengQuYu;

    private String beiAnWenHao;

    private Date liXiangDate;

    private String changWenHao;

    private Date changeDate;

    private String touZiXingZhi;

    private String zhaoBiaoType;

    private String hangYeFenLei;

    private String jianSheType;

    private String projectJiaoYiType;

    private String jianSheDwType;

    private String projectGuiMo;

    private String zhaoBiaoFangShi;

    private Double jytzb;

    private String ziJinType;

    private String projectJiaoYiTypeSh;

    private String fangWuJianZhuLeiXing;

    private String projectName;

    private String beiAnTitle;

    private String chaneContent;
}
