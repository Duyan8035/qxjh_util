package com.dy.qxjhutil.model;

import com.dy.qxjhutil.constant.WxDefaultUtil;

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
    public static final String TYPE_PARENT_1 = WxDefaultUtil.Parent_1;
    public static final String TYPE_PARENT_2 = WxDefaultUtil.Parent_2;
    public static final String TYPE_PARENT_3 = WxDefaultUtil.Parent_3;
    public static final String TYPE_PARENT_4 = WxDefaultUtil.Parent_4;
    public static final String TYPE_PARENT_5 = WxDefaultUtil.Parent_5;

    public static final String TYPE_MAP_1 = WxDefaultUtil.MAP_NAME_1;
    public static final String TYPE_MAP_2 = WxDefaultUtil.MAP_NAME_2;
    public static final String TYPE_MAP_3 = WxDefaultUtil.MAP_NAME_3;
    public static final String TYPE_MAP_4 = WxDefaultUtil.MAP_NAME_4;
    public static final String TYPE_MAP_5 = WxDefaultUtil.MAP_NAME_5;
    public static final String TYPE_MAP_6 = WxDefaultUtil.MAP_NAME_6;

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
