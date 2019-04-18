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

    public String getParent() {
        return parent == null ? "" : parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public RealmList<SjModel> sjModels;

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
}
