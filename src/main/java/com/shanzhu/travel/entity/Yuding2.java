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
 * @Title: Yuding2
 * @Package com.shanzhu.travel.entity
 * @Description: 酒店预定
 * @date 2024/7/5 20:31
 */

@Table(name = "yuding2")
public class Yuding2 implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "jiudianxinxiid")
    private Integer jiudianxinxiid;
    @Column(name = "jiudianbianhao")
    private String jiudianbianhao;
    @Column(name = "jiudianmingcheng")
    private String jiudianmingcheng;
    @Column(name = "dizhi")
    private String dizhi;
    @Column(name = "jiage")
    private Double jiage;
    @Column(name = "dingdanhao")
    private String dingdanhao;
    @Column(name = "yudingshijian")
    private String yudingshijian;
    @Column(name = "yudingrenxingming")
    private String yudingrenxingming;
    @Column(name = "lianxifangshi")
    private String lianxifangshi;
    @Column(name = "zhuangtai")
    private String zhuangtai;
    @Column(name = "beizhu")
    private String beizhu;
    @Column(name = "yudingren")
    private String yudingren;
    @Column(name = "addtime")
    private String addtime;
    @Column(name = "roomType")
    private String roomType;
    private String iszf;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getJiudianxinxiid() {
        return jiudianxinxiid;
    }
    public void setJiudianxinxiid(Integer lvyouxianluid) {
        this.jiudianxinxiid = jiudianxinxiid == null ? 0 : jiudianxinxiid;
    }

    public String getJiudianbianhao() {
        return jiudianbianhao;
    }
    public void setJiudianbianhao(String jiudianbianhao) {
        this.jiudianbianhao = jiudianbianhao == null ? "" : jiudianbianhao.trim();
    }

    public String getJiudianmingcheng() {
        return jiudianmingcheng;
    }
    public void setJiudianmingcheng(String jiudianmingcheng) {
        this.jiudianmingcheng = jiudianmingcheng == null ? "" : jiudianmingcheng.trim();
    }

    public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? "" : dizhi.trim();
    }

    public Double getJiage() {
        return jiage;
    }
    public void setJiage(Double jiage) {
        this.jiage = jiage == null ? 0.0f : jiage;
    }

    public String getDingdanhao() {
        return dingdanhao;
    }
    public void setDingdanhao(String dingdanhao) {
        this.dingdanhao = dingdanhao == null ? "" : dingdanhao.trim();
    }

    public String getYudingshijian() {
        return yudingshijian;
    }
    public void setYudingshijian(String yudingshijian) {
        this.yudingshijian = yudingshijian == null ? "" : yudingshijian.trim();
    }

    public String getYudingrenxingming() {
        return yudingrenxingming;
    }
    public void setYudingrenxingming(String yudingrenxingming) {
        this.yudingrenxingming = yudingrenxingming == null ? "" : yudingrenxingming.trim();
    }

    public String getLianxifangshi() {
        return lianxifangshi;
    }
    public void setLianxifangshi(String lianxifangshi) {
        this.lianxifangshi = lianxifangshi == null ? "" : lianxifangshi.trim();
    }

    public String getZhuangtai() {
        return zhuangtai;
    }
    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai == null ? "" : zhuangtai.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? "" : beizhu.trim();
    }

    public String getYudingren() {
        return yudingren;
    }
    public void setYudingren(String yudingren) {
        this.yudingren = yudingren == null ? "" : yudingren.trim();
    }

    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }
    public String getIszf() {
        return iszf;
    }
    public void setIszf(String iszf) {
        this.iszf = iszf == null ? "" : iszf.trim();
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public String getRoomType() {
        return roomType;
    }
}
