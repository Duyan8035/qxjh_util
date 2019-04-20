package com.dy.qxjhutil.model;

import android.support.annotation.DrawableRes;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by hbysd on 2019/1/20.
 */
@RealmClass
public class WXModel implements RealmModel {

    @PrimaryKey
    public String name_game;
    @DrawableRes
    public int icon;

    public String name;
    private int trend;
    private int good;
    private String parent;

    private String type;

    private String index;

    private boolean isMap1 = false;
    private boolean isMap2 = false;
    private boolean isMap3 = false;
    private boolean isMap4 = false;
    private boolean isMap5 = false;
    private boolean isMap6 = false;

    public RealmList<SjModel> sjModels = new RealmList<>();

    public String getParent() {
        return parent == null ? "" : parent;
    }

    public WXModel setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public WXModel() {
    }

    public WXModel(String name_game, int trend, int good) {
        this.name_game = name_game;
        this.trend = trend;
        this.good = good;
    }

    public WXModel(String name_game, int trend, int good, String parent) {
        this.name_game = name_game;
        this.trend = trend;
        this.good = good;
        this.parent = parent;
    }

    public WXModel(String name_game, int icon, String name, int trend, int good) {
        this.name_game = name_game;
        this.icon = icon;
        this.name = name;
        this.trend = trend;
        this.good = good;
    }

    public String getName_game() {
        return name_game;
    }

    public WXModel setName_game(String name_game) {
        this.name_game = name_game;
        return this;
    }

    public int getIcon() {
        return icon;
    }

    public WXModel setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getName() {
        return name;
    }

    public WXModel setName(String name) {
        this.name = name;
        return this;
    }

    public RealmList<SjModel> getSjModels() {
        if (sjModels == null) {
            return new RealmList<>();
        }
        return sjModels;
    }

    public WXModel setSjModels(RealmList<SjModel> sjModels) {
        this.sjModels = sjModels;
        return this;
    }

    public int getTrend() {
        return trend;
    }

    public WXModel setTrend(int trend) {
        this.trend = trend;
        return this;
    }

    public int getGood() {
        return good;
    }

    public WXModel setGood(int good) {
        this.good = good;
        return this;
    }

    public String getIndex() {
        return index == null ? "" : index;
    }

    public WXModel setIndex(String index) {
        this.index = index;
        return this;
    }

    public boolean isMap1() {
        return isMap1;
    }

    public WXModel setMap1(boolean map1) {
        isMap1 = map1;
        return this;
    }


    public boolean isMap2() {
        return isMap2;
    }

    public WXModel setMap2(boolean map2) {
        isMap2 = map2;
        return this;
    }


    public boolean isMap3() {
        return isMap3;
    }

    public WXModel setMap3(boolean map3) {
        isMap3 = map3;
        return this;
    }


    public boolean isMap4() {
        return isMap4;
    }

    public WXModel setMap4(boolean map4) {
        isMap4 = map4;
        return this;
    }


    public boolean isMap5() {
        return isMap5;
    }

    public WXModel setMap5(boolean map5) {
        isMap5 = map5;
        return this;
    }


    public boolean isMap6() {
        return isMap6;
    }

    public WXModel setMap6(boolean map6) {
        isMap6 = map6;
        return this;
    }


    public WXModel setMap(boolean isMap1, boolean isMap2, boolean isMap3, boolean isMap4, boolean isMap5, boolean isMap6) {
        this.isMap1 = isMap1;
        this.isMap2 = isMap2;
        this.isMap3 = isMap3;
        this.isMap4 = isMap4;
        this.isMap5 = isMap5;
        this.isMap6 = isMap6;
        return this;
    }
}
