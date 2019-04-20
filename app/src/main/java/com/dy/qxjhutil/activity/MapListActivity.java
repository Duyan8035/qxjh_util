package com.dy.qxjhutil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.SpanUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.MapModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.dy.qxjhutil.util.Utils;

public class MapListActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private BaseQuickAdapter<MapModel, BaseViewHolder> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_list);

        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.act_map_list_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mAdapter = new BaseQuickAdapter<MapModel, BaseViewHolder>(R.layout.item_map_main) {
            @Override
            protected void convert(BaseViewHolder helper, MapModel item) {
                helper.setText(R.id.item_map_main_tv, item.getMapName())
                ;
                if (item.getFuModel1() != null) {
                    SpanUtils spanUtils = new SpanUtils();
                    spanUtils.append(item.getFuModel1().getName() + " : ");
                    spanUtils.append(Utils.getGood(item.getFuModel1().getGoodMin()));
                    spanUtils.append(Utils.getTrend(item.getFuModel1().getTrendMin()));
                    spanUtils.append(item.getFuModel1().getWx_parent().getName_game());
                    helper.setText(R.id.item_map_main_tv_kf_1, spanUtils.create());
                }

                if (item.getFuModel2() != null) {
                    SpanUtils spanUtils = new SpanUtils();
                    spanUtils.append(item.getFuModel2().getName() + " : ");
                    spanUtils.append(Utils.getGood(item.getFuModel2().getGoodMin()));
                    spanUtils.append(Utils.getTrend(item.getFuModel2().getTrendMin()));
                    spanUtils.append(item.getFuModel2().getWx_parent().getName_game());
                    helper.setText(R.id.item_map_main_tv_kf_2, spanUtils.create());
                }
            }
        };
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, MapDetailsActivity.class);
                intent.putExtra("map", mAdapter.getItem(position).getMapName());
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(RealmHelper.getInstance(mContext).where(MapModel.class).findAll());
    }
}
