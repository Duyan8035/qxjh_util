package com.dy.qxjhutil.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.WXModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 *
 **/
public class WxListActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private BaseQuickAdapter<WXModel, BaseViewHolder> mAdapter;
    private List<WXModel> mList = new ArrayList<>();

    Realm mRealm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_list);

        mRealm = Realm.getDefaultInstance();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_sj_list) {
            @Override
            protected void convert(BaseViewHolder helper, WXModel item) {
//                helper.setText(R.id.item_wx_list_name, item.getName_game())
//                        .setText(R.id.item_wx_list_value, item.getValue());

                helper.setText(R.id.item_wx_sj_list_name, item.getName_game());
            }
        };
        recyclerView.setAdapter(mAdapter);

        initData();

    }

    private void initData() {
        mAdapter.setNewData(mRealm.where(WXModel.class).findAll());
    }
}
