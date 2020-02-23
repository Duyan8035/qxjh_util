package com.dy.qxjhutil.activity.hx;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evrencoskun.tableview.filter.IFilterableModel;
import com.evrencoskun.tableview.sort.ISortableModel;

/**
 * Created by Dy on 2020/2/19 14
 *
 * @author Dy
 */
public class Cell implements IFilterableModel, ISortableModel {
    private CharSequence str;
    private String index;

    public String getIndex() {
        return index == null ? "" : index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Cell(CharSequence str) {
        this.str = str;
    }

    public Cell(CharSequence str, String index) {
        this.str = str;
        this.index = index;
    }

    public Cell() {
    }

    public CharSequence getStr() {
        return str == null ? "" : str;
    }

    public void setStr(CharSequence str) {
        this.str = str;
    }

    @NonNull
    @Override
    public String getFilterableKeyword() {
        if (!TextUtils.isEmpty(index) && index.length() > 0) {
            return index;
        } else {
            return str.toString();
        }
    }

    @NonNull
    @Override
    public String getId() {
        return str.toString();
    }

    @Nullable
    @Override
    public Object getContent() {
        return str;
    }
}
