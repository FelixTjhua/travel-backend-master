package com.shanzhu.travel.mapper;

import com.shanzhu.travel.common.MapperBase;
import com.shanzhu.travel.entity.Jiudianxinxi;
import org.springframework.stereotype.Repository;

/**
 * @author wsc
 * @version V1.0
 * Copyright (c) 2024, 2353489264@qq.com All Rights Reserved.
 * @ProjectName:travel-backend
 * @Title: JiudianxinxiMapper
 * @Package com.shanzhu.travel.mapper
 * @Description: 酒店信息Mapper
 * @date 2024/7/5 8:40
 */

@Repository
public interface JiudianxinxiMapper extends MapperBase<Jiudianxinxi> {
    Jiudianxinxi findByJiudianbianhao(String jiudianbianhao);
    void update1(Jiudianxinxi jiudianxinxi);
}
