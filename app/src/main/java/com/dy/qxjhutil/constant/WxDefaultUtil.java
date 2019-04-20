package com.dy.qxjhutil.constant;

import android.content.Context;

import com.dy.qxjhutil.model.KungFuModel;
import com.dy.qxjhutil.model.MapModel;
import com.dy.qxjhutil.model.SjModel;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;

import io.realm.Realm;

/**
 * Created by Dy on 2019/4/18 22
 *
 * @author Dy
 */
public class WxDefaultUtil {
    public void initData(Context mContext) {
        Realm.init(mContext);
        RealmHelper.getInstance(mContext).executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (int i = 0; i < stringList.length; i++) {
                    realm.copyToRealmOrUpdate(getModel(realm, stringList[i]));
                }
                initFu(realm);
                initMap(realm);

            }
        });
    }

    private void initFu(Realm realm) {
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_11)
                .setTrendGood(0, 5)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_lingjiugongzhu).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_12)
                .setTrendGood(4, -4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_dalunmingwang).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_21)
                .setTrendGood(-5, 0)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_donghaidaozhu).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_22)
                .setTrendGood(0, 5)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_dalihuangdi).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_31)
                .setTrendGood(4, 4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_jindaofuma).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_32)
                .setTrendGood(0, 0)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_ronger).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_41)
                .setTrendGood(4, -4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_jinlunguoshi).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_42)
                .setTrendGood(-4, 4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_miejuedaogu).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_51)
                .setTrendGood(4, 4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_mingjiaojiaozhu).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_52)
                .setTrendGood(0, -5)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_emeizhangmen).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_61)
                .setTrendGood(-5, 0)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_dongfangguniang).findFirst())
        );
        realm.copyToRealmOrUpdate(new KungFuModel(MAP_NAME_62)
                .setTrendGood(-4, 4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", Name_jiujianchuanren).findFirst())
        );
    }

    private void initMap(Realm realm) {
        realm.copyToRealmOrUpdate(new MapModel().setMapName(MAP_NAME_1)
                .setValue(MAP_VALUE_1)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_11).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_12).findFirst())
        );

        realm.copyToRealmOrUpdate(new MapModel().setMapName(MAP_NAME_2)
                .setValue(MAP_VALUE_2)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_21).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_22).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel().setMapName(MAP_NAME_3)
                .setValue(MAP_VALUE_3)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_31).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_32).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel().setMapName(MAP_NAME_4)
                .setValue(MAP_VALUE_4)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_41).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_42).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel().setMapName(MAP_NAME_5)
                .setValue(MAP_VALUE_5)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_51).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_52).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel().setMapName(MAP_NAME_6)
                .setValue(MAP_VALUE_6)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_61).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", MAP_NAME_62).findFirst())
        );
    }


    private WXModel getModel(Realm mRealm, String userName) {
        WXModel wxModel = new WXModel();
        wxModel.setName_game(userName);
        switch (userName) {
            //type0
            case Name_liangxiaowucai:
                wxModel.setIndex("L").setTrend(0).setGood(0).setParent(Parent_1);
                break;
            case Name_qingmeizhuma:
                wxModel.setIndex("Q").setTrend(0).setGood(0).setParent(Parent_1);
                break;
            //type1
            case Name_xiongshenesha:
                wxModel.setIndex("X").setTrend(0).setGood(-1).setParent(Parent_2);
                break;
            case Name_jinguoxiaowangye:
                wxModel.setIndex("J").setTrend(0).setGood(-1).setParent(Parent_2);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("你只爱你自己", "防+1 食-2", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("当日你若放弃", "食+2", 0, 0));
                break;
            case Name_feitianbianfu:
                wxModel.setIndex("F").setTrend(-1).setGood(1).setParent(Parent_2);
                break;
            case Name_shiwang:
                wxModel.setIndex("S").setTrend(-1).setGood(0).setParent(Parent_2);
                break;
            case Name_yanziwuzhu:
                wxModel.setIndex("Y").setTrend(1).setGood(-1).setParent(Parent_2);
                break;
            case Name_dalunmingwang:
                wxModel.setIndex("D").setTrend(1).setGood(-1).setParent(Parent_2);
                break;
            case Name_miejuedaogu:
                wxModel.setIndex("M").setTrend(-1).setGood(0).setParent(Parent_2);
                break;
            case Name_lingjiugongzhu:
                wxModel.setIndex("L").setTrend(0).setGood(1).setParent(Parent_2);
                break;
            case Name_mingjiaojiaozhu:
                wxModel.setIndex("M").setTrend(1).setGood(1).setParent(Parent_2);
                break;
            case Name_nanyuandawang:
                wxModel.setIndex("N").setTrend(1).setGood(1).setParent(Parent_2);
                break;
            case Name_gaibangbangzhu:
                wxModel.setIndex("G").setTrend(0).setGood(1).setParent(Parent_2);
                break;
            case Name_baituoshanzhu:
                wxModel.setIndex("B").setTrend(1).setGood(-1).setParent(Parent_2);
                break;
            case Name_shaolinsanseng:
                wxModel.setIndex("S").setTrend(99).setGood(99).setParent(Parent_2);
                break;

            //type2
            case Name_bukebujie:
                wxModel.setIndex("B").setTrend(-1).setGood(0).setParent(Parent_3);
                break;
            case Name_changchunshoutu:
                wxModel.setIndex("C").setTrend(-1).setGood(1).setParent(Parent_3);
                break;
            case Name_shaominjunzhu:
                wxModel.setIndex("S").setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case Name_wuebuzuo:
                wxModel.setIndex("W").setTrend(0).setGood(-1).setParent(Parent_3);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("好看", "食物+3", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("这个娃娃是假的", "请指教", "战斗，获得装备", 0, 0,
                                "不敢不敢，是我多言了", "食物+2", 0, 0));
                break;
            case Name_xiaodongxie:
                wxModel.setIndex("X").setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case Name_junzijian:
                wxModel.setIndex("J").setTrend(-1).setGood(-1).setParent(Parent_3);
                break;
            case Name_longguniang:
                wxModel.setIndex("L").setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case Name_linjiagongzi:
                wxModel.setIndex("L").setTrend(-1).setGood(-1).setParent(Parent_3);
                break;
            case Name_jindaofuma:
                wxModel.setIndex("J").setTrend(1).setGood(1).setParent(Parent_3);
                break;
            case Name_ronger:
                wxModel.setIndex("R").setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case Name_shendiaodaxia:
                wxModel.setIndex("S").setTrend(-1).setGood(1).setParent(Parent_3);
                break;
            case Name_jiujianchuanren:
                wxModel.setIndex("J").setTrend(-1).setGood(1).setParent(Parent_3);
                break;
            case Name_jiansheng:
                wxModel.setIndex("J").setTrend(99).setGood(99).setParent(Parent_3);
                break;

            //type3
            case Name_yumianmengchang:
                wxModel.setIndex("Y").setTrend(0).setGood(-1).setParent(Parent_4);
                break;
            case Name_waner:
                wxModel.setIndex("W").setTrend(0).setGood(1).setParent(Parent_4);
                break;
            case Name_qiongxiongjie:
                wxModel.setIndex("Q").setTrend(0).setGood(-1).setParent(Parent_4);
                break;
            case Name_yuguanzhu:
                wxModel.setIndex("Y").setTrend(0).setGood(-1).setParent(Parent_4);
                break;
            case Name_fuwang:
                wxModel.setIndex("F").setTrend(-1).setGood(0).setParent(Parent_4);
                break;
            case Name_yingwang:
                wxModel.setIndex("Y").setTrend(1).setGood(0).setParent(Parent_4);
                break;
            case Name_azi:
                wxModel.setIndex("A").setTrend(-1).setGood(0).setParent(Parent_4);
                break;
            case Name_tongshi:
                wxModel.setIndex("T").setTrend(1).setGood(-1).setParent(Parent_4);
                break;
            case Name_tieshi:
                wxModel.setIndex("T").setTrend(1).setGood(-1).setParent(Parent_4);
                break;
            case Name_jinlunguoshi:
                wxModel.setIndex("J").setTrend(0).setGood(0).setParent(Parent_4);
                break;
            case Name_emeizhangmen:
                wxModel.setIndex("E").setTrend(0).setGood(-1).setParent(Parent_4);
                break;
            case Name_dongfangguniang:
                wxModel.setIndex("D").setTrend(-1).setGood(0).setParent(Parent_4);
                break;
            case Name_congbianxiansheng:
                wxModel.setIndex("C").setTrend(99).setGood(99).setParent(Parent_4);
                break;

            //type4
            case Name_baituoshanshaozhu:
                wxModel.setIndex("B").setTrend(0).setGood(-1).setParent(Parent_5);
                break;
            case Name_linger:
                wxModel.setIndex("L").setTrend(0).setGood(1).setParent(Parent_5);
                break;
            case Name_bosishengnü:
                wxModel.setIndex("B").setTrend(1).setGood(1).setParent(Parent_5);
                break;
            case Name_eguanmanying:
                wxModel.setIndex("E").setTrend(-1).setGood(-1).setParent(Parent_5);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("手下败将", "升级装备", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("随时奉陪", "加当前气血", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("他放过一把火，烧了神铸山庄", "减气血上限，怒气+1", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("（随口胡说）他给我打的剑轻了半两", "发现武学", -1, 0));
                break;
            case Name_xuanmingerlao:
                wxModel.setIndex("X").setTrend(0).setGood(-1).setParent(Parent_5);
                break;
            case Name_shenxianjiejie:
                wxModel.setIndex("S").setTrend(0).setGood(0).setParent(Parent_5);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("遇到他后定会相告，只怕···", "铜钱+50", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("段公子已登基，还是不打扰他吧", "获得负面卡牌：内伤 铜钱+100", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("姑娘，你的书", "铜钱+100", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("拾起离开", "发现高级武学", 0, -1));
                break;
            case Name_mojiaoshengnü:
                wxModel.setIndex("M").setTrend(0).setGood(0).setParent(Parent_5);
                break;
            case Name_longwang:
                wxModel.setIndex("L").setTrend(-1).setGood(0).setParent(Parent_5);
                break;
            case Name_xingxiulaoxian:
                wxModel.setIndex("X").setTrend(-1).setGood(-1).setParent(Parent_5);
                break;
            case Name_saodiseng:
                wxModel.setIndex("S").setTrend(99).setGood(99).setParent(Parent_5);
                break;
            case Name_dalishizi:
                wxModel.setIndex("D").setTrend(0).setGood(1).setParent(Parent_5);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("教训猴子，出手当然收不住", "加当前气血", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("你不是那只瘸腿猴的同伙？", "减当前气血 升级武学", 0, 0));
                break;
            case Name_mojiaojiaozhu:
                wxModel.setIndex("M").setTrend(0).setGood(-1).setParent(Parent_5);
                break;
            case Name_dalihuangdi:
                wxModel.setIndex("D").setTrend(0).setGood(1).setParent(Parent_5);
                break;
            case Name_donghaidaozhu:
                wxModel.setIndex("D").setTrend(-1).setGood(0).setParent(Parent_5);
                break;
            case Name_wudangzhangmen:
                wxModel.setIndex("W").setTrend(0).setGood(1).setParent(Parent_5);
                break;
            default:
                break;
        }
        return wxModel;
    }


    public static final String MAP_NAME_1 = "少林寺";
    public static final String MAP_NAME_2 = "华山之巅";
    public static final String MAP_NAME_3 = "大漠";
    public static final String MAP_NAME_4 = "古墓";
    public static final String MAP_NAME_5 = "冰火岛";
    public static final String MAP_NAME_6 = "竹林";

    public static final String MAP_NAME_11 = "阴阳符";
    public static final String MAP_NAME_12 = "七伤拳";
    public static final String MAP_NAME_21 = "落花流水";
    public static final String MAP_NAME_22 = "空明拳";
    public static final String MAP_NAME_31 = "双手互搏";
    public static final String MAP_NAME_32 = "兰花指";
    public static final String MAP_NAME_41 = "灭剑-绝剑";
    public static final String MAP_NAME_42 = "软剑无常";
    public static final String MAP_NAME_51 = "纯阳无极功";
    public static final String MAP_NAME_52 = "五毒神掌";
    public static final String MAP_NAME_61 = "为我独尊";
    public static final String MAP_NAME_62 = "易经筋";


    public static final String MAP_VALUE_1 = "无";
    public static final String MAP_VALUE_2 = "冰冻";
    public static final String MAP_VALUE_3 = "燃烧";
    public static final String MAP_VALUE_4 = "失明";
    public static final String MAP_VALUE_5 = "冰冻灼烧加层";
    public static final String MAP_VALUE_6 = "无法放弃拿牌";

    public static final String Parent_1 = "中立";
    public static final String Parent_2 = "豪侠";
    public static final String Parent_3 = "游侠";
    public static final String Parent_4 = "刺客";
    public static final String Parent_5 = "气宗";

    private static final String Name_liangxiaowucai = "两小无猜";
    private static final String Name_qingmeizhuma = "青梅竹马";
    private static final String Name_xiongshenesha = "凶神恶煞";
    private static final String Name_jinguoxiaowangye = "金国小王爷";
    private static final String Name_feitianbianfu = "飞天蝙蝠";
    private static final String Name_shiwang = "狮王";
    private static final String Name_yanziwuzhu = "燕子坞主";
    private static final String Name_dalunmingwang = "大轮明王";
    private static final String Name_miejuedaogu = "灭绝道姑";
    private static final String Name_lingjiugongzhu = "灵鹫宫主";
    private static final String Name_mingjiaojiaozhu = "明教教主";
    private static final String Name_nanyuandawang = "南苑大王";
    private static final String Name_gaibangbangzhu = "丐帮帮主";
    private static final String Name_baituoshanzhu = "白陀山主";
    private static final String Name_shaolinsanseng = "少林三僧";
    private static final String Name_bukebujie = "不可不戒";
    private static final String Name_changchunshoutu = "长春首徒";
    private static final String Name_shaominjunzhu = "邵敏郡主";
    private static final String Name_wuebuzuo = "无恶不作";
    private static final String Name_xiaodongxie = "小东邪";
    private static final String Name_junzijian = "君子剑";
    private static final String Name_longguniang = "龙姑娘";
    private static final String Name_linjiagongzi = "林家公子";
    private static final String Name_jindaofuma = "金刀驸马";
    private static final String Name_ronger = "蓉儿";
    private static final String Name_shendiaodaxia = "神雕大侠";
    private static final String Name_jiujianchuanren = "九剑传人";
    private static final String Name_jiansheng = "剑圣";
    private static final String Name_yumianmengchang = "玉面孟尝";
    private static final String Name_waner = "婉儿";
    private static final String Name_qiongxiongjie = "穷凶极恶";
    private static final String Name_yuguanzhu = "余观主";
    private static final String Name_fuwang = "蝠王";
    private static final String Name_yingwang = "鹰王";
    private static final String Name_azi = "阿紫";
    private static final String Name_tongshi = "铜尸";
    private static final String Name_tieshi = "铁尸";
    private static final String Name_jinlunguoshi = "金轮国师";
    private static final String Name_emeizhangmen = "峨眉掌门";
    private static final String Name_dongfangguniang = "东方姑娘";
    private static final String Name_congbianxiansheng = "聪辩先生";
    private static final String Name_baituoshanshaozhu = "白驼山少主";
    private static final String Name_linger = "灵儿";
    private static final String Name_bosishengnü = "波斯圣女";
    private static final String Name_eguanmanying = "恶贯满盈";
    private static final String Name_xuanmingerlao = "玄冥二老";
    private static final String Name_shenxianjiejie = "神仙姐姐";
    private static final String Name_mojiaoshengnü = "魔教圣女";
    private static final String Name_longwang = "龙王";
    private static final String Name_xingxiulaoxian = "星宿老仙";
    private static final String Name_saodiseng = "扫地僧";
    private static final String Name_dalishizi = "大理世子";
    private static final String Name_mojiaojiaozhu = "魔教教主";
    private static final String Name_dalihuangdi = "大理皇帝";
    private static final String Name_donghaidaozhu = "东海岛主";
    private static final String Name_wudangzhangmen = "武当掌门";

    public static String[] stringList = {
            "两小无猜", "青梅竹马",
            "凶神恶煞", "金国小王爷", "飞天蝙蝠", "狮王", "燕子坞主", "大轮明王", "灭绝道姑", "灵鹫宫主", "明教教主", "南苑大王", "丐帮帮主", "白陀山主", "少林三僧",
            "不可不戒", "长春首徒", "邵敏郡主", "无恶不作", "小东邪", "君子剑", "龙姑娘", "林家公子", "金刀驸马", "蓉儿", "神雕大侠", "九剑传人", "剑圣",
            "玉面孟尝", "婉儿", "穷凶极恶", "余观主", "蝠王", "鹰王", "阿紫", "铜尸", "铁尸", "金轮国师", "峨眉掌门", "东方姑娘", "聪辩先生",
            "白驼山少主", "灵儿", "波斯圣女", "恶贯满盈", "玄冥二老", "神仙姐姐", "魔教圣女", "龙王", "星宿老仙", "扫地僧", "大理世子", "魔教教主", "大理皇帝", "东海岛主", "武当掌门",
    };
}
