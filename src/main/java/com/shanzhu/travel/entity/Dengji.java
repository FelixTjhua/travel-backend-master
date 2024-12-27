package com.shanzhu.travel.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wsc
 * @version V1.0
 * Copyright (c) 2024, 2353489264@qq.com All Rights Reserved.
 * @ProjectName:travel-backend
 * @Title: Dengji
 * @Package com.shanzhu.travel.entity
 * @Description: 酒店等级
 * @date 2024/7/5 8:06
 */

@Table(name = "dengji")
public class Dengji implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "dengjimingcheng")
    private String dengjimingcheng;
    @Column(name = "addtime")
    private String addtime;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDengjimingcheng() {
        return dengjimingcheng;
    }

    public void setDengjimingcheng(String dengjimingcheng) {
        this.dengjimingcheng = dengjimingcheng == null ? "" : dengjimingcheng.trim();
    }

    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }

}
