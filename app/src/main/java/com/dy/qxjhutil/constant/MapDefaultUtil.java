package com.dy.qxjhutil.constant;

import android.content.Context;

import com.dy.qxjhutil.R;
import com.dy.qxjhutil.model.ArtifactModel;
import com.dy.qxjhutil.model.HerbsModel;
import com.dy.qxjhutil.model.KungFuModel;
import com.dy.qxjhutil.model.MapModel;
import com.dy.qxjhutil.model.MineralModel;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;

import io.realm.Realm;

/**
 * Created by Dy on 2019/4/29 14
 *
 * @author Dy
 */
public class MapDefaultUtil {

    public void initData(Context mContext) {
        Realm.init(mContext);
        RealmHelper.getInstance(mContext).executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                initMapName(realm);

                initHerbs(realm);
                initMineral(realm);
                initArtifact(realm);

                initMap(realm);
            }
        });
    }

    private void initMapName(Realm realm) {
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_1));
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_2));
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_3));
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_4));
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_5));
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_6));
    }

    private void initHerbs(Realm realm) {
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_xuelian)
                .setImg(R.drawable.icon_yaocai_xuelian)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_fengyu)
                .setImg(R.drawable.icon_yaocai_fengyu)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_jinchan)
                .setImg(R.drawable.icon_yaocai_jinchan)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_wujizhao)
                .setImg(R.drawable.icon_yaocai_wujizhua)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_hamayou)
                .setImg(R.drawable.icon_yaocai_hamayou)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_lurong)
                .setImg(R.drawable.icon_yaocai_lurong)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_longgu)
                .setImg(R.drawable.icon_yaocai_longgu)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_longxianxiang)
                .setImg(R.drawable.icon_yaocai_longyanxiang)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_lingzhi)
                .setImg(R.drawable.icon_yaocai_lingzhi)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_renshen)
                .setImg(R.drawable.icon_yaocai_renshen)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );

    }


    private void initMineral(Realm realm) {
        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_tangang)
                .setImg(R.drawable.icon_kuangshi_tangang)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_qingtong)
                .setImg(R.drawable.icon_kuangshi_qingtong)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_bailamu)
                .setImg(R.drawable.icon_kuangshi_bailamu)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_baishuijing)
                .setImg(R.drawable.icon_kuangshi_baishuijing)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_lanshuijing)
                .setImg(R.drawable.icon_kuangshi_lanshuijing)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_jingjin)
                .setImg(R.drawable.icon_kuangshi_jingjin)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_xuantie)
                .setImg(R.drawable.icon_kuangshi_xuantie)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_hongshuijing)
                .setImg(R.drawable.icon_kuangshi_hongshuijing)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_heishuijing)
                .setImg(R.drawable.icon_kuangshi_heishuijing)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );


    }

    private void initArtifact(Realm realm) {
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_yitianjian)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_tulongdao)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_dagoubang)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_yuxiao)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_jinlun)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_shenghuoling)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_bawangqiang)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_xuantiezhongjian)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_xiuhuazhen)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_fenghuangqin)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_panguanbi)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_jinlingzheshan)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_luorigong)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", NameModel.MAP_NAME_1).findFirst())
        );
    }

    private void initMap(Realm realm) {
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_1)
                .setValue(NameModel.MAP_VALUE_1)
                .setImg(R.drawable.icon_map_shaolin)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_11).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_12).findFirst())
                .setMineral(new MineralModel(NameModel.MINERAL_bailamu), new MineralModel(NameModel.MINERAL_tangang),
                        new MineralModel(NameModel.MINERAL_xuantie), new MineralModel(NameModel.MINERAL_qingtong))
                .setHerbs(new HerbsModel(NameModel.HERBS_jinchan), new HerbsModel(NameModel.HERBS_xuelian),
                        new HerbsModel(NameModel.HERBS_renshen), new HerbsModel(NameModel.HERBS_hamayou))
                .setArtifact(new ArtifactModel(NameModel.ARTIFACT_yitianjian), new ArtifactModel(NameModel.ARTIFACT_tulongdao))
                .setWxModel1(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_bukebujie).findFirst())
                .setWxModel2(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_yanziwuzhu).findFirst())
        );

        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_2)
                .setValue(NameModel.MAP_VALUE_2)
                .setImg(R.drawable.icon_map_huashan)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_21).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_22).findFirst())
                .setMineral(new MineralModel(NameModel.MINERAL_tangang), new MineralModel(NameModel.MINERAL_xuantie),
                        new MineralModel(NameModel.MINERAL_hongshuijing), new MineralModel(NameModel.MINERAL_jingjin))
                .setHerbs(new HerbsModel(NameModel.HERBS_wujizhao), new HerbsModel(NameModel.HERBS_lingzhi),
                        new HerbsModel(NameModel.HERBS_longxianxiang))
                .setArtifact(new ArtifactModel(NameModel.ARTIFACT_yuxiao), new ArtifactModel(NameModel.ARTIFACT_dagoubang))
                .setWxModel1(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_xiongshenesha).findFirst())
                .setWxModel2(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_tongshi).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_3)
                .setValue(NameModel.MAP_VALUE_3)
                .setImg(R.drawable.icon_map_damo)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_31).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_32).findFirst())
                .setMineral(new MineralModel(NameModel.MINERAL_baishuijing), new MineralModel(NameModel.MINERAL_heishuijing),
                        new MineralModel(NameModel.MINERAL_lanshuijing), new MineralModel(NameModel.MINERAL_jingjin))
                .setHerbs(new HerbsModel(NameModel.HERBS_lurong), new HerbsModel(NameModel.HERBS_fengyu),
                        new HerbsModel(NameModel.HERBS_longgu))
                .setArtifact(new ArtifactModel(NameModel.ARTIFACT_panguanbi), new ArtifactModel(NameModel.ARTIFACT_bawangqiang))
                .setWxModel1(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_waner).findFirst())
                .setWxModel2(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_azi).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_4)
                .setValue(NameModel.MAP_VALUE_4)
                .setImg(R.drawable.icon_map_gumu)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_41).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_42).findFirst())
                .setMineral(new MineralModel(NameModel.MINERAL_baishuijing), new MineralModel(NameModel.MINERAL_bailamu),
                        new MineralModel(NameModel.MINERAL_hongshuijing), new MineralModel(NameModel.MINERAL_jingjin), new MineralModel(NameModel.MINERAL_lanshuijing))
                .setHerbs(new HerbsModel(NameModel.HERBS_lingzhi), new HerbsModel(NameModel.HERBS_longgu),
                        new HerbsModel(NameModel.HERBS_renshen), new HerbsModel(NameModel.HERBS_hamayou))
                .setArtifact(new ArtifactModel(NameModel.ARTIFACT_jinlun), new ArtifactModel(NameModel.ARTIFACT_fenghuangqin))
                .setWxModel1(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_jinguoxiaowangye).findFirst())
                .setWxModel2(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_longguniang).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_5)
                .setValue(NameModel.MAP_VALUE_5)
                .setImg(R.drawable.icon_map_binghuodao)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_51).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_52).findFirst())
                .setMineral(new MineralModel(NameModel.MINERAL_tangang), new MineralModel(NameModel.MINERAL_baishuijing),
                        new MineralModel(NameModel.MINERAL_lanshuijing), new MineralModel(NameModel.MINERAL_hongshuijing))
                .setHerbs(new HerbsModel(NameModel.HERBS_xuelian), new HerbsModel(NameModel.HERBS_jinchan),
                        new HerbsModel(NameModel.HERBS_lurong))
                .setArtifact(new ArtifactModel(NameModel.ARTIFACT_shenghuoling), new ArtifactModel(NameModel.ARTIFACT_luorigong))
                .setWxModel1(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_bosishengnü).findFirst())
                .setWxModel2(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_longwang).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel(NameModel.MAP_NAME_6)
                .setValue(NameModel.MAP_VALUE_6)
                .setImg(R.drawable.icon_map_zhuling)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_61).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", NameModel.MAP_NAME_62).findFirst())
                .setMineral(new MineralModel(NameModel.MINERAL_qingtong), new MineralModel(NameModel.MINERAL_bailamu),
                        new MineralModel(NameModel.MINERAL_xuantie), new MineralModel(NameModel.MINERAL_heishuijing))
                .setHerbs(new HerbsModel(NameModel.HERBS_wujizhao), new HerbsModel(NameModel.HERBS_longxianxiang),
                        new HerbsModel(NameModel.HERBS_fengyu))
                .setArtifact(new ArtifactModel(NameModel.ARTIFACT_jinlingzheshan), new ArtifactModel(NameModel.ARTIFACT_kaitianfu))
                .setWxModel1(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_baituoshanshaozhu).findFirst())
                .setWxModel2(realm.where(WXModel.class).equalTo("name_game", NameModel.Name_mojiaoshengnü).findFirst())
        );
    }

}
