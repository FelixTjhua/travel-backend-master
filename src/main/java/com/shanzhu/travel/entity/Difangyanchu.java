package com.shanzhu.travel.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "difangyanchu")
public class Difangyanchu implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "yanchubianhao")
    private String yanchubianhao;
    @Column(name = "mingcheng")
    private String mingcheng;
    @Column(name = "fujinjingdian")
    private String fujinjingdian;
    @Column(name = "fenlei")
    private String fenlei;
    @Column(name = "tupian")
    private String tupian;
    @Column(name = "jiage")
    private Double jiage;
    @Column(name = "yanchujianjie")
    private String yanchujianjie;
    @Column(name = "addtime")
    private String addtime;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getYanchubianhao() {
        return yanchubianhao;
    }
    public void setYanchubianhao(String meishibianhao) {
        this.yanchubianhao = meishibianhao == null ? "" : meishibianhao.trim();
    }

    public String getMingcheng() {
        return mingcheng;
    }
    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng == null ? "" : mingcheng.trim();
    }

    public String getFujinjingdian() {
        return fujinjingdian;
    }
    public void setFujinjingdian(String fujinjingdian) {
        this.fujinjingdian = fujinjingdian == null ? "" : fujinjingdian.trim();
    }

    public String getFenlei() {
        return fenlei;
    }
    public void setFenlei(String fenlei) {
        this.fenlei = fenlei == null ? "" : fenlei.trim();
    }

    public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? "" : tupian.trim();
    }

    public Double getJiage() {
        return jiage;
    }
    public void setJiage(Double jiage) {
        this.jiage = jiage == null ? 0.0f : jiage;
    }

    public String getYanchujianjie() {
        return yanchujianjie;
    }
    public void setYanchujianjie(String meishijianjie) {
        this.yanchujianjie = meishijianjie == null ? "" : meishijianjie.trim();
    }

    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }

}
