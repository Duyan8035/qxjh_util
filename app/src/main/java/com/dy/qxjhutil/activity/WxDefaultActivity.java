package com.dy.qxjhutil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.WXModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class WxDefaultActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private BaseQuickAdapter<WXModel, BaseViewHolder> mAdapter;
    private List<WXModel> mList = new ArrayList<>();

    Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_default);
        mRealm = Realm.getDefaultInstance();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_good) {
            @Override
            protected void convert(BaseViewHolder helper, WXModel item) {
                helper.setText(R.id.item_wx_list_name, item.getName_game())
                        .setText(R.id.item_wx_list_value, item.getTrend() == 99 ? "" : item.getTrend() + "")
                        .setText(R.id.item_wx_list_value2, item.getGood() == 99 ? "" : item.getGood() + "")
                        .setText(R.id.item_wx_list_value3, item.getParent())
                ;
            }
        };
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, WxInfoActivity.class);
                intent.putExtra("name", mAdapter.getData().get(position).getName_game());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        mAdapter.setNewData(mRealm.where(WXModel.class).findAll());
    }
}
