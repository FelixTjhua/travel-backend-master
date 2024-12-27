package com.shanzhu.travel.service.impl;

import com.shanzhu.travel.common.ServiceBase;
import com.shanzhu.travel.entity.Yanchufenlei;
import com.shanzhu.travel.mapper.YanchufenleiMapper;
import com.shanzhu.travel.service.YanchufenleiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class YanchufenleiServiceImpl extends ServiceBase<Yanchufenlei> implements YanchufenleiService {
    @Resource
    private YanchufenleiMapper dao;

    @Override
    protected YanchufenleiMapper getDao() {
        return dao;
    }
}
