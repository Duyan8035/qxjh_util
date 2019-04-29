package com.dy.qxjhutil.constant;

import android.content.Context;

import com.dy.qxjhutil.R;
import com.dy.qxjhutil.model.ArtifactModel;
import com.dy.qxjhutil.model.HerbsModel;
import com.dy.qxjhutil.model.KungFuModel;
import com.dy.qxjhutil.model.MapModel;
import com.dy.qxjhutil.model.MineralModel;
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
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_1));
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_2));
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_3));
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_4));
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_5));
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_6));
    }

    private void initHerbs(Realm realm) {
        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_NAME_01)
                .setImg(R.drawable.icon_map_shaolin)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", WxDefaultUtil.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", WxDefaultUtil.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new HerbsModel(NameModel.HERBS_NAME_11)
                .setImg(R.drawable.icon_map_shaolin)
                .setHerbs1(new HerbsModel(NameModel.HERBS_NAME_01, 10))
                .setHerbs2(new HerbsModel(NameModel.HERBS_NAME_02, 10))
                .setHerbs3(new HerbsModel(NameModel.HERBS_NAME_03, 20))
        );
    }


    private void initMineral(Realm realm) {
        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_NAME_01)
                .setImg(R.drawable.icon_map_shaolin)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", WxDefaultUtil.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", WxDefaultUtil.MAP_NAME_1).findFirst())
        );

        realm.copyToRealmOrUpdate(new MineralModel(NameModel.MINERAL_NAME_02)
                .setImg(R.drawable.icon_map_shaolin)
                .setMap1(realm.where(MapModel.class).equalTo("mapName", WxDefaultUtil.MAP_NAME_1).findFirst())
                .setMap2(realm.where(MapModel.class).equalTo("mapName", WxDefaultUtil.MAP_NAME_1).findFirst())
        );
    }

    private void initArtifact(Realm realm) {
        realm.copyToRealmOrUpdate(new ArtifactModel(NameModel.ARTIFACT_NAME_01)
                .setImg(R.drawable.icon_map_shaolin)
                .setCd("").setValue("").setDesc("").setParent("")
                .setMapModel(realm.where(MapModel.class).equalTo("mapName", WxDefaultUtil.MAP_NAME_1).findFirst())
                .setMineralModel1(realm.where(MineralModel.class).equalTo("name", NameModel.MINERAL_NAME_01).findFirst())
                .setMineralModel2(realm.where(MineralModel.class).equalTo("name", NameModel.MINERAL_NAME_02).findFirst())
                .setMineralModel3(realm.where(MineralModel.class).equalTo("name", NameModel.MINERAL_NAME_03).findFirst())
        );
    }

    private void initMap(Realm realm) {
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_1)
                .setValue(WxDefaultUtil.MAP_VALUE_1)
                .setImg(R.drawable.icon_map_shaolin)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_11).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_12).findFirst())
        );

        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_2)
                .setValue(WxDefaultUtil.MAP_VALUE_2)
                .setImg(R.drawable.icon_map_huashan)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_21).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_22).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_3)
                .setValue(WxDefaultUtil.MAP_VALUE_3)
                .setImg(R.drawable.icon_map_damo)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_31).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_32).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_4)
                .setValue(WxDefaultUtil.MAP_VALUE_4)
                .setImg(R.drawable.icon_map_gumu)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_41).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_42).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_5)
                .setValue(WxDefaultUtil.MAP_VALUE_5)
                .setImg(R.drawable.icon_map_binghuodao)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_51).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_52).findFirst())
        );
        realm.copyToRealmOrUpdate(new MapModel(WxDefaultUtil.MAP_NAME_6)
                .setValue(WxDefaultUtil.MAP_VALUE_6)
                .setImg(R.drawable.icon_map_zhuling)
                .setFuModel1(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_61).findFirst())
                .setFuModel2(realm.where(KungFuModel.class).equalTo("name", WxDefaultUtil.MAP_NAME_62).findFirst())
        );
    }


}
