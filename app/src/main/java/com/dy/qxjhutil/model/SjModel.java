package com.dy.qxjhutil.model;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2019/4/17 13
 *
 * @author Dy
 */
@RealmClass
public class SjModel implements RealmModel {
    private int parent = 0;
    private int level = 0;
    private String value;
    private int trend;
    private int good;

    //    private String parent_str;
    private String obtain;

//    public String getParent_str() {
//        return parent_str == null ? "" : parent_str;
//    }
//
//    public void setParent_str(String parent_str) {
//        this.parent_str = parent_str;
//    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value == null ? "" : value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getObtain() {
        return obtain == null ? "" : obtain;
    }

    public void setObtain(String obtain) {
        this.obtain = obtain;
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
