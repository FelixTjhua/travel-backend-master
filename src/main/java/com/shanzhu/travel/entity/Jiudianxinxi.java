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
 * @Title: Jiudianxinxi
 * @Package com.shanzhu.travel.entity
 * @Description: 酒店信息类
 * @date 2024/7/5 8:09
 */

@Table(name = "jiudianxinxi")
public class Jiudianxinxi implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "jiudianbianhao")
    private String jiudianbianhao;
    @Column(name = "jiudianmingcheng")
    private String jiudianmingcheng;
    @Column(name = "suoshudengji")
    private String suoshudengji;
    @Column(name = "tupian")
    private String tupian;
    @Column(name = "yingyeshijian")
    private String yingyeshijian;
    @Column(name = "dizhi")
    private String dizhi;
    @Column(name = "jiage")
    private Double jiage;
    @Column(name = "liulanliang")
    private Integer liulanliang;
    @Column(name = "miaoshu")
    private String miaoshu;
    @Column(name = "addtime")
    private String addtime;
    @Column(name = "dachuangfang")
    private Integer dachuangfang;
    @Column(name = "shuangchuangfang")
    private Integer shuangchuangfang;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSuoshudengji() {
        return suoshudengji;
    }
    public void setSuoshudengji(String suoshudengji) {
        this.suoshudengji = suoshudengji == null ? "" : suoshudengji.trim();
    }

    public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? "" : tupian.trim();
    }

    public String getYingyeshijian() {
        return yingyeshijian;
    }
    public void setYingyeshijian(String yingyeshijian) {
        this.yingyeshijian = yingyeshijian == null ? "" : yingyeshijian.trim();
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

    public Integer getLiulanliang() {
        return liulanliang;
    }
    public void setLiulanliang(Integer liulanliang) {
        this.liulanliang = liulanliang == null ? 0 : liulanliang;
    }

    public String getMiaoshu() {
        return miaoshu;
    }
    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu == null ? "" : miaoshu.trim();
    }

    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }

    public Integer getDachuangfang() {
        return dachuangfang;
    }
    public void setDachuangfang(Integer dachuangfang) {
        this.dachuangfang = dachuangfang;
    }

    public Integer getShuangchuangfang() {
        return shuangchuangfang;
    }
    public void setShuangchuangfang(Integer shuangchuangfang) {
        this.shuangchuangfang = shuangchuangfang;
    }
}
