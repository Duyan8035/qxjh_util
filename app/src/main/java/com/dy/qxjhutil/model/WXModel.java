package com.dy.qxjhutil.model;

import android.support.annotation.DrawableRes;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by hbysd on 2019/1/20.
 */
@RealmClass
public class WXModel implements RealmModel {
//    public static final String KEY_编号 = "id";
//    public static final String KEY_图片 = "icon";
//    public static final String KEY_真名 = "name";
//    public static final String KEY_称谓 = "name_game";
//    public static final String KEY_初始善恶 = "default_se";
//    public static final String KEY_初始倾向 = "default_qx";
//    public static final String KEY_事件1 = "sj_1_str";
//    public static final String KEY_事件2 = "sj_12_str";
//    public static final String KEY_事件3 = "sj_123_str";
//    public static final String KEY_事件4 = "sj_1234_str";
//    public static final String KEY_事件1id = "sj_1_flag";
//    public static final String KEY_事件2id = "sj_12_flag";
//    public static final String KEY_事件3id = "sj_123_flag";
//    public static final String KEY_事件4id = "sj_1234_flag";
//    public static final String KEY_所得善恶 = "sj_se";
//    public static final String KEY_所得倾向 = "sj_qx";
//    public static final String KEY_所得物品 = "sj_value";
    /**
     * 武侠游戏名称：灵鹫宫主等
     */
    @PrimaryKey
    public String name_game;
    /**
     * 显示图片，暂时用本地图片
     */
    @DrawableRes
    public int icon;
    /**
     * 武侠本身名称：如虚竹
     */
    public String name;
    /**
     * 事件所需初始善恶
     */
    public String default_se;
    /**
     * 事件所需初始倾向
     */
    public String default_qx;

    public RealmList<SJModel> sjModels;

    public WXModel() {
    }

    public class SJModel extends RealmObject {
        /**
         * 事件所得善恶 恶-善 正为善，负为恶
         */
        public int sj_se = 0;
        /**
         * 事件所得倾向 混乱-守序 正为守序，负为混乱
         */
        public int sj_qx = 0;
        /**
         * 事件所得物品：如道具，金币，食物等
         */
        public String sj_value;

        /**
         * 武侠所遇见的事件及分支事件
         */
        public String sj_1_str;
        public String sj_12_str;
        public String sj_123_str;

        /**
         * 等级，第一层为0，第二层选项为1，依次类推
         */
        public int level = 0;

        public RealmList<SJModel> sj_1_list;
        public RealmList<SJModel> sj_12_list;
        public RealmList<SJModel> sj_123_list;

        public int getSj_se() {
            return sj_se;
        }

        public void setSj_se(int sj_se) {
            this.sj_se = sj_se;
        }

        public int getSj_qx() {
            return sj_qx;
        }

        public void setSj_qx(int sj_qx) {
            this.sj_qx = sj_qx;
        }

        public String getSj_value() {
            return sj_value;
        }

        public void setSj_value(String sj_value) {
            this.sj_value = sj_value;
        }

        public String getSj_1_str() {
            return sj_1_str;
        }

        public void setSj_1_str(String sj_1_str) {
            this.sj_1_str = sj_1_str;
        }

        public String getSj_12_str() {
            return sj_12_str;
        }

        public void setSj_12_str(String sj_12_str) {
            this.sj_12_str = sj_12_str;
        }

        public String getSj_123_str() {
            return sj_123_str;
        }

        public void setSj_123_str(String sj_123_str) {
            this.sj_123_str = sj_123_str;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public RealmList<SJModel> getSj_1_list() {
            return sj_1_list;
        }

        public void setSj_1_list(RealmList<SJModel> sj_1_list) {
            this.sj_1_list = sj_1_list;
        }

        public RealmList<SJModel> getSj_12_list() {
            return sj_12_list;
        }

        public void setSj_12_list(RealmList<SJModel> sj_12_list) {
            this.sj_12_list = sj_12_list;
        }

        public RealmList<SJModel> getSj_123_list() {
            return sj_123_list;
        }

        public void setSj_123_list(RealmList<SJModel> sj_123_list) {
            this.sj_123_list = sj_123_list;
        }
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

    public String getDefault_se() {
        return default_se;
    }

    public void setDefault_se(String default_se) {
        this.default_se = default_se;
    }

    public String getDefault_qx() {
        return default_qx;
    }

    public void setDefault_qx(String default_qx) {
        this.default_qx = default_qx;
    }

    public RealmList<SJModel> getSjModels() {
        return sjModels;
    }

    public void setSjModels(RealmList<SJModel> sjModels) {
        this.sjModels = sjModels;
    }
}
