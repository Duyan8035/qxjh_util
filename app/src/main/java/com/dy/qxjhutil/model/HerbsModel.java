package com.dy.qxjhutil.model;


import androidx.annotation.DrawableRes;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2019/4/29 14
 *
 * @author Dy
 */
@RealmClass
public class HerbsModel implements RealmModel {
    @PrimaryKey
    private String name;
    @DrawableRes
    private int img = -1;

    private int count;
    /**
     * 是否为基础参数
     **/
    private boolean isParent = false;

    private MapModel map1, map2;

    private HerbsModel herbs1, herbs2, herbs3;

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public HerbsModel(String name) {
        this.name = name;
    }

    public HerbsModel() {
    }

    public HerbsModel(String name, MapModel map1, MapModel map2) {
        this.name = name;
        this.map1 = map1;
        this.map2 = map2;
    }


    public HerbsModel(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public HerbsModel(String name, int img, MapModel map1, MapModel map2) {
        this.name = name;
        this.img = img;
        this.map1 = map1;
        this.map2 = map2;
    }


    public int getImg() {
        return img;
    }

    public HerbsModel setImg(int img) {
        this.img = img;
        return this;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public HerbsModel setName(String name) {
        this.name = name;
        return this;
    }

    public int getCount() {
        return count;
    }

    public HerbsModel setCount(int count) {
        this.count = count;
        return this;
    }

    public MapModel getMap1() {
        return map1;
    }

    public HerbsModel setMap1(MapModel map1) {
        this.map1 = map1;
        this.isParent = true;
        return this;
    }

    public MapModel getMap2() {
        return map2;
    }

    public HerbsModel setMap2(MapModel map2) {
        this.map2 = map2;
        this.isParent = true;
        return this;
    }

    public HerbsModel getHerbs1() {
        return herbs1;
    }

    public HerbsModel setHerbs1(HerbsModel herbs1) {
        this.herbs1 = herbs1;
        this.isParent = false;
        return this;
    }

    public HerbsModel getHerbs2() {
        return herbs2;
    }

    public HerbsModel setHerbs2(HerbsModel herbs2) {
        this.herbs2 = herbs2;
        this.isParent = false;
        return this;
    }

    public HerbsModel getHerbs3() {
        return herbs3;
    }

    public HerbsModel setHerbs3(HerbsModel herbs3) {
        this.herbs3 = herbs3;
        this.isParent = false;
        return this;
    }
}
