package com.shanzhu.travel.service.impl;

import com.shanzhu.travel.common.ServiceBase;
import com.shanzhu.travel.entity.Dengji;
import com.shanzhu.travel.mapper.DengjiMapper;
import com.shanzhu.travel.service.DengjiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wsc
 * @version V1.0
 * Copyright (c) 2024, 2353489264@qq.com All Rights Reserved.
 * @ProjectName:travel-backend
 * @Title: DengjiServiceImpl
 * @Package com.shanzhu.travel.service.impl
 * @Description: 等级ServiceImpl
 * @date 2024/7/5 8:24
 */

@Service
public class DengjiServiceImpl extends ServiceBase<Dengji> implements DengjiService {
    @Resource
    private DengjiMapper dao;

    @Override
    protected DengjiMapper getDao() {
        return dao;
    }
}