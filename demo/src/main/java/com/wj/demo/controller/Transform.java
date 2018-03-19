package com.wj.demo.controller;

import com.wj.demo.domain.sqlserver.JsgcProjectinfo;
import com.wj.demo.domain.sqlserver.JsgcProjectinfoExample;
import com.wj.demo.domain.sqlserver.mapper.JsgcProjectinfoMapper;
import com.wj.demo.repository.JsgcProjectinfoRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    private JsgcProjectinfoRepositoryImpl repository;

    public void tran() {
        int i = 0;
        while (true) {
            JsgcProjectinfoExample example = new JsgcProjectinfoExample();
            example.setLimit(i * 100);
            example.setOffset(100);
            List<JsgcProjectinfo> list = mapper.selectByExample(example);
            if (list.size() > 0) {
                List<com.wj.demo.domain.JsgcProjectinfo> jsgcProjectinfoList = new ArrayList<>();
                list.forEach(x -> {
                    com.wj.demo.domain.JsgcProjectinfo model = new com.wj.demo.domain.JsgcProjectinfo();
                    model.setBeiAnWenHao(x.getBeianwenhao());
                    model.setLiXiangDate(x.getLixiandate());
                    model.setTitle(x.getBeiantitle());
                    model.setBeiAnBuMen(x.getBeianbumen());
                    model.setPrice(null);
                    model.setLiXiangGuid(x.getLixiangprojectguid());
                    jsgcProjectinfoList.add(model);
                });
                repository.saveAll(jsgcProjectinfoList);
            } else {
                return;
            }
        }
    }
}
