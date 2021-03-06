package com.dy.qxjhutil.util;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmHelper {

    public static Realm getInstance(Context ctx) {
        Realm realm = null;
//        try {
//            realm = Realm.getDefaultInstance();
//        } catch (RealmMigrationNeededException e) {
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(8)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(config);
//        }

        return realm;
    }

}