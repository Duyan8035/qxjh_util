package com.dy.qxjhutil.constant;

import android.content.Context;

import com.dy.qxjhutil.R;
import com.dy.qxjhutil.model.SjModel;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;

import io.realm.Realm;

import static com.dy.qxjhutil.constant.NameModel.Parent_1;
import static com.dy.qxjhutil.constant.NameModel.Parent_2;
import static com.dy.qxjhutil.constant.NameModel.Parent_3;
import static com.dy.qxjhutil.constant.NameModel.Parent_4;
import static com.dy.qxjhutil.constant.NameModel.Parent_5;

/**
 * Created by Dy on 2019/4/18 22
 *
 * @author Dy
 */
public class WxDefaultUtil {
    public void initData(final Context mContext) {
        Realm.init(mContext);
        RealmHelper.getInstance(mContext).executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (int i = 0; i < NameModel.stringList.length; i++) {
                    realm.copyToRealmOrUpdate(getModel(realm, NameModel.stringList[i]));
                }
            }
        });
        new KfDefaultUtil().initData(mContext);
        new MapDefaultUtil().initData(mContext);
        new HxDefaultUtil().initData(mContext);
    }


    private WXModel getModel(Realm mRealm, String userName) {
        WXModel wxModel = new WXModel();
        wxModel.setName_game(userName);
        switch (userName) {
            //type0
            case NameModel.Name_liangxiaowucai:
                wxModel.setName(NameModel.Name_liangxiaowucai_value).setIcon_mini(R.drawable.icon_wx_mini_liangxiaowucai).setIndex("L").setTrend(0).setGood(0).setParent(Parent_1)
                        .setIcon(R.drawable.icon_liangxiaowucai);
                break;
            case NameModel.Name_qingmeizhuma:
                wxModel.setName(NameModel.Name_qingmeizhuma_value).setIcon_mini(R.drawable.icon_wx_mini_qingmeizhuma).setIndex("Q").setTrend(0).setGood(0).setParent(Parent_1)
                        .setIcon(R.drawable.icon_qingmeizhuma);
                ;
                break;
            //type1
            case NameModel.Name_xiongshenesha:
                wxModel.setName(NameModel.Name_xiongshenesha_value).setIcon_mini(R.drawable.icon_wx_mini_xiognshenesha).setIndex("X").setTrend(0).setGood(-1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_xiongshenesha);
                break;
            case NameModel.Name_jinguoxiaowangye:
                wxModel.setName(NameModel.Name_jinguoxiaowangye_value).setIcon_mini(R.drawable.icon_wx_mini_jinguoxiaowangye).setIndex("J").setTrend(0).setGood(-1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_jinguoxiaowangzi);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守序倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("你只爱你自己", "防+1 食-2", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("当日你若放弃", "食+2", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("能与小王爷结交", "获得装备", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("承蒙抬举", "", 0, 1));
                wxModel.setMap3dm(true);
                break;
            case NameModel.Name_feitianbianfu:
                wxModel.setName(NameModel.Name_feitianbianfu_value).setIcon_mini(R.drawable.icon_wx_mini_feitianbianfu).setIndex("F").setTrend(-1).setGood(1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_feitianbianfu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守序倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("久闻大名", "食物+3", 0, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("千金一诺", "铜钱+30", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("不言世俗", "防御-1 金钱+60", -1, 0));
                wxModel.setMap2hs(true);
                wxModel.setMap3dm(true);
                break;
            case NameModel.Name_shiwang:
                wxModel.setName(NameModel.Name_shiwang_value).setIcon_mini(R.drawable.icon_wx_mini_shiwang).setIndex("S").setTrend(-1).setGood(0).setParent(Parent_2)
                        .setIcon(R.drawable.icon_shiwang);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("这其中怕是有什么误会", "气血上限+30，食物-2", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("前辈认错人了，在下可不认识你的孩儿", "当前气血+115", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("图书馆", "变化一张卡牌", 0, 0));
                wxModel.setMap5bhd(true);
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_yanziwuzhu:
                wxModel.setName(NameModel.Name_yanziwuzhu_value).setIcon_mini(R.drawable.icon_wx_mini_yanziwuzhu).setIndex("Y").setTrend(1).setGood(-1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_yanziwuzhu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("邪恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("公子志向之远大，胸怀之宽广，佩服", "升级武学", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("表里不一，不择手段，真当旁人不知？", "遗忘武学", 0, 1));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("善良倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("真的疯了", "减当前气血  防御+1", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("可怜之人必有可恨之处", "铜钱-50  防御+1", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("陛下太客气了", "", 0, -1));
                wxModel.setMap1sl(true);
                break;
            case NameModel.Name_dalunmingwang:
                wxModel.setName(NameModel.Name_dalunmingwang_value).setIcon_mini(R.drawable.icon_wx_mini_dalunmingwang).setIndex("D").setTrend(1).setGood(-1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_dalunmingwang);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("善守倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("竟能模仿武学到如此底部", "减当前气血  复制一张卡", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("不必了，这道家武学鱼目混珠，混淆是非，不学也罢", "获得武学：鱼人", 1, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("成王败寇", "罗汉笠", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("为一己之私", "罗汉珠", 0, 1));
                wxModel.setMap1sl(true);
                break;
            case NameModel.Name_miejuedaogu:
                wxModel.setName(NameModel.Name_miejuedaogu_value).setIcon_mini(R.drawable.icon_wx_mini_miejuedaogu).setIndex("M").setTrend(-1).setGood(0).setParent(Parent_2)
                        .setIcon(R.drawable.icon_miejuedaogu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("善良倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("请前辈指教", "果然是", "升级装备", 0, -1,
                                "要是比剑法我早就输了", "食物+3", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("（抱拳）打扰了", "食物+1", 0, 1));
                wxModel.setMap4gm(true);
                wxModel.setMap5bhd(true);
                break;
            case NameModel.Name_lingjiugongzhu:
                wxModel.setName(NameModel.Name_lingjiugongzhu_value).setIcon_mini(R.drawable.icon_wx_mini_lingjiugongzhu).setIndex("L").setTrend(0).setGood(1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_linjiugognzhu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("善守倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("试试醉酒", "食物+3", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("是西夏的那场梦么？ —— 去找她吧 ", "获得装备", 0, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("邪恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("不知是哪个心术正的和尚以生死符降服的老仙", "减当前气血  加气血上限", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("你的善是善，“邪魔外道”对我的善也是善", "铜钱-50  加气血上限", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("道不同不相为谋", "", 0, 0));
                wxModel.setMap1sl(true);
                break;
            case NameModel.Name_taijichanren:
                wxModel.setName(NameModel.Name_mingjiaojiaozhu_value).setIcon_mini(R.drawable.icon_wx_mini_mingjiaojiaozhu).setIndex("M").setTrend(1).setGood(1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_mingjiaojiaozhu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("在下这就去拜会武当掌门", "食物+3", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("三月初六曾见过掌门，多谢教主好意", "铜钱+30", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("请教一二", "看看风景", "", 1, 0,
                                "被在下拒绝了。", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("三月初六有幸拜入掌门门下", "纯阳无极功残章*20", -1, 0));
                wxModel.setMap5bhd(true);
                break;
            case NameModel.Name_nanyuandawang:
                wxModel.setName(NameModel.Name_nanyuandawang_value).setIcon_mini(R.drawable.icon_wx_mini_nanyuandawang).setIndex("N").setTrend(1).setGood(1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_nanyuandawang);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混乱倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("侠之大者，必然为国为民", "铜钱-50  选择卡牌，给与固有", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("既已结为兄弟，必当生死与共", "减当前气血  选择卡牌，给与共鸣", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("两不想帮，淡然以对", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守序倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("赠与酒肉", "食物-5  攻击+2", 0, 2));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("赠与馒头", "食物-3  攻击+1", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("囊中羞涩", "", 0, 0));
                wxModel.setMap1sl(true);
                break;
            case NameModel.Name_gaibangbangzhu:
                wxModel.setName(NameModel.Name_gaibangbangzhu_value).setIcon_mini(R.drawable.icon_wx_mini_gaibangbangzhu).setIndex("G").setTrend(0).setGood(1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_gaibangbagnzhu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守序倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("净衣人士", "气血上限", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("热爱美食", "所以丐帮终将不再是丐帮", "攻击+2", -1, 0,
                                "污衣派做下一任帮主也只是摆设", "无", 1, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混乱倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("上前讨要", "食物+2", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("抢过来", "战斗 食物+3", -1, 0));
                wxModel.setMap2hs(true);
                wxModel.setMap4gm(true);
                break;
            case NameModel.Name_baituoshanzhu:
                wxModel.setName(NameModel.Name_baituoshanzhu_value).setIcon_mini(R.drawable.icon_wx_mini_baituoshanzhu).setIndex("B").setTrend(1).setGood(-1).setParent(Parent_2)
                        .setIcon(R.drawable.icon_baituoshanzhu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("善良倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("顺流而下", "攻击+1", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("听说仙人可以签下契约", "多言了，仙人莫怪", "攻击+2", 0, -1,
                                "仙山神兽那是敬你！真当你是仙人", "", 0, 1));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("邪恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("原来近日毒", "防御+1", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)

                        .setType1("就这么定了", "防御+2中毒", 0, -1));
                wxModel.setMap2hs(true);
                wxModel.setMap4gm(true);
                break;
            case NameModel.Name_shaolinsanseng:
                wxModel.setName(NameModel.Name_shaolinsanseng_value).setIcon_mini(R.drawable.icon_wx_mini_shaolinsanseng)
                        .setIndex("S").setTrend(0).setGood(0).setParent(Parent_2);
                break;

            //type2
            case NameModel.Name_bukebujie:
                wxModel.setName(NameModel.Name_bukebujie_value).setIcon_mini(R.drawable.icon_wx_mini_bukebujie).setIndex("B").setTrend(-1).setGood(0).setParent(Parent_3)
                        .setIcon(R.drawable.icon_bukebujie);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("大师不必解释，在下明白", "升级武学", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("大师莫生气，有损修行", "发现武学", -1, 0));
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_changchunshoutu:
                wxModel.setName(NameModel.Name_changchunshoutu_value).setIcon_mini(R.drawable.icon_wx_mini_quanzhenshoutu).setIndex("C").setTrend(-1).setGood(1).setParent(Parent_3)
                        .setIcon(R.drawable.icon_changchunshoutu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("中立倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("果然惟妙惟肖，栩栩如生", "防御+1", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("到底是将木偶做得像人，还是将人炼做了木偶", "防御+1，负面卡牌（虚弱", -1, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("邪恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("这机关邪术竟然如此丧尽天良", "升级装备", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("只怕你的心也成齿轮做的了吧", "防御+1", 0, 0));
                wxModel.setMap4gm(true);
                break;
            case NameModel.Name_shaominjunzhu:
                wxModel.setName(NameModel.Name_shaominjunzhu_value).setIcon_mini(R.drawable.icon_wx_mini_zhaomingjunzhu).setIndex("S").setTrend(0).setGood(0).setParent(Parent_3)
                        .setIcon(R.drawable.icon_zhaomingjunzhu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("果然越漂亮的女人，越会骗人", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("什么柳山庄，听说他在等一个人", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("既然郡主信守承诺,那就告辞了", "下场战斗：疯狂2", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("郡主是护着我，还是护着这些元兵？", "攻击+1", 0, -1));
                wxModel.setMap5bhd(true);
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_wuebuzuo:
                wxModel.setName(NameModel.Name_wuebuzuo_value).setIcon_mini(R.drawable.icon_wx_mini_wuebuzuo).setIndex("W").setTrend(0).setGood(-1).setParent(Parent_3)
                        .setIcon(R.drawable.icon_wuebuzuo);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("守善——好看", "食物+3", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("这个娃娃是假的", "请指教", "战斗，获得装备", 0, 0,
                                "不敢不敢，是我多言了", "食物+2", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("守中立——娃娃是假的，你也是假的··\t\n", "能做选择的，就一定是真的\n", "遗忘武学\n", -1, 0,
                                "在这里的我也是，在这外面···我不知道\n", "获得武学：鹤", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("我知道女人在这里并不好过", "下场战斗开始时：抽2张牌", 1, 0));
                wxModel.setMap1sl(true);
                wxModel.setMap2hs(true);
                break;
            case NameModel.Name_xiaodongxie:
                wxModel.setName(NameModel.Name_xiaodongxie_value).setIcon_mini(R.drawable.icon_wx_mini_xiaodongxie).setIndex("X").setTrend(0).setGood(0).setParent(Parent_3)
                        .setIcon(R.drawable.icon_xiaodongxie);

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混乱倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("入吾室者，但有清风；对吾饮者，唯当明月。", "攻击+1", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("我本将心向明月，奈何明月照沟渠。", "防御+1", 0, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守序倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("路过花鸟房，不小心带上的吧", "升级武学", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("是何人，认得这羽毛？", "抱歉，这是路过花鸟房不小心带上的", "升级武学", 1, 0,
                                "城北清风楼", "复制一张卡", 1, 0));
                wxModel.setMap3dm(true);
                wxModel.setMap4gm(true);
                break;
            case NameModel.Name_junzijian:
                wxModel.setName(NameModel.Name_junzijian_value).setIcon_mini(R.drawable.icon_wx_mini_junzijian).setIndex("J").setTrend(-1).setGood(-1).setParent(Parent_3)
                        .setIcon(R.drawable.icon_junzijian);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("九剑可绝非旁门左道", "遗忘武学", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("当然比不上掌门的无极神功", "升级武学", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("切磋一二，掌门不必惊慌", "怒气+1", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("当然是想要掌门的剑法秘籍", "气血上限+32", -1, 0));
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_longguniang:
                wxModel.setName(NameModel.Name_longguniang_value).setIcon_mini(R.drawable.icon_wx_mini_longguniang).setIndex("L").setTrend(0).setGood(0).setParent(Parent_3)
                        .setIcon(R.drawable.icon_longguniang);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("邪恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("城南明月楼", "太虚道袍", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("在下不知情", "三生袈裟", 0, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混乱倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("抱歉，只是我的一位大哥在寻找一位龙族姑娘", "落英套", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("龙角珍贵", "铜钱+100", 0, 1));
                wxModel.setMap3dm(true);
                wxModel.setMap4gm(true);
                break;
            case NameModel.Name_linjiagongzi:
                wxModel.setName(NameModel.Name_linjiagongzi_value).setIcon_mini(R.drawable.icon_wx_mini_linjiagongzi).setIndex("L").setTrend(-1).setGood(-1).setParent(Parent_3)
                        .setIcon(R.drawable.icon_linjiagongzi);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("你觉得该，就该", "攻击+1", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("这世上也许唯有这个伪君子的女儿，是真心待", "防御+1", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("知道就交出来", "食物+5", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("误会，我不使剑", "", 0, 0));
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_jindaofuma:
                wxModel.setName(NameModel.Name_jindaofuma_value).setIcon_mini(R.drawable.icon_wx_mini_jindaofuma).setIndex("J").setTrend(1).setGood(1).setParent(Parent_3)
                        .setIcon(R.drawable.icon_jindaofuma);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守善倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("男儿守家卫国", "防御+1", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("你家在哪里 —— 侠之大者", "攻击+1", -1, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("无关正邪", "怒气-2 高级武学", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("正邪都是由胜利者制定", "发现武学", 0, -1));
                wxModel.setMap3dm(true);
                break;
            case NameModel.Name_donghaixianzi:
                wxModel.setName(NameModel.Name_ronger_value).setIcon_mini(R.drawable.icon_wx_mini_ronger).setIndex("R").setTrend(0).setGood(0).setParent(Parent_3)
                        .setIcon(R.drawable.icon_ronger);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("中立倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("赌博", "根据赌局铜钱变化", 0, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("善良倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("乌合之众", "选择卡牌伤害翻倍 防御-1", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("也许他早已看穿", "给与透支 怒气-1", 0, 1));
                wxModel.setMap3dm(true);
                break;
            case NameModel.Name_shendiaodaxia:
                wxModel.setName(NameModel.Name_shendiaodaxia_value).setIcon_mini(R.drawable.icon_wx_mini_shendiaodaxia).setIndex("S").setTrend(-1).setGood(1).setParent(Parent_3)
                        .setIcon(R.drawable.icon_shendiaodaxia);

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("中立倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("大侠不该让他们私奔", "也许你是对的", "升级武学", 0, 1,
                                "我只知道他们父母伤心欲绝", "选择卡", 1, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混乱倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("久闻大名", "变化", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("大侠鸟不知何价格", "食物+3", -1, 0));
                wxModel.setMap4gm(true);
                break;
            case NameModel.Name_jiujianchuanren:
                wxModel.setName(NameModel.Name_jiujianchuanren_value).setIcon_mini(R.drawable.icon_wx_mini_jiujianchuanren)
                        .setIndex("J").setTrend(-1).setGood(1).setParent(Parent_3)
                        .setIcon(R.drawable.icon_jiujianchuanren);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("剑法共九式，施展到第九式敌人必死无疑", "复制一张牌", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("剑法共九式，分别对应九种兵器", "复制一张牌", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("以你跟她的交情，或许应该是我助你", "气血上限+19", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("大小姐菩萨心肠，却还是太天真了", "当前气血+93", 1, 0));
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_jiansheng:
                wxModel.setName(NameModel.Name_jiansheng_value).setIcon_mini(R.drawable.icon_wx_mini_jiansheng)
                        .setIndex("J").setTrend(0).setGood(0).setParent(Parent_3);
                break;

            case NameModel.Name_zuoshi:
                wxModel.setName(NameModel.Name_zuoshi_value).setIcon_mini(R.drawable.icon_wx_mini_jiansheng)
                        .setIndex("Z").setTrend(0).setGood(1).setParent(Parent_3);
                break;

            //type3
            case NameModel.Name_yumianmengchang:
                wxModel.setName(NameModel.Name_yumianmengchang_value).setIcon_mini(R.drawable.icon_wx_mini_yumianmegnchang).setIndex("Y").setTrend(0).setGood(-1).setParent(Parent_4)
                        .setIcon(R.drawable.icon_yumianmengchang);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("你觉得呢…错了就是错了，悔过也为时已晚", "铜钱+50", 0, 0));
                wxModel.setMap4gm(true);
                break;
            case NameModel.Name_waner:
                wxModel.setName(NameModel.Name_waner_value).setIcon_mini(R.drawable.icon_wx_mini_waner).setIndex("W").setTrend(0).setGood(1).setParent(Parent_4)
                        .setIcon(R.drawable.icon_waner);
                break;
            case NameModel.Name_qiongxiongjie:
                wxModel.setName(NameModel.Name_qiongxiongjie_value).setIcon_mini(R.drawable.icon_wx_mini_qiongxiongjie).setIndex("Q").setTrend(0).setGood(-1).setParent(Parent_4)
                        .setIcon(R.drawable.icon_qiongxiongjie);
                break;
            case NameModel.Name_yuguanzhu:
                wxModel.setName(NameModel.Name_yuguanzhu_value).setIcon_mini(R.drawable.icon_wx_mini_yuguanzhu).setIndex("Y").setTrend(0).setGood(-1).setParent(Parent_4)
                        .setIcon(R.drawable.icon_yuguanzhu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("替天行道", "发现高级武学", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("交个朋友", "食物+2", 0, -1));
//                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
//                        .setType1("夜谈嵩山", "变化武学", 0, 0));
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_fuwang:
                wxModel.setName(NameModel.Name_fuwang_value).setIcon_mini(R.drawable.icon_wx_mini_fuwang).setIndex("F").setTrend(-1).setGood(0).setParent(Parent_4)
                        .setIcon(R.drawable.icon_fuwang);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("让幅王吸自己的血", "当前气血-96，发现高级武学", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("寻找其他血源", "发现武学", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("此人失血过多,在吸下去就没命了!", "当前气血+79", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("前辈寒毒复发,快随我上光明顶", "铜钱+30", 1, 0));
                wxModel.setMap5bhd(true);
                break;
            case NameModel.Name_yingwang:
                wxModel.setName(NameModel.Name_yingwang_value).setIcon_mini(R.drawable.icon_wx_mini_yingwang).setIndex("Y").setTrend(1).setGood(0).setParent(Parent_4)
                        .setIcon(R.drawable.icon_yingwang);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("在下是明教教主的朋友，来请前辈", "下场战斗冷血+2", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("前辈的问题过于高深。。", "选择卡牌给予循环", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("还请前辈指教", "防御+1", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("既然如此,就不强求前辈了", "食物+2", 0, 0));
//                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
//                        .setType1("久仰大名", "", 0, 0));
                wxModel.setMap5bhd(true);
                break;
            case NameModel.Name_azi:
                wxModel.setName(NameModel.Name_azi_value).setIcon_mini(R.drawable.icon_wx_mini_azi).setIndex("A").setTrend(-1).setGood(0).setParent(Parent_4)
                        .setIcon(R.drawable.icon_azi);
                break;
            case NameModel.Name_tongshi:
                wxModel.setName(NameModel.Name_tongshi_value).setIcon_mini(R.drawable.icon_wx_mini_tongshi).setIndex("T").setTrend(1).setGood(-1).setParent(Parent_4)
                        .setIcon(R.drawable.icon_tongshi);
                // TODO: 2019/4/21  youzhengyi
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("这道家宝贝在你手里", "尘缘笠", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("难怪智远和尚满天下的追你", "尘缘念珠", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("请指教", "获得装备", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("都是误会，还给他", "变化", 0, -1));
                wxModel.setMap2hs(true);
                wxModel.setMap3dm(true);
                break;
            case NameModel.Name_tieshi:
                wxModel.setName(NameModel.Name_tieshi_value).setIcon_mini(R.drawable.icon_wx_mini_tieshi).setIndex("T").setTrend(1).setGood(-1).setParent(Parent_4)
                        .setIcon(R.drawable.icon_tieshi);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("善良倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("是我又如何", "冷血", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("待我打败你", "闪避", 0, 1));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("交出秘籍", "变化", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("久闻大名", "食物+1", 0, -1));
                wxModel.setMap2hs(true);
                wxModel.setMap3dm(true);
                break;
            case NameModel.Name_jinlunguoshi:
                wxModel.setName(NameModel.Name_jinlunguoshi_value).setIcon_mini(R.drawable.icon_wx_mini_jinlunguoshi).setIndex("J")
                        .setTrend(1).setGood(-1).setParent(Parent_4)
                        .setIcon(R.drawable.icon_jinlunguoshi);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("受徒儿一拜", "选择卡牌，给予虹吸", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("正邪不两立，不必多言", "选择卡牌，给予破甲", 0, 1));
                wxModel.setMap4gm(true);
                break;
            case NameModel.Name_emeizhangmen:
                wxModel.setName(NameModel.Name_emeizhangmen_value).setIcon_mini(R.drawable.icon_wx_mini_emeizhangmei).setIndex("E").setTrend(0).setGood(-1).setParent(Parent_4)
                        .setIcon(R.drawable.icon_emeizhangmen);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("姑娘远不如他。。", "攻击+1", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("各有强处，难以比较", "防御+1", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("姑娘明白人，这天下又与我何干", "", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("姑娘说笑了，今朝廷昏庸，我辈自然站出来，为民请命", "", 0, 1));
                wxModel.setMap5bhd(true);
                break;
            case NameModel.Name_dongfangguniang:
                wxModel.setName(NameModel.Name_dongfangguniang_value).setIcon_mini(R.drawable.icon_wx_mini_dongfangguniang).setIndex("D").setTrend(-1).setGood(0).setParent(Parent_4)
                        .setIcon(R.drawable.icon_dongfagnguniang);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("只为困你半个时辰，等教主来", "选择卡牌给予虹吸", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("只为困你半个时辰，避开教主", "选择卡牌给予破甲", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("留下助你", "防御+1", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("姑娘保重", "攻击+1", 1, 0));
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_congbianxiansheng:
                wxModel.setName(NameModel.Name_congbianxiansheng_value)
                        .setIcon_mini(R.drawable.icon_wx_mini_congbianxiansheng).setIndex("C").setTrend(0).setGood(0).setParent(Parent_4);
                break;
            case NameModel.Name_tonglao:
                wxModel.setName(NameModel.Name_tonglao_value)
                        .setIcon_mini(R.drawable.icon_wx_mini_congbianxiansheng).setIndex("T").setTrend(0).setGood(0).setParent(Parent_4);
                break;

            //type4
            case NameModel.Name_baituoshanshaozhu:
                wxModel.setName(NameModel.Name_baituoshanshaozhu_value).setIcon_mini(R.drawable.icon_wx_mini_baituoshanshaozhu).setIndex("B").setTrend(0).setGood(-1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_baituoshanshaozhu);

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("善守倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("多谢，待我试试这药的威力", "铜钱-40 食物+8", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("不必了", "多谢试试威力", "铜钱-20 食物+4", 0, -2,
                                "多谢", "食物+1", 0, -2));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("不必了，不借助外力", "", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("若不是提前出手", "下场战斗护甲+20", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("仙山下来的人物", "下场战斗手牌怒气-1", -1, 0));
                wxModel.setMap3dm(true);
                break;
            case NameModel.Name_linger:
                wxModel.setName(NameModel.Name_linger_value).setIcon_mini(R.drawable.icon_wx_mini_linger).setIndex("L").setTrend(0).setGood(1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_linger);

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混乱倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("咬了人还这么凶，在下妄人，专杀妄貂！", "铜钱-30  攻击+1", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("姑娘误会了，是我袋里的包子太香", "食物-2  攻击+1", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("仓皇而逃", "", 0, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守序倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("小貂是什么？", "抱歉，我没有见到", "发现武学", 1, 0,
                                "（随口胡说）前面右转的第二个岔道上，再左转的第三个岔道", "食物+2", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("（随口胡说）前面右转的第二个岔道上", "食物+3", -1, 0));
                wxModel.setMap1sl(true);
                wxModel.setMap3dm(true);
                break;
            case NameModel.Name_bosishengnü:
                wxModel.setName(NameModel.Name_bosishengnü_value).setIcon_mini(R.drawable.icon_wx_mini_bosishengnv).setIndex("B").setTrend(1).setGood(1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_bosishengnv);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("听说倚天屠龙削铁如泥，肯定是可以的", "选择卡片给予虹吸", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("这脚镣与倚天剑同为玄铁制作，恐怕", "选择卡牌给予破甲", -1, 0));
                // TODO: 2019/4/21 zhengyi
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("抱歉，我确实出手伤了他", "下场战斗灼烧+10", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("她亲手给我的，你不必怀疑", "下场战斗冰冻+10", 0, -1));
                wxModel.setMap5bhd(true);
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_eguanmanying:
                wxModel.setName(NameModel.Name_eguanmanying_value).setIcon_mini(R.drawable.icon_wx_mini_eguanmanying).setIndex("E").setTrend(-1).setGood(-1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_eguanmanying);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("守善倾向",
                                "手下败将", "升级装备", 0, 0,
                                "随时奉陪", "加当前气血", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("中立善倾向",
                                "他放过一把火，烧了神铸山庄", "减气血上限，怒气+1", 0, -1,
                                "（随口胡说）他给我打的剑轻了半两", "发现武学", -1, 0));
                wxModel.setMap1sl(true);
                break;
            case NameModel.Name_xuanmingerlao:
                wxModel.setName(NameModel.Name_xuanmingerlao_value).setIcon_mini(R.drawable.icon_wx_mini_xuanmingerlao).setIndex("X").setTrend(0).setGood(-1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_xuanmingerlao);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("有原则,烦请向王爷引荐一下", "攻击+1", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("二位果然是趋炎附势之人", "防御+1", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("开打 手下败将", "怒气+1", 0, 0));
                wxModel.setMap5bhd(true);
                break;
            case NameModel.Name_shenxianjiejie:
                wxModel.setName(NameModel.Name_shenxianjiejie_value).setIcon_mini(R.drawable.icon_wx_mini_shenxianjiejie).setIndex("S").setTrend(0).setGood(0).setParent(Parent_5)
                        .setIcon(R.drawable.icon_shenxianjiejie);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("遇到他后定会相告，只怕···", "铜钱+50", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("段公子已登基，还是不打扰他吧", "卡牌:内伤 铜钱+100", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("姑娘，你的书", "铜钱+100", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("拾起离开", "发现高级武学", 0, -1));
                wxModel.setMap1sl(true);
                break;
            case NameModel.Name_mojiaoshengnü:
                wxModel.setName(NameModel.Name_mojiaoshengnü_value).setIcon_mini(R.drawable.icon_wx_mini_mojiaoshengnv).setIndex("M").setTrend(0).setGood(0).setParent(Parent_5)
                        .setIcon(R.drawable.icon_mojiaoshengnv);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("一路走来，见了不少，学了不少", "变化武学", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("在下师承南海神尼，师傅武学涉猎甚广", "发现武学", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("这件事恐不是我一个人能控制的", "", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("魔教祸乱武林，皆因此人，保不得", "", 1, 0));
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_longwang:
                wxModel.setName(NameModel.Name_longwang_value).setIcon_mini(R.drawable.icon_wx_mini_longwang).setIndex("L").setTrend(-1).setGood(0).setParent(Parent_5)
                        .setIcon(R.drawable.icon_longwang);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("不曾见过", "食物+2", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("倒是有位戴着脚镣的姑娘，但是并不丑", "当前气血+71", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("听闻婆婆对明教了如指掌,特来请教", "快步跟上", "铜钱+30", 0, 1,
                                "背后偷袭", "怒气+1", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("交出光明顶米导图，你还能活", "怒气+1", 0, -1));

                wxModel.setMap5bhd(true);
                break;
            case NameModel.Name_xingxiulaoxian:
                wxModel.setName(NameModel.Name_xingxiulaoxian_value).setIcon_mini(R.drawable.icon_wx_mini_xingxiulaoxian).setIndex("X").setTrend(-1).setGood(-1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_xinxiulaoxian);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混乱倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("受徒儿一拜", "遗忘武学", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("正邪不两立，不必多言", "加气血上限", 0, 1));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("善良倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("中毒离开", "减当前气血  铜钱+60", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("投降以解毒", "食物+2", -1, 0));
                wxModel.setMap1sl(true);
                wxModel.setMap2hs(true);
                break;
            case NameModel.Name_saodiseng:
                wxModel.setName(NameModel.Name_saodiseng_value).setIcon_mini(R.drawable.icon_wx_mini_saodiseng).setIndex("S").setTrend(0).setGood(0).setParent(Parent_5);
                break;
            case NameModel.Name_dalishizi:
                wxModel.setName(NameModel.Name_dalishizi_value).setIcon_mini(R.drawable.icon_wx_mini_dalishizi).setIndex("D").setTrend(0).setGood(1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_dalishizi);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("邪恶倾向", "教训猴子，出手当然收不住", "加当前气血", 0, -1,
                                "你不是那只瘸腿猴的同伙", "减当前气血 升级武学", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType2("善良倾向", "慕容的努力，你无法想象。", "抽2张牌", 0, -1,
                                "珍惜眼前人罢！", "获得2攻击", 0, 1));
                wxModel.setMap1sl(true);
                break;
            case NameModel.Name_mojiaojiaozhu:
                wxModel.setName(NameModel.Name_mojiaojiaozhu_value).setIcon_mini(R.drawable.icon_wx_mini_mojiaojiaozhu).setIndex("M").setTrend(0).setGood(-1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_mojiaojiaozhu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("毕竟是魔教，阁下不必多言", "下场战斗抽2张牌", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("如此甚好，教主寿与。。", "下场战斗+冷血2", 0, -1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("那恐怕还是杀了她更好", "获得装备", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("以其人之道治其人之身，教主英明", "升级装备", 0, -1));
                wxModel.setMap6zl(true);
                break;
            case NameModel.Name_dalihuangdi:
                wxModel.setName(NameModel.Name_dalihuangdi_value).setIcon_mini(R.drawable.icon_wx_mini_dalihuangdi).setIndex("D").setTrend(0).setGood(1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_dalihuangdi);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守善倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("多谢大师成全", "食物-5 加血", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("竟然要损失十年功力！万万不可", "食物+2", 0, 1));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混恶倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("你可知道一朝被蛇咬.十年怕井绳？", "回复当前气血", 0, 1));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("瘸腿猴，你穿上袈裟我就不认识你了吗？", "升级装备", 0, -1));
                wxModel.setMap2hs(true);
                break;
            case NameModel.Name_donghaidaozhu:
                wxModel.setName(NameModel.Name_donghaidaozhu_value).setIcon_mini(R.drawable.icon_wx_mini_donghaidaozhu).setIndex("D").setTrend(-1).setGood(0).setParent(Parent_5)
                        .setIcon(R.drawable.icon_donghaidaozhu);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守序倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("留下听萧", "遗忘武学", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("转身离开", "加气血", 1, 0));

                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("混乱倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("先生神算，在下佩服", "食物+3", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("2行5列有误，……（战斗）", "发现高级武学", 0, 0));
                wxModel.setMap2hs(true);
                break;
            case NameModel.Name_wudangzhangmen:
                wxModel.setName(NameModel.Name_wudangzhangmen_value).setIcon_mini(R.drawable.icon_wx_mini_wudangzhangmen).setIndex("W").setTrend(0).setGood(1).setParent(Parent_5)
                        .setIcon(R.drawable.icon_wudangzhangmen);
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("守序倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("见过", "无懈可击2", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("不曾见过", "食物+3", -1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class).setType1("中立倾向", "", 0, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("弟子拜见", "加气血", 1, 0));
                wxModel.getSjModels().add(mRealm.createObject(SjModel.class)
                        .setType1("晚辈独行惯了，多谢前辈美意", "获得装备", -1, 0));
                wxModel.setMap4gm(true);
                wxModel.setMap5bhd(true);
                break;
            /**
             * 增加赤练，康夫人
             **/
            case NameModel.Name_chilian:
                wxModel.setName("").setIcon_mini(0).setIndex("C").setTrend(-1).setGood(-1).setParent(Parent_4);
                break;
            case NameModel.Name_kangfuren:
                wxModel.setName("").setIcon_mini(0).setIndex("K").setTrend(0).setGood(-1).setParent(Parent_5);
                break;
            case NameModel.Name_chongyangzhenren:
                wxModel.setName("").setIcon_mini(0).setIndex("C").setTrend(1).setGood(1).setParent(Parent_5);
                break;

            /**
             * 2020年2月19日11:53:47 新增铁掌帮主，铁掌帮王，顽童，右使，云雀，成吉思汗，五毒教主，三藏，琴圣
             **/
            case NameModel.Name_wantong:
                wxModel.setName("老顽童").setIcon_mini(0).setIndex("W").setTrend(-1).setGood(1).setParent(Parent_2);
                break;
            case NameModel.Name_tiezhangbangzhu:
                wxModel.setName("裘千仞").setIcon_mini(0).setIndex("T").setTrend(0).setGood(-1).setParent(Parent_2);
                break;
            case NameModel.Name_tiezhangbangwang:
                wxModel.setName("裘千丈").setIcon_mini(0).setIndex("T").setTrend(-1).setGood(0).setParent(Parent_2);
                break;
            case NameModel.Name_youshi:
                wxModel.setName("范瑶").setIcon_mini(0).setIndex("Y").setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case NameModel.Name_yunque:
                wxModel.setName("").setIcon_mini(0).setIndex("Y").setTrend(0).setGood(0).setParent(Parent_3);
                break;
            case NameModel.Name_chengjisihan:
                wxModel.setName("").setIcon_mini(0).setIndex("C").setTrend(1).setGood(0).setParent(Parent_3);
                break;
            case NameModel.Name_wudujiaozhu:
                wxModel.setName("").setIcon_mini(0).setIndex("W").setTrend(-1).setGood(1).setParent(Parent_4);
                break;
            case NameModel.Name_sanzang:
                wxModel.setName("").setIcon_mini(0).setIndex("S").setTrend(0).setGood(0).setParent(Parent_5);
                break;
            case NameModel.Name_qinsheng:
                wxModel.setName("").setIcon_mini(0).setIndex("Q").setTrend(0).setGood(0).setParent(Parent_5);
                break;
            default:
                break;
        }
        return wxModel;
    }


}
