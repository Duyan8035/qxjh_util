package com.dy.qxjhutil.model;

import android.support.annotation.DrawableRes;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2019/4/20 11
 *
 * @author Dy
 */
@RealmClass
public class MapModel implements RealmModel {
    @PrimaryKey
    private String mapName = "";
    /**
     * 特性
     **/
    private String value = "";

    @DrawableRes
    private int img = -1;

    public RealmList<SuitModel> suitModel = new RealmList<>();

    private KungFuModel fuModel1, fuModel2;


    public int getImg() {
        return img;
    }

    public MapModel setImg(int img) {
        this.img = img;
        return this;
    }

    public String getMapName() {
        return mapName == null ? "" : mapName;
    }

    public MapModel setMapName(String mapName) {
        this.mapName = mapName;
        return this;
    }

    public String getValue() {
        return value == null ? "" : value;
    }

    public MapModel setValue(String value) {
        this.value = value;
        return this;
    }


    public RealmList<SuitModel> getSuitModel() {
        if (suitModel == null) {
            return new RealmList<>();
        }
        return suitModel;
    }

    public MapModel setSuitModel(RealmList<SuitModel> suitModel) {
        this.suitModel = suitModel;
        return this;
    }

    public KungFuModel getFuModel1() {
        if (fuModel1 == null) {
            return new KungFuModel();
        }
        return fuModel1;
    }

    public MapModel setFuModel1(KungFuModel fuModel1) {
        this.fuModel1 = fuModel1;
        return this;
    }

    public KungFuModel getFuModel2() {
        if (fuModel2 == null) {
            return new KungFuModel();
        }
        return fuModel2;
    }

    public MapModel setFuModel2(KungFuModel fuModel2) {
        this.fuModel2 = fuModel2;
        return this;
    }
}

