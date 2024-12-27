package com.shanzhu.travel.service.impl;

import com.shanzhu.travel.common.ServiceBase;
import com.shanzhu.travel.entity.Difangyanchu;
import com.shanzhu.travel.mapper.DifangyanchuMapper;
import com.shanzhu.travel.service.DifangyanchuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DifangyanchuServiceImpl extends ServiceBase<Difangyanchu> implements DifangyanchuService {
    @Resource
    private DifangyanchuMapper dao;

    @Override
    protected DifangyanchuMapper getDao() {
        return dao;
    }
}
