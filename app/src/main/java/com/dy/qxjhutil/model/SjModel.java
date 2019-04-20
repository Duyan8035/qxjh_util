package com.dy.qxjhutil.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.dy.qxjhutil.adapter.WxSjListAdapter;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2019/4/17 13
 *
 * @author Dy
 */
@RealmClass
public class SjModel implements RealmModel, MultiItemEntity {
    private int type = 0;

    private String desc;
    /**
     * 一级分类
     **/
    private String value_1, value_2, value_3;
    /**
     * 二级分类
     **/
    private String branch_11, branch_12, branch_13, branch_21, branch_22, branch_23, branch_31, branch_32, branch_33;
    /**
     * 二级分类结果
     **/
    private String obtain_11, obtain_12, obtain_13, obtain_21, obtain_22, obtain_23, obtain_31, obtain_32, obtain_33;
    private int trend_11, trend_12, trend_13, trend_21, trend_22, trend_23, trend_31, trend_32, trend_33;
    private int good_11, good_12, good_13, good_21, good_22, good_23, good_31, good_32, good_33;


    /**
     * 1:单行 2:双行 3:三行
     **/
    private int item_type = 1;

    public SjModel() {
    }


    public int getType() {
        return type;
    }

    public SjModel setType(int type) {
        this.type = type;
        return this;
    }

    public String getDesc() {
        return desc == null ? "" : desc;
    }

    public SjModel setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getValue_1() {
        return value_1 == null ? "" : value_1;
    }

    public SjModel setValue_1(String value_1) {
        this.value_1 = value_1;
        return this;
    }

    public String getValue_2() {
        return value_2 == null ? "" : value_2;
    }

    public SjModel setValue_2(String value_2) {
        this.value_2 = value_2;
        return this;
    }

    public String getValue_3() {
        return value_3 == null ? "" : value_3;
    }

    public SjModel setValue_3(String value_3) {
        this.value_3 = value_3;
        return this;
    }

    public String getBranch_11() {
        return branch_11 == null ? "" : branch_11;
    }

    public SjModel setBranch_11(String branch_11) {
        this.branch_11 = branch_11;
        return this;
    }

    public String getBranch_12() {
        return branch_12 == null ? "" : branch_12;
    }

    public SjModel setBranch_12(String branch_12) {
        this.branch_12 = branch_12;
        return this;
    }

    public String getBranch_13() {
        return branch_13 == null ? "" : branch_13;
    }

    public SjModel setBranch_13(String branch_13) {
        this.branch_13 = branch_13;
        return this;
    }

    public String getBranch_21() {
        return branch_21 == null ? "" : branch_21;
    }

    public SjModel setBranch_21(String branch_21) {
        this.branch_21 = branch_21;
        return this;
    }

    public String getBranch_22() {
        return branch_22 == null ? "" : branch_22;
    }

    public SjModel setBranch_22(String branch_22) {
        this.branch_22 = branch_22;
        return this;
    }

    public String getBranch_23() {
        return branch_23 == null ? "" : branch_23;
    }

    public SjModel setBranch_23(String branch_23) {
        this.branch_23 = branch_23;
        return this;
    }

    public String getBranch_31() {
        return branch_31 == null ? "" : branch_31;
    }

    public SjModel setBranch_31(String branch_31) {
        this.branch_31 = branch_31;
        return this;
    }

    public String getBranch_32() {
        return branch_32 == null ? "" : branch_32;
    }

    public SjModel setBranch_32(String branch_32) {
        this.branch_32 = branch_32;
        return this;
    }

    public String getBranch_33() {
        return branch_33 == null ? "" : branch_33;
    }

    public SjModel setBranch_33(String branch_33) {
        this.branch_33 = branch_33;
        return this;
    }

    public String getObtain_11() {
        return obtain_11 == null ? "" : obtain_11;
    }

    public SjModel setObtain_11(String obtain_11) {
        this.obtain_11 = obtain_11;
        return this;
    }

    public String getObtain_12() {
        return obtain_12 == null ? "" : obtain_12;
    }

    public SjModel setObtain_12(String obtain_12) {
        this.obtain_12 = obtain_12;
        return this;
    }

    public String getObtain_13() {
        return obtain_13 == null ? "" : obtain_13;
    }

    public SjModel setObtain_13(String obtain_13) {
        this.obtain_13 = obtain_13;
        return this;
    }

    public String getObtain_21() {
        return obtain_21 == null ? "" : obtain_21;
    }

    public SjModel setObtain_21(String obtain_21) {
        this.obtain_21 = obtain_21;
        return this;
    }

    public String getObtain_22() {
        return obtain_22 == null ? "" : obtain_22;
    }

    public SjModel setObtain_22(String obtain_22) {
        this.obtain_22 = obtain_22;
        return this;
    }

    public String getObtain_23() {
        return obtain_23 == null ? "" : obtain_23;
    }

    public SjModel setObtain_23(String obtain_23) {
        this.obtain_23 = obtain_23;
        return this;
    }

    public String getObtain_31() {
        return obtain_31 == null ? "" : obtain_31;
    }

    public SjModel setObtain_31(String obtain_31) {
        this.obtain_31 = obtain_31;
        return this;
    }

    public String getObtain_32() {
        return obtain_32 == null ? "" : obtain_32;
    }

    public SjModel setObtain_32(String obtain_32) {
        this.obtain_32 = obtain_32;
        return this;
    }

    public String getObtain_33() {
        return obtain_33 == null ? "" : obtain_33;
    }

    public SjModel setObtain_33(String obtain_33) {
        this.obtain_33 = obtain_33;
        return this;
    }

    public int getTrend_11() {
        return trend_11;
    }

    public SjModel setTrend_11(int trend_11) {
        this.trend_11 = trend_11;
        return this;
    }

    public int getTrend_12() {
        return trend_12;
    }

    public SjModel setTrend_12(int trend_12) {
        this.trend_12 = trend_12;
        return this;
    }

    public int getTrend_13() {
        return trend_13;
    }

    public SjModel setTrend_13(int trend_13) {
        this.trend_13 = trend_13;
        return this;
    }

    public int getTrend_21() {
        return trend_21;
    }

    public SjModel setTrend_21(int trend_21) {
        this.trend_21 = trend_21;
        return this;
    }

    public int getTrend_22() {
        return trend_22;
    }

    public SjModel setTrend_22(int trend_22) {
        this.trend_22 = trend_22;
        return this;
    }

    public int getTrend_23() {
        return trend_23;
    }

    public SjModel setTrend_23(int trend_23) {
        this.trend_23 = trend_23;
        return this;
    }

    public int getTrend_31() {
        return trend_31;
    }

    public SjModel setTrend_31(int trend_31) {
        this.trend_31 = trend_31;
        return this;
    }

    public int getTrend_32() {
        return trend_32;
    }

    public SjModel setTrend_32(int trend_32) {
        this.trend_32 = trend_32;
        return this;
    }

    public int getTrend_33() {
        return trend_33;
    }

    public SjModel setTrend_33(int trend_33) {
        this.trend_33 = trend_33;
        return this;
    }

    public int getGood_11() {
        return good_11;
    }

    public SjModel setGood_11(int good_11) {
        this.good_11 = good_11;
        return this;
    }

    public int getGood_12() {
        return good_12;
    }

    public SjModel setGood_12(int good_12) {
        this.good_12 = good_12;
        return this;
    }

    public int getGood_13() {
        return good_13;
    }

    public SjModel setGood_13(int good_13) {
        this.good_13 = good_13;
        return this;
    }

    public int getGood_21() {
        return good_21;
    }

    public SjModel setGood_21(int good_21) {
        this.good_21 = good_21;
        return this;
    }

    public int getGood_22() {
        return good_22;
    }

    public SjModel setGood_22(int good_22) {
        this.good_22 = good_22;
        return this;
    }

    public int getGood_23() {
        return good_23;
    }

    public SjModel setGood_23(int good_23) {
        this.good_23 = good_23;
        return this;
    }

    public int getGood_31() {
        return good_31;
    }

    public SjModel setGood_31(int good_31) {
        this.good_31 = good_31;
        return this;
    }

    public int getGood_32() {
        return good_32;
    }

    public SjModel setGood_32(int good_32) {
        this.good_32 = good_32;
        return this;
    }

    public int getGood_33() {
        return good_33;
    }

    public SjModel setGood_33(int good_33) {
        this.good_33 = good_33;
        return this;
    }


    /**
     * 1-1 无分支
     **/
    public SjModel setType1(String value_1, String obtain_11, int trend_11, int good_11) {
        this.value_1 = value_1;
        this.obtain_11 = obtain_11;
        this.trend_11 = trend_11;
        this.good_11 = good_11;
        this.item_type = WxSjListAdapter.TYPE_1;
        return this;
    }


    public SjModel setType2(String value_1, String branch_11, String obtain_11, int trend_11, int good_11, String branch_21, String obtain_21,
                            int trend_21, int good_21) {
        this.value_1 = value_1;
        this.branch_11 = branch_11;
        this.branch_21 = branch_21;
        this.obtain_11 = obtain_11;
        this.obtain_21 = obtain_21;
        this.trend_11 = trend_11;
        this.trend_21 = trend_21;
        this.good_11 = good_11;
        this.good_21 = good_21;
        this.item_type = WxSjListAdapter.TYPE_2;
        return this;
    }

    public SjModel setType2(String value_1,
                            String branch_11, String obtain_11, int trend_11, int good_11,
                            String branch_21, String obtain_21, int trend_21, int good_21,
                            String branch_31, String obtain_31, int trend_31, int good_31) {
        this.value_1 = value_1;
        this.branch_11 = branch_11;
        this.branch_21 = branch_21;
        this.branch_31 = branch_31;
        this.obtain_11 = obtain_11;
        this.obtain_21 = obtain_21;
        this.obtain_31 = obtain_31;
        this.trend_11 = trend_11;
        this.trend_21 = trend_21;
        this.trend_31 = trend_31;
        this.good_11 = good_11;
        this.good_21 = good_21;
        this.good_31 = good_31;
        this.item_type = WxSjListAdapter.TYPE_3;
        return this;
    }

    @Override
    public int getItemType() {
        return item_type;
    }

    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }
}
