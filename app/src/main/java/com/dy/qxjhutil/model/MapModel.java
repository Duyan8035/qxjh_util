package com.dy.qxjhutil.model;


import androidx.annotation.DrawableRes;

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
    private WXModel wxModel1, wxModel2;

    private RealmList<HerbsModel> herbsList = new RealmList<>();
    private RealmList<MineralModel> mineralList = new RealmList<>();
    private RealmList<ArtifactModel> artifactList = new RealmList<>();

    public MapModel() {
    }

    public MapModel(String mapName) {
        this.mapName = mapName;
    }


    public WXModel getWxModel1() {
        return wxModel1;
    }

    public MapModel setWxModel1(WXModel wxModel1) {
        this.wxModel1 = wxModel1;
        return this;
    }

    public WXModel getWxModel2() {
        return wxModel2;
    }

    public MapModel setWxModel2(WXModel wxModel2) {
        this.wxModel2 = wxModel2;
        return this;
    }

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

    public RealmList<HerbsModel> getHerbsList() {
        if (herbsList == null) {
            return new RealmList<>();
        }
        return herbsList;
    }

    public void setHerbsList(RealmList<HerbsModel> herbsList) {
        this.herbsList = herbsList;
    }

    public RealmList<MineralModel> getMineralList() {
        if (mineralList == null) {
            return new RealmList<>();
        }
        return mineralList;
    }

    public void setMineralList(RealmList<MineralModel> mineralList) {
        this.mineralList = mineralList;
    }

    public RealmList<ArtifactModel> getArtifactList() {
        if (artifactList == null) {
            return new RealmList<>();
        }
        return artifactList;
    }

    public void setArtifactList(RealmList<ArtifactModel> artifactList) {
        this.artifactList = artifactList;
    }

    public MapModel setMineral(MineralModel mineral1, MineralModel mineral2, MineralModel mineral3, MineralModel mineral4, MineralModel mineral5) {
        RealmList<MineralModel> models = new RealmList<>();
        models.add(mineral1);
        models.add(mineral2);
        models.add(mineral3);
        models.add(mineral4);
        models.add(mineral5);
        setMineralList(models);
        return this;
    }

    public MapModel setMineral(MineralModel mineral1, MineralModel mineral2, MineralModel mineral3, MineralModel mineral4) {
        RealmList<MineralModel> models = new RealmList<>();
        models.add(mineral1);
        models.add(mineral2);
        models.add(mineral3);
        models.add(mineral4);
        setMineralList(models);
        return this;
    }

    public MapModel setMineral(MineralModel mineral1, MineralModel mineral2, MineralModel mineral3) {
        RealmList<MineralModel> models = new RealmList<>();
        models.add(mineral1);
        models.add(mineral2);
        models.add(mineral3);
        setMineralList(models);
        return this;
    }

    public MapModel setHerbs(HerbsModel mineral1, HerbsModel mineral2, HerbsModel mineral3, HerbsModel mineral4) {
        RealmList<HerbsModel> models = new RealmList<>();
        models.add(mineral1);
        models.add(mineral2);
        models.add(mineral3);
        models.add(mineral4);
        setHerbsList(models);
        return this;
    }

    public MapModel setHerbs(HerbsModel mineral1, HerbsModel mineral2, HerbsModel mineral3) {
        RealmList<HerbsModel> models = new RealmList<>();
        models.add(mineral1);
        models.add(mineral2);
        models.add(mineral3);
        setHerbsList(models);
        return this;
    }

    public MapModel setArtifact(ArtifactModel mineral1, ArtifactModel mineral2) {
        RealmList<ArtifactModel> models = new RealmList<>();
        models.add(mineral1);
        models.add(mineral2);
        setArtifactList(models);
        return this;
    }
}

