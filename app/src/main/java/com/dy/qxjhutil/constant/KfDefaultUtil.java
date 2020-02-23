package com.dy.qxjhutil.constant;

import android.content.Context;

import com.dy.qxjhutil.R;
import com.dy.qxjhutil.model.KungFuModel;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;

import io.realm.Realm;

/**
 * Created by Dy on 2019/5/2 13
 *
 * @author Dy
 */
public class KfDefaultUtil {
    public void initData(Context mContext) {
        Realm.init(mContext);
        RealmHelper.getInstance(mContext).executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                initKf1(realm);
                initKf2(realm);
                initKf3(realm);
                initKf4(realm);
                initKf5(realm);
            }
        });
    }

    /**
     * 基础
     **/
    private void initKf1(Realm realm) {
    }

    /**
     * 成就
     **/
    private void initKf2(Realm realm) {
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_duanyundao)
                .setCost(KfValueStr.kf_duanyundao_cost)
                .setIndex("d")
                .setDesc(KfValueStr.kf_duanyundao_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_duanyundao)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_baihongguanri)
                .setCost(KfValueStr.kf_baihongguanri_cost)
                .setIndex("b")
                .setDesc(KfValueStr.kf_baihongguanri_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_baihongguanri)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_lipihuashan)
                .setCost(KfValueStr.kf_lipihuashan_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_lipihuashan_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_lipihuashan)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_tongbeiquan)
                .setCost(KfValueStr.kf_tongbeiquan_cost)
                .setIndex("t")
                .setDesc(KfValueStr.kf_tongbeiquan_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_tongbeiquan)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_dashouyin)
                .setCost(KfValueStr.kf_dashouyin_cost)
                .setIndex("d")
                .setDesc(KfValueStr.kf_dashouyin_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_dashouying)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_zhemeiwenxue)
                .setCost(KfValueStr.kf_zhemeiwenxue_cost)
                .setIndex("z")
                .setDesc(KfValueStr.kf_zhemeiwenxue_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_zhemeiwenxue)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_furongjinzhen)
                .setCost(KfValueStr.kf_furongjinzhen_cost)
                .setIndex("f")
                .setDesc(KfValueStr.kf_furongjinzhen_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_furongjinzhen)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_zhuiyuefeidao)
                .setCost(KfValueStr.kf_zhuiyuefeidao_cost)
                .setIndex("z")
                .setDesc(KfValueStr.kf_zhuiyuefeidao_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_zhuiyuefeidao)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_jiujiebianfa)
                .setCost(KfValueStr.kf_jiujiebianfa_cost)
                .setIndex("j")
                .setDesc(KfValueStr.kf_jiujiebianfa_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_jiujianbianfa)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_diancangjianfa)
                .setCost(KfValueStr.kf_diancangjianfa_cost)
                .setIndex("d")
                .setDesc(KfValueStr.kf_diancangjianfa_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_diancangjianfa)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_luohanquan)
                .setCost(KfValueStr.kf_luohanquan_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_luohanquan_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_luohanquan)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_binglingyinzhen)
                .setCost(KfValueStr.kf_binglingyinzhen_cost)
                .setIndex("b")
                .setDesc(KfValueStr.kf_binglingyinzhen_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_binlingyinzhen)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_xiaoyaoxinfa)
                .setCost(KfValueStr.kf_xiaoyaoxinfa_cost)
                .setIndex("x")
                .setDesc(KfValueStr.kf_xiaoyaoxinfa_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_xiaoyaoxinfa)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_shaolinchunyanggong)
                .setCost(KfValueStr.kf_shaolinchunyanggong_cost)
                .setIndex("s")
                .setDesc(KfValueStr.kf_shaolinchunyanggong_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_shaolinchunyanggong)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_chunyangshengong)
                .setCost(KfValueStr.kf_chunyangshengong_cost)
                .setIndex("c")
                .setDesc(KfValueStr.kf_chunyangshengong_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_chunyangshengong)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_tianchanyin)
                .setCost(KfValueStr.kf_tianchanyin_cost)
                .setIndex("t")
                .setDesc(KfValueStr.kf_tianchanyin_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_tianchanying)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_foguangpuzhao)
                .setCost(KfValueStr.kf_foguangpuzhao_cost)
                .setIndex("f")
                .setDesc(KfValueStr.kf_foguangpuzhao_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_foguangpuzhao)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_beidizhiming)
                .setCost(KfValueStr.kf_beidizhiming_cost)
                .setIndex("b")
                .setDesc(KfValueStr.kf_beidizhiming_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_beidizhiming)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_hanshasheying)
                .setCost(KfValueStr.kf_hanshasheying_cost)
                .setIndex("h")
                .setDesc(KfValueStr.kf_hanshasheying_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_hanshasheying)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_linghoubangfa)
                .setCost(KfValueStr.kf_linghoubangfa_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_linghoubangfa_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_linhoubangfa)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_jinzhongzhao)
                .setCost(KfValueStr.kf_jinzhongzhao_cost)
                .setIndex("j")
                .setDesc(KfValueStr.kf_jinzhongzhao_desc)
                .setType(2)
                .setImg(R.drawable.icon_kf_jinzhongzhao)
        );
    }

    /**
     * 武侠自带
     **/
    private void initKf3(Realm realm) {
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_jianmojiushi)
                .setCost(KfValueStr.kf_jianmojiushi_cost)
                .setIndex("j")
                .setDesc(KfValueStr.kf_jianmojiushi_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_jianmojiushi)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_wulunlianhuan)
                .setCost(KfValueStr.kf_wulunlianhuan_cost)
                .setIndex("w")
                .setDesc(KfValueStr.kf_wulunlianhuan_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_wulunlianhuan)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_kuihuadafa)
                .setCost(KfValueStr.kf_kuihuadafa_cost)
                .setIndex("k")
                .setDesc(KfValueStr.kf_kuihuadafa_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_kuihuadafa)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_kanglongyouhui)
                .setCost(KfValueStr.kf_kanglongyouhui_cost)
                .setIndex("k")
                .setDesc(KfValueStr.kf_kanglongyouhui_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_kanglongyouhui)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_yangchunbaixue)
                .setCost(KfValueStr.kf_yangchunbaixue_cost)
                .setIndex("y")
                .setDesc(KfValueStr.kf_yangchunbaixue_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_yangchunbaixue)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_taijiquan)
                .setCost(KfValueStr.kf_taijiquan_cost)
                .setIndex("t")
                .setDesc(KfValueStr.kf_taijiquan_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_taijiquan)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_hamaxianfa)
                .setCost(KfValueStr.kf_hamaxianfa_cost)
                .setIndex("h")
                .setDesc(KfValueStr.kf_hamaxianfa_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_hamaxianfa)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_piaoxuechuanyunzhang)
                .setCost(KfValueStr.kf_piaoxuechuanyunzhang_cost)
                .setIndex("p")
                .setDesc(KfValueStr.kf_piaoxuechuanyunzhang_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_piaoxuechuanyunzhang)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_feilongzaitian)
                .setCost(KfValueStr.kf_feilongzaitian_cost)
                .setIndex("f")
                .setDesc(KfValueStr.kf_feilongzaitian_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_feilongzaitian)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_shizihou)
                .setCost(KfValueStr.kf_shizihou_cost)
                .setIndex("s")
                .setDesc(KfValueStr.kf_shizihou_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_shizihou)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_changjinglu)
                .setCost(KfValueStr.kf_changjinglu_cost)
                .setIndex("c")
                .setDesc(KfValueStr.kf_changjinglu_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_changjinlu)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_lengyuekuiren)
                .setCost(KfValueStr.kf_lengyuekuiren_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_lengyuekuiren_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_lengyuekuiren)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_xianglongjianfa)
                .setCost(KfValueStr.kf_xianglongjianfa_cost)
                .setIndex("x")
                .setDesc(KfValueStr.kf_xianglongjianfa_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_xianglongjianfa)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_zhongjianwufeng)
                .setCost(KfValueStr.kf_zhongjianwufeng_cost)
                .setIndex("z")
                .setDesc(KfValueStr.kf_zhongjianwufeng_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_zhongjianwufeng)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_hunqianmengying)
                .setCost(KfValueStr.kf_hunqianmengying_cost)
                .setIndex("h")
                .setDesc(KfValueStr.kf_hunqianmengying_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_hunqianmengying)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_lijianwuyi)
                .setCost(KfValueStr.kf_lijianwuyi_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_lijianwuyi_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_lijianwuyi)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_weiwoduxing)
                .setCost(KfValueStr.kf_weiwoduxing_cost)
                .setIndex("w")
                .setDesc(KfValueStr.kf_weiwoduxing_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_weiwoduxing)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_canghaiyisu)
                .setCost(KfValueStr.kf_canghaiyisu_cost)
                .setIndex("c")
                .setDesc(KfValueStr.kf_canghaiyisu_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_canghaiyishu)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_wujishengong)
                .setCost(KfValueStr.kf_wujishengong_cost)
                .setIndex("w")
                .setDesc(KfValueStr.kf_wujishengong_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_wujishengong)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_emeichunyanggong)
                .setCost(KfValueStr.kf_emeichunyanggong_cost)
                .setIndex("e")
                .setDesc(KfValueStr.kf_emeichunyanggong_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_emeichunyanggong)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_dangjianshi)
                .setCost(KfValueStr.kf_dangjianshi_cost)
                .setIndex("d")
                .setDesc(KfValueStr.kf_dangjianshi_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_dangjianshi)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_luanjianshi)
                .setCost(KfValueStr.kf_luanjianshi_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_luanjianshi_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_luanjianshi)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_zhuibulianhuandao)
                .setCost(KfValueStr.kf_zhuibulianhuandao_cost)
                .setIndex("z")
                .setDesc(KfValueStr.kf_zhuibulianhuandao_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_zhuibulianhuandao)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_hengshanjianfa)
                .setCost(KfValueStr.kf_hengshanjianfa_cost)
                .setIndex("h")
                .setDesc(KfValueStr.kf_hengshanjianfa_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_hengshanjianfa)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_pingshaluoyan)
                .setCost(KfValueStr.kf_pingshaluoyan_cost)
                .setIndex("p")
                .setDesc(KfValueStr.kf_pingshaluoyan_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_pingshaluoyan)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_luohandao)
                .setCost(KfValueStr.kf_luohandao_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_luohandao_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_luohandao)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_daocaoren)
                .setCost(KfValueStr.kf_daocaoren_cost)
                .setIndex("d")
                .setDesc(KfValueStr.kf_daocaoren_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_daocaoren)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_jiyinshengong)
                .setCost(KfValueStr.kf_jiyinshengong_cost)
                .setIndex("j")
                .setDesc(KfValueStr.kf_jiyinshengong_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_jiyingshengong)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_hanbingmianzhang)
                .setCost(KfValueStr.kf_hanbingmianzhang_cost)
                .setIndex("h")
                .setDesc(KfValueStr.kf_hanbingmianzhang_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_hanbinmianzhang)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_yingzhaogong)
                .setCost(KfValueStr.kf_yingzhaogong_cost)
                .setIndex("y")
                .setDesc(KfValueStr.kf_yingzhaogong_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_yinzhuagong)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_jiyintouguzhao)
                .setCost(KfValueStr.kf_jiyintouguzhao_cost)
                .setIndex("j")
                .setDesc(KfValueStr.kf_jiyintouguzhao_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_jiyingtouguzhua)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_guanyinlei)
                .setCost(KfValueStr.kf_guanyinlei_cost)
                .setIndex("g")
                .setDesc(KfValueStr.kf_guanyinlei_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_guanyinlei)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_baoyulihuazhen)
                .setCost(KfValueStr.kf_baoyulihuazhen_cost)
                .setIndex("b")
                .setDesc(KfValueStr.kf_baoyulihuazhen_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_baoyulihuazhen)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_tiannüsanhua)
                .setCost(KfValueStr.kf_tiannüsanhua_cost)
                .setIndex("t")
                .setDesc(KfValueStr.kf_tiannüsanhua_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_tiannvsanhua)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_cuixinzhang)
                .setCost(KfValueStr.kf_cuixinzhang_cost)
                .setIndex("c")
                .setDesc(KfValueStr.kf_cuixinzhang_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_cuixinzhang)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_yufengyin)
                .setCost(KfValueStr.kf_yufengyin_cost)
                .setIndex("y")
                .setDesc(KfValueStr.kf_yufengyin_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_yufengying)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_jinsheruanbian)
                .setCost(KfValueStr.kf_jinsheruanbian_cost)
                .setIndex("j")
                .setDesc(KfValueStr.kf_jinsheruanbian_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_jinsheruanbian)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_lianhuanfushidu)
                .setCost(KfValueStr.kf_lianhuanfushidu_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_lianhuanfushidu_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_lianhuanfushidu)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_wudangmianzhang)
                .setCost(KfValueStr.kf_wudangmianzhang_cost)
                .setIndex("w")
                .setDesc(KfValueStr.kf_wudangmianzhang_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_wudangmianzhang)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_xiulijian)
                .setCost(KfValueStr.kf_xiulijian_cost)
                .setIndex("x")
                .setDesc(KfValueStr.kf_xiulijian_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_xiulijian)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_bihaichaosheng)
                .setCost(KfValueStr.kf_bihaichaosheng_cost)
                .setIndex("b")
                .setDesc(KfValueStr.kf_bihaichaosheng_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_bihaichaosheng)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_wuxiangneigong)
                .setCost(KfValueStr.kf_wuxiangneigong_cost)
                .setIndex("w")
                .setDesc(KfValueStr.kf_wuxiangneigong_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_wuxiangneigong)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_wudangchunyanggong)
                .setCost(KfValueStr.kf_wudangchunyanggong_cost)
                .setIndex("w")
                .setDesc(KfValueStr.kf_wudangchunyanggong_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_wudangchunyanggong)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_chongquan)
                .setCost(KfValueStr.kf_chongquan_cost)
                .setIndex("c")
                .setDesc(KfValueStr.kf_chongquan_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_chongquan)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_xingchendafa)
                .setCost(KfValueStr.kf_xingchendafa_cost)
                .setIndex("x")
                .setDesc(KfValueStr.kf_xingchendafa_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_xingchendafa)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_huanyinzhi)
                .setCost(KfValueStr.kf_huanyinzhi_cost)
                .setIndex("h")
                .setDesc(KfValueStr.kf_huanyinzhi_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_huanyingzhi)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_chunyangzhizungong)
                .setCost(KfValueStr.kf_chunyangzhizungong_cost)
                .setIndex("c")
                .setDesc(KfValueStr.kf_chunyangzhizungong_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_chunyangzhizungong)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_lingsheyin)
                .setCost(KfValueStr.kf_lingsheyin_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_lingsheyin_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_linsheying)
        );
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.kf_lingshequanfa)
                .setCost(KfValueStr.kf_lingshequanfa_cost)
                .setIndex("l")
                .setDesc(KfValueStr.kf_lingshequanfa_desc)
                .setType(3)
                .setImg(R.drawable.icon_kf_lingshequanfa)
        );

    }

    /**
     * 成就
     **/
    private void initKf4(Realm realm) {

    }

    /**
     * 隐藏
     **/
    private void initKf5(Realm realm) {

        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_12)
                .setTrendGood(4, -4)
                .setIndex("q")
                .setImg(R.drawable.icon_kf_qishangquan)
                .setCost(KfValueStr.kf_qishangquan_cost)
                .setDesc(KfValueStr.kf_qishangquan_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_dalunmingwang).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_dalunmingwang).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_12).findFirst()));

        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_11)
                .setTrendGood(0, 5)
                .setIndex("y")
                .setImg(R.drawable.icon_kf_yinyangfu)
                .setCost(KfValueStr.kf_yinyangfu_cost)
                .setDesc(KfValueStr.kf_yinyangfu_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_lingjiugongzhu).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_lingjiugongzhu).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_11).findFirst()));

        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_21)
                .setTrendGood(-5, 0)
                .setIndex("l")
                .setImg(R.drawable.icon_kf_luohualiushui)
                .setCost(KfValueStr.kf_luohualiushui_cost)
                .setDesc(KfValueStr.kf_luohualiushui_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_donghaidaozhu).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_donghaidaozhu).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_21).findFirst()));
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_22)
                .setTrendGood(0, 5)
                .setIndex("k")
                .setCost(KfValueStr.kf_kongmingquan_cost)
                .setDesc(KfValueStr.kf_kongmingquan_desc)
                .setType(4)
                .setImg(R.drawable.icon_kf_kongmingquan)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_dalihuangdi).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_dalihuangdi).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_22).findFirst()));
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_31)
                .setTrendGood(4, 4)
                .setIndex("s")
                .setImg(R.drawable.icon_kf_shuangshouhubo)
                .setCost(KfValueStr.kf_shuangshouhubo_cost)
                .setDesc(KfValueStr.kf_shuangshouhubo_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_jindaofuma).findFirst())
        );

        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_jindaofuma).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_31).findFirst()));
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_32)
                .setTrendGood(0, 0)
                .setIndex("d")
                .setImg(R.drawable.icon_kf_lanhuazhi)
                .setCost(KfValueStr.kf_lanhuazhi_cost)
                .setDesc(KfValueStr.kf_lanhuazhi_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_donghaixianzi).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_donghaixianzi).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_32).findFirst()));
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_41)
                .setTrendGood(4, -4)
                .setIndex("m")
                .setImg(R.drawable.icon_kf_miejianjuejian)
                .setCost(KfValueStr.kf_miejianjuejian_cost)
                .setDesc(KfValueStr.kf_miejianjuejian_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_jinlunguoshi).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_jinlunguoshi).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_41).findFirst()));
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_42)
                .setTrendGood(-4, 4)
                .setIndex("r")
                .setImg(R.drawable.icon_kf_ruanjianwuchang)
                .setCost(KfValueStr.kf_ruanjianwuchang_cost)
                .setDesc(KfValueStr.kf_ruanjianwuchang_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_shendiaodaxia).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_shendiaodaxia).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_42).findFirst()));
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_51)
                .setTrendGood(4, 4)
                .setIndex("c")
                .setImg(R.drawable.icon_kf_chunyangwujigong)
                .setCost(KfValueStr.kf_chunyangwujigong_cost)
                .setDesc(KfValueStr.kf_chunyangwujigong_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_taijichanren).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_taijichanren).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_51).findFirst()));
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_52)
                .setTrendGood(0, -5)
                .setIndex("w")
                .setImg(R.drawable.icon_kf_wudushenzhang)
                .setCost(KfValueStr.kf_wudushenzhang_cost)
                .setDesc(KfValueStr.kf_wudushenzhang_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_emeizhangmen).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_emeizhangmen).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_52).findFirst()));
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_61)
                .setTrendGood(-5, 0)
                .setIndex("w")
                .setImg(R.drawable.icon_kf_weiwoduzun)
                .setCost(KfValueStr.kf_weiwoduzun_cost)
                .setDesc(KfValueStr.kf_weiwoduzun_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_dongfangguniang).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_dongfangguniang).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_61).findFirst()));
        realm.copyToRealmOrUpdate(new KungFuModel(NameModel.MAP_NAME_62)
                .setTrendGood(-4, 4)
                .setIndex("y")
                .setImg(R.drawable.icon_kf_yijingjing)
                .setCost(KfValueStr.kf_yijingjin_cost)
                .setDesc(KfValueStr.kf_yijingjin_desc)
                .setType(4)
                .setWx_parent(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_jiujianchuanren).findFirst())
        );
        realm.copyToRealmOrUpdate(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_jiujianchuanren).findFirst()
                .setKfParent(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_62).findFirst()));
    }

}
