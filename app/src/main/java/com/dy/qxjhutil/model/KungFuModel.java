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

    private String index;
    @DrawableRes
    private int img;
    /**
     * 描述
     **/
    private String desc;
    private String cost;
    /**
     * 所属
     **/
    private String parent;

    /**
     * 获取途径 0:基础 1：拓印 2：成就 3：武侠自带 4：隐藏
     **/
    private int type;
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

    public String getIndex() {
        return index == null ? "" : index;
    }

    public KungFuModel setIndex(String index) {
        this.index = index;
        return this;
    }

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

    public String getDesc() {
        return desc == null ? "" : desc;
    }

    public KungFuModel setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getCost() {
        return cost == null ? "" : cost;
    }

    public KungFuModel setCost(String cost) {
        this.cost = cost;
        return this;
    }

    public String getParent() {
        return parent == null ? "" : parent;
    }

    public KungFuModel setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public int getType() {
        return type;
    }

    public KungFuModel setType(int type) {
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
        return wx_default;
    }

    public KungFuModel setWx_default(WXModel wx_default) {
        this.wx_default = wx_default;
        return this;
    }
}
