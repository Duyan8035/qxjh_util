package com.dy.qxjhutil.model;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2019/4/29 19
 *
 * @author Dy
 */
@RealmClass
public class ComboModel implements RealmModel {
    @PrimaryKey
    private String name;
    private String parent;
    private String value;
    private RealmList<WXModel> wxModels;
    private RealmList<KungFuModel> fuModels;
    private int start = 0;
    private int over = 0;
    private int qiangdu = 0;
    private String good;
    private String bad;

    public String getGood() {
        return good == null ? "" : good;
    }

    public ComboModel setGood(String good) {
        this.good = good;
        return this;
    }

    public String getBad() {
        return bad == null ? "" : bad;
    }

    public ComboModel setBad(String bad) {
        this.bad = bad;
        return this;
    }

    public ComboModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public ComboModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getParent() {
        return parent == null ? "" : parent;
    }

    public ComboModel setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public String getValue() {
        return value == null ? "" : value;
    }

    public ComboModel setValue(String value) {
        this.value = value;
        return this;
    }

    public RealmList<WXModel> getWxModels() {
        if (wxModels == null) {
            return new RealmList<>();
        }
        return wxModels;
    }

    public ComboModel setWxModels(RealmList<WXModel> wxModels) {
        this.wxModels = wxModels;
        return this;
    }

    public RealmList<KungFuModel> getFuModels() {
        if (fuModels == null) {
            return new RealmList<>();
        }
        return fuModels;
    }

    public ComboModel setFuModels(RealmList<KungFuModel> fuModels) {
        this.fuModels = fuModels;
        return this;
    }

    public int getStart() {
        return start;
    }

    public ComboModel setStart(int start) {
        this.start = start;
        return this;
    }

    public int getOver() {
        return over;
    }

    public ComboModel setOver(int over) {
        this.over = over;
        return this;
    }

    public int getQiangdu() {
        return qiangdu;
    }

    public ComboModel setQiangdu(int qiangdu) {
        this.qiangdu = qiangdu;
        return this;
    }
}
