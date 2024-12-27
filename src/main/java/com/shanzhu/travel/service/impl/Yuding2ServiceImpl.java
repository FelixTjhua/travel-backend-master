package com.shanzhu.travel.service.impl;

import com.shanzhu.travel.common.ServiceBase;
import com.shanzhu.travel.entity.Yuding2;
import com.shanzhu.travel.mapper.Yuding2Mapper;
import com.shanzhu.travel.service.Yuding2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wsc
 * @version V1.0
 * Copyright (c) 2024, 2353489264@qq.com All Rights Reserved.
 * @ProjectName:travel-backend
 * @Title: Yuding2ServiceImpl
 * @Package com.shanzhu.travel.service.impl
 * @Description: 酒店预定ServiceImpl
 * @date 2024/7/5 20:56
 */

@Service
public class Yuding2ServiceImpl extends ServiceBase<Yuding2> implements Yuding2Service {
    @Resource
    private Yuding2Mapper dao;

    @Override
    protected Yuding2Mapper getDao() {
        return dao;
    }
}