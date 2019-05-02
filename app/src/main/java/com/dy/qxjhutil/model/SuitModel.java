package com.dy.qxjhutil.model;

import com.dy.qxjhutil.constant.NameModel;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2019/4/20 11
 *
 * @author Dy
 */
@RealmClass
public class SuitModel implements RealmModel {
    public static final String TYPE_DEFAULT = "通用";
    public static final String TYPE_PARENT_1 = NameModel.Parent_1;
    public static final String TYPE_PARENT_2 = NameModel.Parent_2;
    public static final String TYPE_PARENT_3 = NameModel.Parent_3;
    public static final String TYPE_PARENT_4 = NameModel.Parent_4;
    public static final String TYPE_PARENT_5 = NameModel.Parent_5;

    public static final String TYPE_MAP_1 = NameModel.MAP_NAME_1;
    public static final String TYPE_MAP_2 = NameModel.MAP_NAME_2;
    public static final String TYPE_MAP_3 = NameModel.MAP_NAME_3;
    public static final String TYPE_MAP_4 = NameModel.MAP_NAME_4;
    public static final String TYPE_MAP_5 = NameModel.MAP_NAME_5;
    public static final String TYPE_MAP_6 = NameModel.MAP_NAME_6;

    private String name;
    private String value;

    private String type = TYPE_DEFAULT;
    private int count;

    public SuitModel() {
    }

    public SuitModel(String name, String value, String type, int count) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.count = count;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public SuitModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value == null ? "" : value;
    }

    public SuitModel setValue(String value) {
        this.value = value;
        return this;
    }

    public String getType() {
        return type == null ? "" : type;
    }

    public SuitModel setType(String type) {
        this.type = type;
        return this;
    }

    public int getCount() {
        return count;
    }

    public SuitModel setCount(int count) {
        this.count = count;
        return this;
    }
}
