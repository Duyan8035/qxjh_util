package com.dy.qxjhutil.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;

public class Test1Activity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private BaseQuickAdapter<String, BaseViewHolder> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text1);

        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.act_main_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_test1) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.item_text, item);
            }
        };
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setNewData();
    }
}
