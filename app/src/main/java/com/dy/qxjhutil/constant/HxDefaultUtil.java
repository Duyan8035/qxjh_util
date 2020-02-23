package com.dy.qxjhutil.constant;

import android.content.Context;

import com.dy.qxjhutil.model.HxModel;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;

import io.realm.Realm;

/**
 * Created by Dy on 2020/2/19 11
 *
 * @author Dy
 */
public class HxDefaultUtil {
    public void initData(Context mContext) {
        Realm.init(mContext);
        RealmHelper.getInstance(mContext).executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (int i = 0; i < NameModel.stringList.length; i++) {
                    getModel(realm, NameModel.stringList[i]);
                }
            }
        });
    }


    private void getModel(Realm mRealm, String userName) {
//                      "刺棍\n→劈掌",
        switch (userName) {

            // TODO: 2020/2/22 武神
            case NameModel.Name_nanyuandawang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 2, 1,
                        NameModel.HX_ws_tg_武神_天罡,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_tk_武神_天魁,
                        4, 3, 3,
                        "刺棍→劈掌",
                        "初始刺棍变冲拳,自残牌80%吸血",
                        "发现4拳掌牌cd1"
                );
                break;
            case NameModel.Name_lingjiugongzhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 0, 1,
                        NameModel.HX_ws_tg_武神_天罡,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_tk_武神_天魁,
                        4, 3, 3,
                        "铁布衫→少林心法",
                        "回合结束时回25%损血的护甲cd2",
                        "回合开始时每有1敌人回1怒"
                );
                break;
            case NameModel.Name_baituoshanzhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 2, 1, 2,
                        NameModel.HX_ws_tg_武神_天罡,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_tk_武神_天魁,
                        4, 3, 3,
                        "铁布衫→回马枪",
                        "80伤抽4牌,豪侠牌消耗变0,不是豪侠牌回8%血",
                        "单回合受伤超过30%获得冷血1"
                );
                break;
            case NameModel.Name_taijichanren:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 1, 0,
                        NameModel.HX_ws_tg_武神_天罡,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_tk_武神_天魁,
                        4, 3, 3,
                        "刺棍→长拳",
                        "40伤全体眩晕1回合cd2",
                        "对眩晕的敌人增伤20%"
                );
                break;
            case NameModel.Name_shaolinsanseng:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 1, 0,
                        NameModel.HX_ws_tg_武神_天罡,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_tk_武神_天魁,
                        4, 3, 3,
                        "刺棍→劈棍",
                        "无同名牌时抽1牌每回合4次cd2",
                        "回合开始时若无同名牌抽1牌"
                );
                break;
            case NameModel.Name_tiezhangbangzhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 2, 1,
                        NameModel.HX_ws_tg_武神_天罡,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_tk_武神_天魁,
                        4, 3, 3,
                        "铁布衫→少林心法",
                        "连携复制2张初级牌进牌库cd1",
                        "开战时反伤5层数不减"
                );
                break;
            case NameModel.Name_dalunmingwang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 1, 2,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_ty_武神_天勇,
                        NameModel.HX_ws_tx_武神_天闲,
                        3, 2, 2,
                        "刺棍→劈棍",
                        "60伤发现4张0怒耗豪侠牌cd2",
                        "开战时敌全体火攻易伤20%不会减少"
                );
                break;
            case NameModel.Name_shiwang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 0, 1,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_ty_武神_天勇,
                        NameModel.HX_ws_tx_武神_天闲,
                        3, 2, 2,
                        "刺棍→劈棍",
                        "每损失5%血释放灼烧1cd2",
                        "敌人阵亡时灼烧层数转移"
                );
                break;
            case NameModel.Name_xiongshenesha:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 1, 1,
                        NameModel.HX_ws_tx_武神_天闲,
                        NameModel.HX_ws_tw_武神_天威,
                        NameModel.HX_ws_tm_武神_天猛,
                        2, 1, 1,
                        "刺棍→劈棍",
                        "造成已损血40%的伤害cd2",
                        "开战时获得损血10%的护甲"
                );
                break;
            case NameModel.Name_tiezhangbangwang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 0, 0,
                        NameModel.HX_ws_ty_武神_天勇,
                        NameModel.HX_ws_tm_武神_天猛,
                        NameModel.HX_ws_tx_武神_天雄,
                        2, 1, 1,
                        "刺棍→劈棍",
                        "增加全体破甲效果cd2",
                        "敌方失去全部护甲时获得2怒"
                );
                break;
            case NameModel.Name_yingwang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 1, 2,
                        NameModel.HX_ws_tk_武神_天魁,
                        NameModel.HX_ws_ty_武神_天勇,
                        NameModel.HX_ws_tx_武神_天闲,
                        3, 2, 2,
                        "铁布衫→天山心法",
                        "弃手牌重抽每弃1张得1怒cd2",
                        "手牌被移除时发现1张刺客牌"
                );
                break;
            case NameModel.Name_yuguanzhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 1, 1, 2,
                        NameModel.HX_ws_tk_武神_天魁,
                        NameModel.HX_ws_ty_武神_天勇,
                        NameModel.HX_ws_tx_武神_天闲,
                        3, 2, 2,
                        "绣花针→毒针",
                        "先抽牌至手牌满0怒移除cd2",
                        "开战时卡组每有1张牌给予1中毒"
                );
                break;
            case NameModel.Name_zuoshi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 1, 0,
                        NameModel.HX_ws_tg_武神_天罡,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_tk_武神_天魁,
                        4, 3, 3,
                        "铁布衫→刺剑",
                        "敌人亡回全部怒抽5张牌cd2",
                        "乱舞牌造成穿刺伤害"
                );
                break;
            case NameModel.Name_chengjisihan:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 0, 0, 0,
                        NameModel.HX_ws_tg_武神_天罡,
                        NameModel.HX_ws_tj_武神_天机,
                        NameModel.HX_ws_tk_武神_天魁,
                        4, 3, 3,
                        "刺剑→劈剑",
                        "给予冰冻时获得6护甲",
                        "清除所有负面状态cd1"
                );
                break;
            case NameModel.Name_eguanmanying:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_武神, 2, 1, 1,
                        NameModel.HX_ws_ty_武神_天勇,
                        NameModel.HX_ws_tw_武神_天威,
                        NameModel.HX_ws_tm_武神_天猛,
                        2, 1, 1,
                        "江湖心法→逍遥心法",
                        "每层灼烧造成4伤害cd2",
                        "灼烧敌人时额外造成全体灼烧1"
                );
                break;

            // TODO: 2020/2/22 飞天
            case NameModel.Name_tieshi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 1, 1, 1,
                        NameModel.HX_ft_bf_飞天_毕方,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_cm_飞天_重明,
                        4, 3, 3,
                        "绣花针→武当绵掌",
                        "卡牌被丢弃时获得6护甲",
                        "丢弃所有手牌cd=1"
                );
                break;
            case NameModel.Name_emeizhangmen:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 1, 1, 1,
                        NameModel.HX_ft_bf_飞天_毕方,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_cm_飞天_重明,
                        4, 3, 3,
                        "绣花针→毒针",
                        "中毒层数增加200%cd2",
                        "触发中毒对随机敌人造成50%伤"
                );
                break;
            case NameModel.Name_chilian:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 0, 2, 2,
                        NameModel.HX_ft_bf_飞天_毕方,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_cm_飞天_重明,
                        4, 3, 3,
                        "铁布衫→天山心法",
                        "疯狂效果的牌额外打出2次",
                        "开战时免怒打出手牌中疯狂牌"
                );
                break;
            case NameModel.Name_azi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 1, 1, 2,
                        NameModel.HX_ft_cm_飞天_重明,
                        NameModel.HX_ft_jm_飞天_九命,
                        NameModel.HX_ft_tl_飞天_天禄,
                        3, 2, 2,
                        "绣花针→毒针",
                        "获得护甲时使敌人中毒3cd2",
                        "敌阵亡时中毒层数转移"
                );
                break;
            case NameModel.Name_donghaixianzi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 1, 1, 1,
                        NameModel.HX_ft_bf_飞天_毕方,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_cm_飞天_重明,
                        4, 3, 3,
                        "刺剑→白猿",
                        "抽3召唤,召唤效果触发2次,cd1",
                        "召唤牌怒气消耗-2"
                );
                break;
            case NameModel.Name_shendiaodaxia:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 0, 1, 1,
                        NameModel.HX_ft_bf_飞天_毕方,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_cm_飞天_重明,
                        4, 3, 3,
                        "铁布衫→武当心法",
                        "造成本回合全部伤害的75%cd2",
                        "打出刺剑时抽1张牌"
                );
                break;
            case NameModel.Name_longguniang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 0, 0, 1,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_jm_飞天_九命,
                        NameModel.HX_ft_tl_飞天_天禄,
                        3, 2, 2,
                        "铁布衫→武当心法",
                        "回合开始获得2层终结触发cd2",
                        "敌方阵亡时获得20层闪避"
                );
                break;
            case NameModel.Name_xiaodongxie:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 0, 0, 1,
                        NameModel.HX_ft_cm_飞天_重明,
                        NameModel.HX_ft_jm_飞天_九命,
                        NameModel.HX_ft_tl_飞天_天禄,
                        3, 2, 2,
                        "刺剑→独角仙",
                        "60伤害发现2召唤卡cd2",
                        "冷血的伤害提高50%"
                );
                break;
            case NameModel.Name_shaominjunzhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 0, 0, 1,
                        NameModel.HX_ft_tl_飞天_天禄,
                        NameModel.HX_ft_fj_飞天_飞将,
                        NameModel.HX_ft_bh_飞天_不化,
                        2, 1, 1,
                        "铁布衫→华山心法",
                        "获得5层闪避cd2",
                        "每当闪避时抽2张牌"
                );
                break;
            case NameModel.Name_qinsheng:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 0, 1, 1,
                        NameModel.HX_ft_bf_飞天_毕方,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_cm_飞天_重明,
                        4, 3, 3,
                        "寒冰功→毒塘砂",
                        "中毒受到的伤害翻倍cd2",
                        "回合开始时触发中毒效果"
                );
                break;
            case NameModel.Name_shenxianjiejie:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 0, 1, 0,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_jm_飞天_九命,
                        NameModel.HX_ft_tl_飞天_天禄,
                        3, 2, 2,
                        "寒冰功→七杀阵",
                        "选择复制1牌阵法数-1cd2",
                        "打出阵法牌时获得4护甲"
                );
                break;
            case NameModel.Name_longwang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 0, 0, 2,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_jm_飞天_九命,
                        NameModel.HX_ft_tl_飞天_天禄,
                        3, 2, 2,
                        "江湖心法→寒阴真气",
                        "发现4张阵法牌",
                        "敌阵亡时激活所有阵法"
                );
                break;
            case NameModel.Name_kangfuren:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 0, 2, 0,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_jm_飞天_九命,
                        NameModel.HX_ft_tl_飞天_天禄,
                        3, 2, 2,
                        "江湖心法→浑天红炎",
                        "初始寒冰变阳炎,造成火伤给3层灼烧回2血",
                        "抽4张火牌cd=2"
                );
                break;
            case NameModel.Name_linger:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_飞天, 2, 0, 1,
                        NameModel.HX_ft_bx_飞天_辟邪,
                        NameModel.HX_ft_jm_飞天_九命,
                        NameModel.HX_ft_tl_飞天_天禄,
                        3, 2, 2,
                        "江湖心法→逍遥心法",
                        "回合结束时回15血持续3回合cd2",
                        "开战时回卡组卡牌数*4的真气"
                );
                break;

            // TODO: 2020/2/22 粽子
            case NameModel.Name_wantong:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 2, 1, 2,
                        NameModel.HX_zz_ds_粽子_地煞,
                        NameModel.HX_zz_dy_粽子_地勇,
                        NameModel.HX_zz_dk_粽子_地魁,
                        4, 3, 3,
                        "刺棍→锁喉",
                        "抽拳牌至牌满每个送2怒气cd2",
                        "拳掌牌不会伤到自己"
                );
                break;
            case NameModel.Name_yanziwuzhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 0, 1,
                        NameModel.HX_zz_dy_粽子_地勇,
                        NameModel.HX_zz_dx_粽子_地雄,
                        NameModel.HX_zz_dj_粽子_地杰,
                        3, 2, 2,
                        "刺棍→劈棍",
                        "敌人2张牌无效cd2",
                        "开战时反伤5层数不减"
                );
                break;
            case NameModel.Name_feitianbianfu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 1, 1,
                        NameModel.HX_zz_dx_粽子_地雄,
                        NameModel.HX_zz_dy_粽子_地英,
                        NameModel.HX_zz_dw_粽子_地威,
                        2, 1, 1,
                        "刺棍→劈棍",
                        "回合开始时每损30%血抽1牌",
                        "场上每存活1敌人抽1牌cd=1"
                );
                break;
            case NameModel.Name_jinlunguoshi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 0, 0,
                        NameModel.HX_zz_ds_粽子_地煞,
                        NameModel.HX_zz_dy_粽子_地勇,
                        NameModel.HX_zz_dk_粽子_地魁,
                        4, 3, 3,
                        "绣花针→夺命蛊",
                        "牌堆牌放进弃牌每张得1怒cd2",
                        "回合开始卡组每1暗器牌得1甲"
                );
                break;
            case NameModel.Name_tongshi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 1, 1, 1,
                        NameModel.HX_zz_dy_粽子_地勇,
                        NameModel.HX_zz_dx_粽子_地雄,
                        NameModel.HX_zz_dj_粽子_地杰,
                        3, 2, 2,
                        "绣花针→武当绵掌",
                        "造成伤害时给予1中毒1冰冻cd2",
                        "开战时触发\"此牌被丢弃\"效果"
                );
                break;
            case NameModel.Name_qiongxiongjie:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 1, 1, 1,
                        NameModel.HX_zz_dx_粽子_地雄,
                        NameModel.HX_zz_dq_粽子_地奇,
                        NameModel.HX_zz_dy_粽子_地英,
                        2, 1, 1,
                        "绣花针→毒针",
                        "抽1张牌获得6怒气cd2",
                        "每使用1怒气获得1护甲"
                );
                break;
            case NameModel.Name_jindaofuma:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 1, 2,
                        NameModel.HX_zz_ds_粽子_地煞,
                        NameModel.HX_zz_dy_粽子_地勇,
                        NameModel.HX_zz_dk_粽子_地魁,
                        4, 3, 3,
                        "刺剑→扫剑",
                        "每抽1张牌获得6护甲",
                        "使能进化的牌进化3次cd=1"
                );
                break;
            case NameModel.Name_youshi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 1, 1,
                        NameModel.HX_zz_ds_粽子_地煞,
                        NameModel.HX_zz_dy_粽子_地勇,
                        NameModel.HX_zz_dk_粽子_地魁,
                        4, 3, 3,
                        "刺剑→扫剑",
                        "触发连击二连击时获得5甲",
                        "触发手牌中的连击效果cd=1"
                );
                break;
            case NameModel.Name_donghaidaozhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 1, 0,
                        NameModel.HX_zz_ds_粽子_地煞,
                        NameModel.HX_zz_dy_粽子_地勇,
                        NameModel.HX_zz_dk_粽子_地魁,
                        4, 3, 3,
                        "江湖心法→圣火心法",
                        "真气盾吸收伤害反伤50%",
                        "每有2真气获得1护甲cd=1"
                );
                break;
            case NameModel.Name_mojiaojiaozhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 1, 1,
                        NameModel.HX_zz_ds_粽子_地煞,
                        NameModel.HX_zz_dy_粽子_地勇,
                        NameModel.HX_zz_dk_粽子_地魁,
                        4, 3, 3,
                        "寒冰功→毒蟾砂",
                        "失去所有真气2气1毒,抽2牌cd2",
                        "受到伤害时敌方中毒2"
                );
                break;
            case NameModel.Name_xingxiulaoxian:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 1, 2,
                        NameModel.HX_zz_dk_粽子_地魁,
                        NameModel.HX_zz_dx_粽子_地雄,
                        NameModel.HX_zz_dj_粽子_地杰,
                        3, 2, 2,
                        "寒冰功→毒蟾砂",
                        "敌方中毒层数增加125%cd2",
                        "敌中毒时额外造成全体中毒1"
                );
                break;
            case NameModel.Name_xuanmingerlao:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 0, 1,
                        NameModel.HX_zz_dy_粽子_地勇,
                        NameModel.HX_zz_dx_粽子_地雄,
                        NameModel.HX_zz_dj_粽子_地杰,
                        3, 2, 2,
                        "江湖心法→寒阴真气",
                        "敌方冰冻层数增加125%",
                        "敌阵亡时冰冻层数转移"
                );
                break;
            case NameModel.Name_baituoshanshaozhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_粽子, 0, 0, 1,
                        NameModel.HX_zz_dj_粽子_地杰,
                        NameModel.HX_zz_dq_粽子_地奇,
                        NameModel.HX_zz_dy_粽子_地英,
                        2, 1, 1,
                        "江湖心法→毒蟾砂",
                        "敌方中毒4抽1张牌cd2",
                        "抽牌时敌方全体中毒1"
                );
                break;

            // TODO: 2020/2/22 傀儡
            case NameModel.Name_sanzang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 1, 0,
                        NameModel.HX_kl_zs_傀儡_紫砂,
                        NameModel.HX_kl_ht_傀儡_黑陶,
                        NameModel.HX_kl_qc_傀儡_青瓷,
                        3, 2, 2,
                        "江湖心法→逍遥心法",
                        "发现4张真气牌cd2",
                        "敌方阵亡,回5%血"
                );
                break;
            case NameModel.Name_jinguoxiaowangye:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 2, 1,
                        NameModel.HX_kl_qc_傀儡_青瓷,
                        NameModel.HX_kl_hy_傀儡_红鸢,
                        NameModel.HX_kl_ly_傀儡_蓝玉,
                        2, 1, 1,
                        "刺棍→劈棍",
                        "20伤得血上限20%的甲",
                        "回合结束若无护甲获得20甲"
                );
                break;
            case NameModel.Name_congbianxiansheng:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 1, 2,
                        NameModel.HX_kl_bt_傀儡_碧铜,
                        NameModel.HX_kl_zs_傀儡_紫砂,
                        NameModel.HX_kl_gt_傀儡_古铜,
                        4, 3, 3,
                        "绣花针→夺命蛊",
                        "抽暗器牌至满手牌-1怒耗cd2",
                        "敌阵亡时抽暗器牌至手牌满"
                );
                break;
            case NameModel.Name_waner:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 0, 1,
                        NameModel.HX_kl_ht_傀儡_黑陶,
                        NameModel.HX_kl_lz_傀儡_绿竹,
                        NameModel.HX_kl_hy_傀儡_红鸢,
                        2, 1, 1,
                        "铁布衫→星宿心法",
                        "回合开始获得3绣花针cd2",
                        "绣花针改为穿刺伤害"
                );
                break;
            case NameModel.Name_yumianmengchang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 0, 1,
                        NameModel.HX_kl_ht_傀儡_黑陶,
                        NameModel.HX_kl_hy_傀儡_红鸢,
                        NameModel.HX_kl_ly_傀儡_蓝玉,
                        2, 1, 1,
                        "铁布衫→天山心法",
                        "使敌方扔2张手牌cd2",
                        "卡牌被丢弃时给予敌全体1中毒"
                );
                break;
            case NameModel.Name_linjiagongzi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 1, 0,
                        NameModel.HX_kl_zs_傀儡_紫砂,
                        NameModel.HX_kl_ht_傀儡_黑陶,
                        NameModel.HX_kl_qc_傀儡_青瓷,
                        3, 2, 2,
                        "铁布衫→武当心法",
                        "本回合穿刺10%虹吸cd2",
                        "敌方失去全部护甲时获得1冷血"
                );
                break;
            case NameModel.Name_jiansheng:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 1, 2,
                        NameModel.HX_kl_zs_傀儡_紫砂,
                        NameModel.HX_kl_ht_傀儡_黑陶,
                        NameModel.HX_kl_qc_傀儡_青瓷,
                        3, 2, 2,
                        "铁布衫→武当心法",
                        "发现4张刀剑牌cd2",
                        "开战时免怒气打2张刀剑牌"
                );
                break;
            case NameModel.Name_bukebujie:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 1, 2,
                        NameModel.HX_kl_qc_傀儡_青瓷,
                        NameModel.HX_kl_hy_傀儡_红鸢,
                        NameModel.HX_kl_ly_傀儡_蓝玉,
                        2, 1, 1,
                        "铁布衫→武当心法",
                        "造成60伤害恢复等量血cd2",
                        "触发连击时获得1怒气"
                );
                break;
            case NameModel.Name_dalishizi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 2, 1, 1,
                        NameModel.HX_kl_bt_傀儡_碧铜,
                        NameModel.HX_kl_zs_傀儡_紫砂,
                        NameModel.HX_kl_gt_傀儡_古铜,
                        4, 3, 3,
                        "江湖心法→逍遥心法",
                        "灼烧7抽3张牌cd2",
                        "开战时敌方全体灼烧2"
                );
                break;
            case NameModel.Name_dalihuangdi:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 1, 1,
                        NameModel.HX_kl_bt_傀儡_碧铜,
                        NameModel.HX_kl_zs_傀儡_紫砂,
                        NameModel.HX_kl_gt_傀儡_古铜,
                        4, 3, 3,
                        "寒冰功→阳炎劲",
                        "下2张牌会打出2次",
                        "对敌方造成火伤害后加1攻击"
                );
                break;
            case NameModel.Name_saodiseng:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 2, 2,
                        NameModel.HX_kl_bt_傀儡_碧铜,
                        NameModel.HX_kl_zs_傀儡_紫砂,
                        NameModel.HX_kl_gt_傀儡_古铜,
                        4, 3, 3,
                        "寒冰功→七杀阵",
                        "抽满阵法牌手牌消耗-4cd2",
                        "敌阵亡时抽阵法牌至手牌满"
                );
                break;
            case NameModel.Name_chongyangzhenren:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 2, 2, 2,
                        NameModel.HX_kl_bt_傀儡_碧铜,
                        NameModel.HX_kl_zs_傀儡_紫砂,
                        NameModel.HX_kl_gt_傀儡_古铜,
                        4, 3, 3,
                        "江湖心法→逍遥心法",
                        "阵法激活完回到手牌限3次cd2",
                        "回合开始时抽1张阵法牌"
                );
                break;
            case NameModel.Name_mojiaoshengnü:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_傀儡, 0, 0, 0,
                        NameModel.HX_kl_gt_傀儡_古铜,
                        NameModel.HX_kl_ht_傀儡_黑陶,
                        NameModel.HX_kl_qc_傀儡_青瓷,
                        3, 2, 2,
                        "寒冰功→北斗大阵",
                        "当前所有阵法计数-2cd2",
                        "单回合打出4阵法牌时计数-1"
                );
                break;

            // TODO: 2020/2/22 木鸢
            case NameModel.Name_yunque:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 0, 0,
                        NameModel.HX_my_hy_木鸢_皓月,
                        NameModel.HX_my_yh_木鸢_业火,
                        NameModel.HX_my_lr_木鸢_烈日,
                        4, 3, 3,
                        "刺剑→劈剑", "1层冰冻3伤cd1", "给予冰冻时刷新技能cd"
                );
                break;
            case NameModel.Name_gaibangbangzhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 0, 0,
                        NameModel.HX_my_hy_木鸢_皓月,
                        NameModel.HX_my_yh_木鸢_业火,
                        NameModel.HX_my_lr_木鸢_烈日,
                        4, 3, 3,
                        "刺棍→劈棍", "保留60%护甲", "获得30护甲cd1"
                );
                break;
            case NameModel.Name_miejuedaogu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 1, 1,
                        NameModel.HX_my_lr_木鸢_烈日,
                        NameModel.HX_my_jl_木鸢_惊雷,
                        NameModel.HX_my_ly_木鸢_流云,
                        3, 2, 2,
                        "刺棍→劈棍", "获护甲造成护甲35%的伤害", "对全体造成自己损血30%的伤"
                );
                break;
            case NameModel.Name_dongfangguniang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 1, 2,
                        NameModel.HX_my_hy_木鸢_皓月,
                        NameModel.HX_my_yh_木鸢_业火,
                        NameModel.HX_my_lr_木鸢_烈日,
                        4, 3, 3,
                        "铁布衫→魔教内功", "补满绣花针手牌-1怒消耗cd2", "敌阵亡时发现绣花针至手牌满并怒-1"
                );
                break;
            case NameModel.Name_wudujiaozhu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 1, 1, 2,
                        NameModel.HX_my_hy_木鸢_皓月,
                        NameModel.HX_my_yh_木鸢_业火,
                        NameModel.HX_my_lr_木鸢_烈日,
                        4, 3, 3,
                        "绣花针→毒针", "受伤害时回5血", "选择1手牌使其获得疯狂1cd2"
                );
                break;
            case NameModel.Name_tonglao:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 1, 1,
                        NameModel.HX_my_hy_木鸢_皓月,
                        NameModel.HX_my_yh_木鸢_业火,
                        NameModel.HX_my_lr_木鸢_烈日,
                        4, 3, 3,
                        "铁布衫→绣花针", "每打出1绣花针得4护甲[防御相关]", "立即洗牌每洗1牌得1怒cd=1"
                );
                break;
            case NameModel.Name_fuwang:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 1, 1,
                        NameModel.HX_my_yh_木鸢_业火,
                        NameModel.HX_my_jl_木鸢_惊雷,
                        NameModel.HX_my_ly_木鸢_流云,
                        3, 2, 2,
                        "铁布衫→魔教内功", "触发手牌的弃牌效果2次cd2", "虹吸回血效果翻倍"
                );
                break;
            case NameModel.Name_jiujianchuanren:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 1, 2,
                        NameModel.HX_my_hy_木鸢_皓月,
                        NameModel.HX_my_yh_木鸢_业火,
                        NameModel.HX_my_lr_木鸢_烈日,
                        4, 3, 3,
                        "铁布衫→武当心法", "80伤获得1回合初始手牌-1cd4", "单回合打出9刀剑时回50%怒气"
                );
                break;
            case NameModel.Name_junzijian:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 1, 2,
                        NameModel.HX_my_yh_木鸢_业火,
                        NameModel.HX_my_jl_木鸢_惊雷,
                        NameModel.HX_my_ly_木鸢_流云,
                        3, 2, 2,
                        "铁布衫→华山心法", "本战斗每打3张牌得10%闪避cd2", "开战时得20%闪避层数不减"
                );
                break;
            case NameModel.Name_wuebuzuo:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 1, 1,
                        NameModel.HX_my_jl_木鸢_惊雷,
                        NameModel.HX_my_cd_木鸢_赤电,
                        NameModel.HX_my_hy_木鸢_虹雨,
                        2, 1, 1,
                        "铁布衫→华山心法", "40伤害获得6怒气cd2", " 回合结束时若无护甲得闪避3"
                );
                break;
            case NameModel.Name_changchunshoutu:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 1, 1,
                        NameModel.HX_my_ly_木鸢_流云,
                        NameModel.HX_my_cd_木鸢_赤电,
                        NameModel.HX_my_hy_木鸢_虹雨,
                        2, 1, 1,
                        "刺剑→扫剑", "40伤手牌进化2次cd2", "回合开始时手牌进化1次"
                );
                break;
            case NameModel.Name_wudangzhangmen:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 2, 1,
                        NameModel.HX_my_hy_木鸢_皓月,
                        NameModel.HX_my_yh_木鸢_业火,
                        NameModel.HX_my_lr_木鸢_烈日,
                        4, 3, 3,
                        "江湖心法→圣火心法", "恢复当前20%血减伤80%1回合cd3", "回合结束恢复本回合20%所耗真气"
                );
                break;
            case NameModel.Name_bosishengnü:
                getHxValue(mRealm, userName, NameModel.HX_TYPE_木鸢, 0, 1, 1,
                        NameModel.HX_my_ly_木鸢_流云,
                        NameModel.HX_my_hy_木鸢_虹雨,
                        NameModel.HX_my_jf_木鸢_疾风,
                        2, 1, 1,
                        "江湖心法→圣火心法", "抽2张牌获得16真气cd2", " 回合开始时回复16真气"
                );
                break;
            default:
                break;
        }
    }

    private void getHxValue(Realm mRealm, String userName, String hx_type,
                            int hx_star_lv1, int hx_star_lv2, int hx_star_lv3,
                            String hx_name_1, String hx_name_2, String hx_name_3,
                            int hx_level_1, int hx_level_2, int hx_level_3,
                            String s1, String s2, String s3) {
        HxModel hxModel1, hxModel2, hxModel3;
        WXModel wxModel = mRealm.where(WXModel.class).equalTo("name_game", userName).findFirst();

        hxModel1 = new HxModel().setWxModel(wxModel).setWx_name(userName);
        hxModel2 = new HxModel().setWxModel(wxModel).setWx_name(userName);
        hxModel3 = new HxModel().setWxModel(wxModel).setWx_name(userName);

        hxModel1.setHx_value(1);
        hxModel2.setHx_value(2);
        hxModel3.setHx_value(3);
        //强化初始和增加新技能
        hxModel1.setHx_star_lv(hx_star_lv3);
        //强化武学和强化技能
        hxModel2.setHx_star_lv(hx_star_lv2);
        //替换武学和强化技能
        hxModel3.setHx_star_lv((hx_star_lv2 > hx_star_lv1) ? hx_star_lv2 : hx_star_lv1);

        hxModel1.setHx_value_default(HxModel.type_qh_强化 + s2);
        hxModel1.setHx_value_up(HxModel.type_xz_新增 + s3);

        hxModel2.setHx_value_default("修炼自带武学");
        hxModel2.setHx_value_up(HxModel.type_qh_强化 + s2);

        hxModel3.setHx_value_default(s1);
        hxModel3.setHx_value_up(HxModel.type_qh_强化 + s2);

        hxModel1.setHx_id(userName + hx_type + hx_name_1);
        hxModel2.setHx_id(userName + hx_type + hx_name_2);
        hxModel3.setHx_id(userName + hx_type + hx_name_3);

        hxModel1.setHx_name(hx_name_1);
        hxModel2.setHx_name(hx_name_2);
        hxModel3.setHx_name(hx_name_3);

        hxModel1.setParent(wxModel.getParent());
        hxModel2.setParent(wxModel.getParent());
        hxModel3.setParent(wxModel.getParent());

        hxModel1.setHx_type(hx_type);
        hxModel2.setHx_type(hx_type);
        hxModel3.setHx_type(hx_type);


        hxModel1.setHx_level(hx_level_1);
        hxModel2.setHx_level(hx_level_2);
        hxModel3.setHx_level(hx_level_3);

        mRealm.copyToRealmOrUpdate(hxModel1);
        mRealm.copyToRealmOrUpdate(hxModel2);
        mRealm.copyToRealmOrUpdate(hxModel3);
    }

    private void getHxValue(Realm mRealm, String userName, String hx_type,
                            String hx_name_1, String hx_name_2, String hx_name_3,
                            int hx_level_1, int hx_level_2, int hx_level_3,
                            String s1, String s2, String s3) {
        getHxValue(mRealm, userName, hx_type, 0, 0, 0,
                hx_name_1, hx_name_2, hx_name_3
                , hx_level_1, hx_level_2, hx_level_3,
                s1, s2, s3
        );
    }
}
