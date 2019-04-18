package com.dy.qxjhutil.data;

import android.content.Context;

import com.dy.qxjhutil.model.SjModel;
import com.dy.qxjhutil.model.WXModel;

import io.realm.Realm;

/**
 * Created by Dy on 2019/4/18 22
 *
 * @author Dy
 */
public class WxDefaultModel {
    private static final String Parent_1 = "中立";
    private static final String Parent_2 = "豪侠";
    private static final String Parent_3 = "游侠";
    private static final String Parent_4 = "刺客";
    private static final String Parent_5 = "气宗";

    public static String[] stringList = {
            "两小无猜", "青梅竹马",
            "凶神恶煞", "金国小王爷", "飞天蝙蝠", "狮王", "燕子坞主", "大轮明王", "灭绝道姑", "灵鹫宫主", "明教教主", "南苑大王", "丐帮帮主", "白陀山主", "少林三僧",
            "不可不戒", "长春首徒", "邵敏郡主", "无恶不作", "小东邪", "君子剑", "龙姑娘", "林家公子", "金刀驸马", "蓉儿", "神雕大侠", "九剑传人", "剑圣",
            "玉面孟尝", "婉儿", "穷凶极恶", "余观主", "蝠王", "鹰王", "阿紫", "铜尸", "铁尸", "金轮国师", "峨眉掌门", "东方姑娘", "聪辩先生",
            "白驼山少主", "灵儿", "波斯圣女", "恶贯满盈", "玄冥二老", "神仙姐姐", "魔教圣女", "龙王", "星宿老仙", "扫地僧", "大理世子", "魔教教主", "大理皇帝", "东海岛主", "武当掌门",
    };


    public void initData(Context mContext) {
        Realm.init(mContext);
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (int i = 0; i < stringList.length; i++) {
                    realm.copyToRealmOrUpdate(getModel(stringList[i]));
                }
            }
        });
    }


    private WXModel getModel(String userName) {
        WXModel wxModel = new WXModel();
        wxModel.setName_game(userName);
        switch (userName) {
            case "两小无猜":
                wxModel.setTrend(0).setGood(0).setParent(Parent_1);
                break;
            case "青梅竹马":
                wxModel.setTrend(0).setGood(0).setParent(Parent_1);
                break;
            case "凶神恶煞":
                wxModel.setTrend(0).setGood(0).setParent(Parent_2);
                break;
            case "金国小王爷":
                wxModel.setTrend(0).setGood(0).setParent(Parent_2);
                break;
            case "飞天蝙蝠":
                wxModel.setTrend(-1).setGood(0).setParent(Parent_2);
                break;
            case "狮王":
                wxModel.setTrend(-1).setGood(-1).setParent(Parent_2);
                break;
            case "燕子坞主":
                wxModel.setTrend(1).setGood(-1).setParent(Parent_2);
                break;
            case "大轮明王":
                wxModel.setTrend(1).setGood(1).setParent(Parent_2);
                break;
            case "灭绝道姑":
                wxModel.setTrend(-1).setGood(0).setParent(Parent_2);
                break;
            case "灵鹫宫主":
                wxModel.setTrend(0).setGood(-1).setParent(Parent_2);
                break;
            case "明教教主":
                wxModel.setTrend(1).setGood(-1).setParent(Parent_2);
                break;
            case "南苑大王":
                wxModel.setTrend(1).setGood(0).setParent(Parent_2);
                break;
            case "丐帮帮主":
                wxModel.setTrend(0).setGood(1).setParent(Parent_2);
                break;
            case "白陀山主":
                wxModel.setTrend(1).setGood(1).setParent(Parent_2);
                break;
            case "少林三僧":
                wxModel.setTrend(99).setGood(99).setParent(Parent_2);
                break;
            case "不可不戒":
                wxModel.setTrend(-1).setGood(0).setParent(Parent_3);
                break;
            case "长春首徒":
                wxModel.setTrend(-1).setGood(1).setParent(Parent_3);
                break;
            case "邵敏郡主":
                wxModel.setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case "无恶不作":
                wxModel.setTrend(0).setGood(-1).setParent(Parent_3);
                break;
            case "小东邪":
                wxModel.setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case "君子剑":
                wxModel.setTrend(-1).setGood(-1).setParent(Parent_3);
                break;
            case "龙姑娘":
                wxModel.setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case "林家公子":
                wxModel.setTrend(-1).setGood(-1).setParent(Parent_3);
                break;
            case "金刀驸马":
                wxModel.setTrend(1).setGood(1).setParent(Parent_3);
                break;
            case "蓉儿":
                wxModel.setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case "神雕大侠":
                wxModel.setTrend(-1).setGood(1).setParent(Parent_3);
                break;
            case "九剑传人":
                wxModel.setTrend(99).setGood(99).setParent(Parent_3);
                break;
            case "剑圣":
                wxModel.setTrend(99).setGood(99).setParent(Parent_3);
                break;
            case "玉面孟尝":
                wxModel.setTrend(0).setGood(-1).setParent(Parent_4);
                break;
            case "婉儿":
                wxModel.setTrend(0).setGood(1).setParent(Parent_4);
                break;
            case "穷凶极恶":
                wxModel.setTrend(0).setGood(-1).setParent(Parent_4);
                break;
            case "余观主":
                wxModel.setTrend(0).setGood(-1).setParent(Parent_4);
                break;
            case "蝠王":
                wxModel.setTrend(-1).setGood(0).setParent(Parent_4);
                break;
            case "鹰王":
                wxModel.setTrend(1).setGood(0).setParent(Parent_4);
                break;
            case "阿紫":
                wxModel.setTrend(-1).setGood(0).setParent(Parent_4);
                break;
            case "铜尸":
                wxModel.setTrend(1).setGood(-1).setParent(Parent_4);
                break;
            case "铁尸":
                wxModel.setTrend(1).setGood(-1).setParent(Parent_4);
                break;
            case "金轮国师":
                wxModel.setTrend(0).setGood(0).setParent(Parent_4);
                break;
            case "峨眉掌门":
                wxModel.setTrend(0).setGood(-1).setParent(Parent_4);
                break;
            case "东方姑娘":
                wxModel.setTrend(-1).setGood(0).setParent(Parent_4);
                break;
            case "聪辩先生":
                wxModel.setTrend(99).setGood(99).setParent(Parent_4);
                break;
            case "白驼山少主":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "灵儿":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "波斯圣女":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "恶贯满盈":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "玄冥二老":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "神仙姐姐":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "魔教圣女":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "龙王":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "星宿老仙":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "扫地僧":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "大理世子":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                wxModel.getSjModels().add(new SjModel("教训猴子，出手当然收不住", "你不是那只瘸腿猴的同伙？", "加当前气血", "加当前气血", 0, -1, 0, 0));
                break;
            case "魔教教主":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "大理皇帝":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "东海岛主":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case "武当掌门":
                wxModel.setTrend(99).setGood(99).setParent(Parent_5);
                break;
            default:
                break;
        }
        return wxModel;
    }

}
