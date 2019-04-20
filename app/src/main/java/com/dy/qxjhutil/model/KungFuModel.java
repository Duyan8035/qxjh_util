package com.dy.qxjhutil.model;

import android.support.annotation.DrawableRes;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2019/4/20 12
 *
 * @author Dy
 */
@RealmClass
public class KungFuModel implements RealmModel {

    @PrimaryKey
    public String name;

    @DrawableRes
    private int img;
    /**
     * 描述
     **/
    private String desc_1, desc_2, desc_3;

    private String cost_1, cost_2, cost_3;
    /**
     * 所属
     **/
    private String parent;

    /**
     * 获取途径
     **/
    private String type;
    /**
     * 获取
     **/
    private WXModel wx_parent;
    /**
     * 默认
     **/
    private WXModel wx_default;

    private int trendMin, trendMax;
    private int goodMin, goodMax;

    public KungFuModel() {
    }

    public KungFuModel(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public KungFuModel setImg(int img) {
        this.img = img;
        return this;
    }

    public int getTrendMin() {
        return trendMin;
    }

    public KungFuModel setTrendMin(int trendMin) {
        this.trendMin = trendMin;
        return this;
    }

    public int getTrendMax() {
        return trendMax;
    }

    public KungFuModel setTrendMax(int trendMax) {
        this.trendMax = trendMax;
        return this;
    }

    public KungFuModel setTrendGood(int trendMin, int goodMin) {
        this.trendMin = trendMin;
        this.goodMin = goodMin;
        return this;
    }


    public int getGoodMin() {
        return goodMin;
    }

    public KungFuModel setGoodMin(int goodMin) {
        this.goodMin = goodMin;
        return this;
    }

    public int getGoodMax() {
        return goodMax;
    }

    public KungFuModel setGoodMax(int goodMax) {
        this.goodMax = goodMax;
        return this;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public KungFuModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc_1() {
        return desc_1 == null ? "" : desc_1;
    }

    public KungFuModel setDesc_1(String desc_1) {
        this.desc_1 = desc_1;
        return this;
    }

    public String getDesc_2() {
        return desc_2 == null ? "" : desc_2;
    }

    public KungFuModel setDesc_2(String desc_2) {
        this.desc_2 = desc_2;
        return this;
    }

    public String getDesc_3() {
        return desc_3 == null ? "" : desc_3;
    }

    public KungFuModel setDesc_3(String desc_3) {
        this.desc_3 = desc_3;
        return this;
    }

    public String getCost_1() {
        return cost_1 == null ? "" : cost_1;
    }

    public KungFuModel setCost_1(String cost_1) {
        this.cost_1 = cost_1;
        return this;
    }

    public String getCost_2() {
        return cost_2 == null ? "" : cost_2;
    }

    public KungFuModel setCost_2(String cost_2) {
        this.cost_2 = cost_2;
        return this;
    }

    public String getCost_3() {
        return cost_3 == null ? "" : cost_3;
    }

    public KungFuModel setCost_3(String cost_3) {
        this.cost_3 = cost_3;
        return this;
    }

    public String getParent() {
        return parent == null ? "" : parent;
    }

    public KungFuModel setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public String getType() {
        return type == null ? "" : type;
    }

    public KungFuModel setType(String type) {
        this.type = type;
        return this;
    }

    public WXModel getWx_parent() {
        if (wx_parent == null) {
            wx_parent = new WXModel();
        }
        return wx_parent;
    }

    public KungFuModel setWx_parent(WXModel wx_parent) {
        this.wx_parent = wx_parent;
        return this;
    }

    public WXModel getWx_default() {
        if (wx_default == null) {
            wx_default = new WXModel();
        }
        return wx_default;
    }

    public KungFuModel setWx_default(WXModel wx_default) {
        this.wx_default = wx_default;
        return this;
    }
}
