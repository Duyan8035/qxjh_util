package com.dy.qxjhutil.model;

import android.support.annotation.DrawableRes;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2019/4/29 14
 *
 * @author Dy
 */
@RealmClass
public class MineralModel implements RealmModel {
    @PrimaryKey
    private String name;
    @DrawableRes
    private int img = -1;
    private int count;

    private MapModel map1, map2;

    public MineralModel() {
    }

    public MapModel getMap1() {
        return map1;
    }

    public MineralModel setMap1(MapModel map1) {
        this.map1 = map1;
        return this;
    }

    public MapModel getMap2() {
        return map2;
    }

    public MineralModel setMap2(MapModel map2) {
        this.map2 = map2;
        return this;
    }

    public MineralModel(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public MineralModel setImg(int img) {
        this.img = img;
        return this;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public MineralModel setName(String name) {
        this.name = name;
        return this;
    }

    public int getCount() {
        return count;
    }

    public MineralModel setCount(int count) {
        this.count = count;
        return this;
    }
}
