package com.dy.qxjhutil.model;

import com.dy.qxjhutil.constant.NameModel;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2020/2/19 11
 *
 * @author Dy
 */
@RealmClass
public class HxModel implements RealmModel {

    public static final String type_qh_强化 = "【强化】";
    public static final String type_th_替换 = "→";
    public static final String type_xl_修炼 = "【修炼自带武学】";
    public static final String type_xz_新增 = "【新增】";
    /**
     * 化形id：武侠名+化形名
     **/
    @PrimaryKey
    private String hx_id;

    private WXModel wxModel;
    private String wx_name;
    private String parent;

    /**
     * 化形的名称：天罡，天机，毕方啥的。
     **/
    private String hx_name;
    /**
     * 化形类型 如：武神飞天等
     **/
    private String hx_type;
    /**
     * 化形的品质，分为：神话（红）传奇（橙）史诗（紫）稀有（蓝）优秀（绿）
     **/
    private int hx_level;

    /**
     * 1：强化初始技能，增加新技能（突破）
     * 2：强化自带武学，强化初始技能（突破）
     * 3：初始卡牌替换，强化初始技能（突破）
     **/
    private int hx_value;
    /**
     * 初始卡修炼
     **/
    private String hx_value_1;
    /**
     * 初始卡替换
     **/
    private String hx_value_2;
    /**
     * 强化初始技能
     **/
    private String hx_value_3;
    /**
     * 增加新技能
     **/
    private String hx_value_4;
    private String hx_value_default;
    private String hx_value_up;
    /**
     * 评价 0 = 默认，无用 1 = 有用 2 = 推荐
     **/
    private int hx_star_lv = 0;

    public int getHx_star_lv() {
        return hx_star_lv;
    }

    public HxModel setHx_star_lv(int hx_star_lv) {
        this.hx_star_lv = hx_star_lv;
        return this;
    }

    public String getParent() {
        return parent == null ? "" : parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getHx_value() {
        return hx_value;
    }

    public HxModel setHx_value(int hx_value) {
        this.hx_value = hx_value;
        return this;
    }

    public String getWx_name() {
        return wx_name == null ? "" : wx_name;
    }

    public HxModel setWx_name(String wx_name) {
        this.wx_name = wx_name;
        return this;
    }

    public String getHx_type() {
        return hx_type == null ? "" : hx_type;
    }

    public HxModel setHx_type(String hx_type) {
        this.hx_type = hx_type;
        return this;
    }

    public String getHx_value_4() {
        return hx_value_4 == null ? "-" : hx_value_4;
    }

    public HxModel setHx_value_4(String hx_value_4) {
        this.hx_value_4 = hx_value_4;
        return this;
    }

    public String getHx_value_default() {
        return hx_value_default == null ? "" : hx_value_default;
    }

    public HxModel setHx_value_default(String hx_value_default) {
        this.hx_value_default = hx_value_default;
        return this;
    }

    public String getHx_value_up() {
        return hx_value_up == null ? "" : hx_value_up;
    }

    public HxModel setHx_value_up(String hx_value_up) {
        this.hx_value_up = hx_value_up;
        return this;
    }

    public String getHx_id() {
        return hx_id == null ? "" : hx_id;
    }

    public HxModel setHx_id(String hx_id) {
        this.hx_id = hx_id;
        return this;
    }

    public WXModel getWxModel() {
        return wxModel;
    }

    public HxModel setWxModel(WXModel wxModel) {
        this.wxModel = wxModel;
        return this;
    }

    public String getHx_name() {
        return hx_name == null ? "" : hx_name;
    }

    public HxModel setHx_name(String hx_name) {
        this.hx_name = hx_name;
        return this;
    }

    public int getHx_level() {
        return hx_level;
    }

    public String getHxLvName() {
        switch (getHx_level()) {
            case NameModel.HX_Lv_1_优秀:
                return "优秀";
            case NameModel.HX_Lv_2_稀有:
                return "稀有";
            case NameModel.HX_Lv_3_史诗:
                return "史诗";
            case NameModel.HX_Lv_4_传奇:
                return "传奇";
            case NameModel.HX_Lv_5_神话:
                return "神话";
            default:
                return "";
        }
    }

    public HxModel setHx_level(int hx_level) {
        this.hx_level = hx_level;
        return this;
    }

    public String getHx_value_1() {
        return hx_value_1 == null ? "-" : hx_value_1;
    }

    public HxModel setHx_value_1(String hx_value_1) {
        this.hx_value_1 = hx_value_1;
        return this;
    }

    public String getHx_value_2() {
        return hx_value_2 == null ? "-" : hx_value_2;
    }

    public HxModel setHx_value_2(String hx_value_2) {
        this.hx_value_2 = hx_value_2;
        return this;
    }

    public String getHx_value_3() {
        return hx_value_3 == null ? "-" : hx_value_3;
    }

    public HxModel setHx_value_3(String hx_value_3) {
        this.hx_value_3 = hx_value_3;
        return this;
    }
}
