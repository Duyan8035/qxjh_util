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
public class ArtifactModel implements RealmModel {

    @PrimaryKey
    private String name;

    @DrawableRes
    private int img = -1;

    private String cd;
    private String value;
    private String desc;

    private MineralModel mineralModel1, mineralModel2, mineralModel3;
    private String str1, str2, str3;
    private MapModel mapModel;
    private String parent;

    public ArtifactModel() {
    }

    public MapModel getMapModel() {
        return mapModel;
    }

    public ArtifactModel setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
        return this;
    }

    public String getParent() {
        return parent == null ? "" : parent;
    }

    public ArtifactModel setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public ArtifactModel(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public ArtifactModel setImg(int img) {
        this.img = img;
        return this;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public ArtifactModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCd() {
        return cd == null ? "" : cd;
    }

    public ArtifactModel setCd(String cd) {
        this.cd = cd;
        return this;
    }

    public String getValue() {
        return value == null ? "" : value;
    }

    public ArtifactModel setValue(String value) {
        this.value = value;
        return this;
    }

    public String getDesc() {
        return desc == null ? "" : desc;
    }

    public ArtifactModel setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public MineralModel getMineralModel1() {
        return mineralModel1;
    }

    public ArtifactModel setMineralModel1(MineralModel mineralModel1) {
        this.mineralModel1 = mineralModel1;
        return this;
    }

    public MineralModel getMineralModel2() {
        return mineralModel2;
    }

    public ArtifactModel setMineralModel2(MineralModel mineralModel2) {
        this.mineralModel2 = mineralModel2;
        return this;
    }

    public MineralModel getMineralModel3() {
        return mineralModel3;
    }

    public ArtifactModel setMineralModel3(MineralModel mineralModel3) {
        this.mineralModel3 = mineralModel3;
        return this;
    }

    public String getStr1() {
        return str1 == null ? "" : str1;
    }

    public ArtifactModel setStr1(String str1) {
        this.str1 = str1;
        return this;
    }

    public String getStr2() {
        return str2 == null ? "" : str2;
    }

    public ArtifactModel setStr2(String str2) {
        this.str2 = str2;
        return this;
    }

    public String getStr3() {
        return str3 == null ? "" : str3;
    }

    public ArtifactModel setStr3(String str3) {
        this.str3 = str3;
        return this;
    }
}
