package com.dy.qxjhutil.model.bean;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Dy on 2019/4/29 19
 *
 * @author Dy
 */
@RealmClass
public class KsNameClass implements RealmModel {
    @PrimaryKey
    private String name;

    public KsNameClass(String name) {
        this.name = name;
    }
}
