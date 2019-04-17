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

    public RealmList<SjModel> sjModels;

    public WXModel() {
    }

    public String getName_game() {
        return name_game;
    }

    public void setName_game(String name_game) {
        this.name_game = name_game;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<SjModel> getSjModels() {
        if (sjModels == null) {
            return new RealmList<>();
        }
        return sjModels;
    }

    public void setSjModels(RealmList<SjModel> sjModels) {
        this.sjModels = sjModels;
    }

    public int getTrend() {
        return trend;
    }

    public void setTrend(int trend) {
        this.trend = trend;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }
}
