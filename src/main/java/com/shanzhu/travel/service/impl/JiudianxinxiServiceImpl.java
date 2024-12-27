package com.shanzhu.travel.service.impl;

import com.shanzhu.travel.common.ServiceBase;
import com.shanzhu.travel.entity.Jiudianxinxi;
import com.shanzhu.travel.mapper.JiudianxinxiMapper;
import com.shanzhu.travel.service.JiudianxinxiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wsc
 * @version V1.0
 * Copyright (c) 2024, 2353489264@qq.com All Rights Reserved.
 * @ProjectName:travel-backend
 * @Title: JiudianxinxiServiceImpl
 * @Package com.shanzhu.travel.service.impl
 * @Description: 酒店信息ServiceImpl
 * @date 2024/7/5 8:38
 */

@Service
public class JiudianxinxiServiceImpl extends ServiceBase<Jiudianxinxi> implements JiudianxinxiService {
    @Resource
    private JiudianxinxiMapper dao;

    @Override
    protected JiudianxinxiMapper getDao() {
        return dao;
    }

    public Jiudianxinxi findByJiudianbianhao(String jiudianbianhao) {
        return dao.findByJiudianbianhao(jiudianbianhao);
    }

    public void update1(Jiudianxinxi jiudianxinxi)
    {
        dao.update1(jiudianxinxi);
    }
}