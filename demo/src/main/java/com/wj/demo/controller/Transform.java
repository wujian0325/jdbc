package com.wj.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wj.demo.domain.sqlserver.JsgcLixianpiwen;
import com.wj.demo.domain.sqlserver.JsgcProjectinfo;
import com.wj.demo.domain.sqlserver.JsgcProjectinfoExample;
import com.wj.demo.domain.sqlserver.mapper.JsgcLixianpiwenMapper;
import com.wj.demo.domain.sqlserver.mapper.JsgcProjectinfoMapper;
import com.wj.demo.repository.JsgcProjectinfoRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created 2018-03-19 16:51
 *
 * @author 吴健
 */

@RestController
@Slf4j
public class Transform {

    @Autowired
    private JsgcProjectinfoMapper mapper;

    @Autowired
    private JsgcLixianpiwenMapper jsgcLixianpiwenMapper;

    @Autowired
    private JsgcProjectinfoRepositoryImpl repository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void tran() {
        repository.deleteAll();
        int i = 0;
        while (true) {
            int start  = i * 200;
            int end = ++i * 200;
            List<JsgcProjectinfo> list = mapper.selectByCount(start, end);
         if (list.size() > 0) {
            List<com.wj.demo.domain.JsgcProjectinfo> jsgcProjectinfoList = new ArrayList<>();
            list.forEach(x -> {
                com.wj.demo.domain.JsgcProjectinfo model = new com.wj.demo.domain.JsgcProjectinfo();
                model.setId(x.getRowguid());
                model.setZiJinType(x.getZijintype());
                model.setZhaoBiaoType(x.getZhaobiaotype());
                model.setZhaoBiaoFangShi(x.getZhaobiaofangshi());
                model.setXingZhengQuYu(x.getXingzhengquyu());
                model.setTouZiXingZhi(x.getTouzixingzhi());
                model.setTouZiGuSuan(x.getTouzigusuan() == null ? 0 : x.getTouzigusuan().doubleValue());
                model.setProjectNo(x.getProjectno());
                model.setProjectName(x.getProjectname());
                model.setProjectJiaoYiTypeSh(x.getProjectjiaoyitypesh());
                model.setProjectGuiMo(x.getProjectguimo());
                model.setLiXiangProjectGuid(x.getLixiangprojectguid());
                model.setJytzb(x.getJytzb() == null ? 0 : x.getJytzb().doubleValue());
                model.setJianSheType(x.getJianshetype());
                model.setJianSheDwType(x.getJianshedwtype());
                model.setJianSheDiDian(x.getJianshedidian());
                model.setJianSheDanWei(x.getJianshedanwei());
                model.setHangYeFenLei(x.getHangyefenlei());
                model.setFangWuJianZhuLeiXing(x.getFangwujianzhuleixing());
                model.setChangWenHao(x.getChangwenhao());
                model.setChangeDate(x.getChangedate());
                model.setChaneContent(x.getChanecontent());
                model.setBeiAnTitle(x.getBeiantitle());
                model.setBeiAnWenHao(x.getBeianwenhao());
                model.setLiXiangDate(x.getLixiandate());
                jsgcProjectinfoList.add(model);

            });
            repository.saveAll(jsgcProjectinfoList);
        } else {
            return;
        }
    }
    }

    @GetMapping("/get")
    public void getNum() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("fb99e27a-8f75-4b77-911e-7982e77c77c0");
        list.add("ef5daac7-7cd3-4917-bbd4-92b1f1289da5");
   }

   public void delete() {
        repository.deleteAll();
   }


}
